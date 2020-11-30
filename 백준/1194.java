// 1194, 달이 차오른다 ,가자. 

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static String arr[];
    //static int dp[][][];
    static boolean visit[][][];
    static int INF = 1000000000;
    static int move[][] = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String s[]=br.readLine().split(" ");
        n=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);
        arr=new String[n];
       // dp= new int[n][m][1<<7];
        visit= new boolean[n][m][1<<7];
        for(int i=0;i<n;i++){
            arr[i]=br.readLine();
        }
        Queue<Point> queue = new LinkedList<Point>();
        int row=0;
        int col=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i].charAt(j)=='0'){
                    queue.add(new Point(i,j,1,0));
                    visit[i][j][1]=true;  
                    break;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<(1<<7);k++){
                   // dp[i][j][k]=INF;
                    visit[i][j][k]=false;
                }
            }
        }

        while(!queue.isEmpty()){
            Point p = queue.poll();
            row=p.row;
            col=p.col;
            int key= p.key;
            
            char now = arr[row].charAt(col);
            if(now=='1'){//출구일 경우
                System.out.println(p.ans);
                return;
            }
            else if(now=='#'){//벽 일 경우
                continue;
            }  
            else if(now-'A'>=0&&now-'A'<=5){//문 일경우
                if((key&(1<<(now-'A'+1)))==0){//열쇠가 없을경우 
                    continue;
                }
            }
            else if(now-'a'>=0&&now-'a'<=5){//키 일 경우
                key=key|(1<<(now-'a'+1));
            }
            for(int i=0;i<4;i++){
                int n_row= row+move[i][0];
                int n_col= col+move[i][1];
                if(n_row>=0&&n_row<n&&n_col>=0&&n_col<m&&!visit[n_row][n_col][key]){
                    queue.add(new Point(n_row,n_col,key,p.ans+1));
                    visit[n_row][n_col][key]=true;  
                }
            }
            
        }
        System.out.println(-1);
    }

    
}

class Point{
    int row;
    int col;
    int key;
    int ans;

    public Point(int row,int col,int key,int ans){
        this.row=row;
        this.col=col;
        this.key =key;
        this.ans =ans;
    }
}
