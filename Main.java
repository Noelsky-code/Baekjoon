import java.util.*;
import java.io.*;

public class Main {
    
//14502 연구소 , 골드 5 문제 
//벽 3개를 꼭 세워야함 
//0 빈칸 1 벽 2 바이러스 
// 브루트 포스 -> 64 칸에 대해 벽3개 세운후 안전 공간 계산 .. 별로 안할듯 . 
    static int[][] arr;
    static ArrayList<Point> virus;
    static ArrayList<Point> blank;
    static int[][] move = {{1,0},{-1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        String s[]=br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        arr = new int[n][m];
        virus = new ArrayList<Point>();// 바이러스 위치 지정
        blank = new ArrayList<Point>();//빈 공간 지정 
        
        for(int i=0;i<n;i++){
            s=br.readLine().split(" ");
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(s[j]);
                if(arr[i][j]==2){
                    virus.add(new Point(i,j));
                }
                else if(arr[i][j]==0){
                    blank.add(new Point(i,j));
                }
            }
        }
        make_combi();
        
    }
    static void make_combi(){
        int size = blank.size();
        for(int i=0;i<size-2;i++){
            for(int j=i+1;j<size-1;j++){
                for(int k=j+1;k<size;k++){
                    
                }
            }
        }
    }
    static void spread(Point a, Point b, Point c){//a,b,c는 벽을 쌓는곳 . 
        arr[a.y][a.x] = 1;
        arr[b.y][b.x] = 1;
        arr[c.y][c.x] = 1;
        Queue<Point> queue = new LinkedList<Point>();
        for(int i=0;i<virus.size();i++){
           
        }
        
        while(!queue.isEmpty()){
            
        }

        arr[a.y][a.x] = 0;
        arr[b.y][b.x] = 0;
        arr[c.y][c.x] = 0;
        

    }
    static boolean is_spread(int row,int col){ //퍼질 수 있다면 
        if(row<0||row>=arr.length||col<0||col>=arr[0].length)return false;
        if(arr[row][col]==1||arr[row][col]==2)return false;
        return true;
    }
    
}

class Point{
    int x;
    int y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;

    }

}

