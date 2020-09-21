import java.util.*;
import java.io.*;


public class Main {

    //static int arr[];
    static int arr[][];
    static int n;
    static int m;
    static int dp[][];
    static int a[][]={
        {1,0},{-1,0},{0,1},{0,-1}
    };
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String s[]=br.readLine().split(" ");
        n=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);
        arr=new int[n][m];
        dp= new int[n][m];
        for(int i=0;i<n;i++){
            s=br.readLine().split(" ");
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(s[j]);
                dp[i][j]=-1;
            }
        }
        System.out.println(dfs(0,0));
    }
    static int dfs(int row,int col){
        int sum=0;
        if(dp[row][col]>-1){
            return dp[row][col];
        }
        if(row>n||row<0||col>m||col<0){
            return 0;
        }
        if(row==n-1&&col==m-1){
            return 1;
        }
        for(int i=0;i<4;i++){
            if(row+a[i][0]>=0&&row+a[i][0]<n&&col+a[i][1]>=0&&col+a[i][1]<m){
                if(arr[row][col]>arr[row+a[i][0]][col+a[i][1]]){
                  sum+=dfs(row+a[i][0],col+a[i][1]);
                }
            }
        }
        return dp[row][col]=sum;
    }
    
}