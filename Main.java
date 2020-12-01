// 2169, 로봇 조종하기  

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int arr[][];
    static int dp[][][];
    static int move[][] = {{1,0},{0,-1},{0,1}};
    static boolean visit[][];

    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String s[]=br.readLine().split(" ");
        n=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);
        arr=new int[n][m];
        dp=new int[n][m][3];
        visit = new boolean[n][m];
       
        for(int i=0;i<n;i++){
            s=br.readLine().split(" ");
            for(int j=0;j<m;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=-1000001;
                }
                arr[i][j]=Integer.parseInt(s[j]);
                visit[i][j]=false;
            }
        }
        System.out.println(robot(0,0,0));
    }
    
    //0: 위에서 오는거 1: 왼쪽 2:오른쪽 
    static int robot(int row,int col,int way){
        visit[row][col]=true;
        if(row==n-1&&col==m-1){//도착
            visit[row][col]=false;
            return arr[row][col];
        }
        
        if(dp[row][col][way]!=-1000001){
            visit[row][col]=false;
            return dp[row][col][way];
        }
       /* if(row>=n||col<0||col>=m){//벗어 날 시 
            return 0;
        }*/
        int ret=-1000001;
        for(int i=0;i<3;i++){
            int n_row = row +move[i][0];
            int n_col = col+move[i][1];
            if(n_row<n&&n_col>=0&&n_col<m){
                if(!visit[n_row][n_col]){
                    ret=Math.max(ret,arr[row][col]+robot(n_row,n_col,i));
                }
            }
        }
        visit[row][col]=false;//방문 후 풀어줌 
        return dp[row][col][way]=ret;

        }
 }

