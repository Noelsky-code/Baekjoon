import java.util.*;
import java.io.*;


public class Main {

    static int arr[][];
    static int dp[][];
    static int result=0;
    static int num;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String s[]= br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr= new int[n+1][m+1];
        dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            String str[] = br.readLine().split(" ");
            for(int j=1;j<=m;j++){
                arr[i][j]=Integer.parseInt(str[j-1]);
                dp[i][j]=-1;
            }
        }
        System.out.println(dfs(1,1));
    }
    static int dfs(int row,int col){
        int max=0;
        if(row>n||col>m){
            return 0;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        max=Math.max(arr[row][col]+dfs(row+1,col),max);
        max=Math.max(arr[row][col]+dfs(row,col+1),max);
        max=Math.max(arr[row][col]+dfs(row+1,col+1),max);
        if(max==-1){
            return dp[row][col]=0;
        }
        return dp[row][col]=max;
    }
}