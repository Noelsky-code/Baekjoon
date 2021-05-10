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
    static int answer;
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(Scolstem.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        String s[]=br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        arr = new int[n][m];
        virus = new ArrayList<Point>();// 바이러스 위치 지정
        blank = new ArrayList<Point>();//빈 공간 지정 
        answer=0;

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
        System.out.println(answer);
        
    }
    static void make_combi(){
        int size = blank.size();
        for(int i=0;i<size-2;i++){// size -3 size -2 size -1 
            for(int j=i+1;j<size-1;j++){
                for(int k=j+1;k<size;k++){
                    spread(blank.get(i),blank.get(j),blank.get(k));
                }
            }
        }
    }
    static void spread(Point a, Point b, Point c){//a,b,c는 벽을 쌓는곳 . 
        arr[a.row][a.col] = 1;
        arr[b.row][b.col] = 1;
        arr[c.row][c.col] = 1;
        Queue<Point> queue = new LinkedList<Point>();
        boolean[][] visit = new boolean[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1||arr[i][j]==2)visit[i][j]=true;
            }
        }
    

        for(int i=0;i<virus.size();i++){
            queue.add(virus.get(i));
        }
        
        while(!queue.isEmpty()){
            Point temp = queue.poll();
            for(int i=0;i<4;i++){
                int row = temp.row+move[i][0];
                int col = temp.col+move[i][1];
                if(is_spread(row,col)){
                    if(!visit[row][col]){
                        visit[row][col]=true;
                        queue.add(new Point(row,col));
                    }
                }
            }
        }
        int sum=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(!visit[i][j]){
                    sum++;  
                }
            }
        }
        answer=Math.max(sum,answer);

        arr[a.row][a.col] = 0;
        arr[b.row][b.col] = 0;
        arr[c.row][c.col] = 0;
        

    }
    static boolean is_spread(int row,int col){ //퍼질 수 있다면 
        if(row<0||row>=arr.length||col<0||col>=arr[0].length)return false;
        return true;
    
    }
    
}

class Point{
    int row;
    int col;
    public Point(int row,int col){
        this.row = row;
        this.col = col;

    }

}

