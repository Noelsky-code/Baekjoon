// 1708, 볼록껍질 컨벡스 헐 알고리즘 

import java.util.*;
import java.io.*;

public class Main {
    

    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int n = Integer.parseInt(br.readLine());
        Point[] point = new Point[n];
        for(int i=0;i<n;i++){
            String[] in = br.readLine().split(" ");
            point[i]=new Point(Long.parseLong(in[0]),Long.parseLong(in[1]));
        }
        Arrays.sort(point,new Comparator<Point>(){

            @Override
            public int compare(Point o1, Point o2) {
                // TODO Auto-generated method stub
                if(o1.y==o2.y){
                    return Long.compare(o1.x,o2.x);
                }
                return Long.compare(o1.y,o2.y);
            }

        });
        Stack<Point> stack = new Stack<Point>();
        stack.push(point[0]);// y좌표 제일 작은 거 스택에 푸쉬 

        Arrays.sort(point,new Comparator<Point>(){

            @Override
            public int compare(Point o1, Point o2) {
                // TODO Auto-generated method stub
                int temp = ccw(point[0],o1,o2);
                if(temp>0)return -1;
                if(temp<0)return 1;//우회전 -> 각도 더작음 
                long dist1= dist(point[0],o1);// 각도 같으면 더 멀리있는게 먼저
                long dist2= dist(point[0],o2);
                if(dist1>dist2)return 1;
                return -1;
            }
        });//반시계 방향 정렬 
        stack.push(point[1]);
        int now=2;
        while(now!=n){//모든 점 다 search 할때까지 
            Point temp = point[now];//현재 점 

            while(stack.size()>=2){//스택에 2개 이상 있을 떄 
                Point second = stack.pop();
                Point first = stack.pop();
                if(ccw(first,second,temp)>0){//temp가 조건을 만족할경우 
                    stack.push(first);
                    stack.push(second);
                    break;
                    //stack.push(temp);
                }
                else{
                   stack.push(first);//first 를 넣고 다시한번 while문 돔   
                }
            }
            stack.push(temp);//2개 미만일 경우 or 조건을 만족하는경우 넣어줌 

            now++;
        }
        System.out.println(stack.size());
    
    }
    static public int ccw(Point a,Point b, Point c){//ccw 외적 .. 세점의 방향성 양수 -> 왼쪽으로  음수 -> 오른쪽 
        long temp = (b.x-a.x)*(c.y-a.y)-(b.y-a.y)*(c.x-a.x);
        if(temp>0)return 1;
        if(temp<0)return -1;
        return 0;
    }
    static public long dist(Point a, Point b){
        return (a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y);
    }
 }

 class Point{
     long x;
     long y;
     
    public Point(long x, long y) {
         this.x=x;
         this.y=y;
     }
 }
