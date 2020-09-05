import java.util.*;
import java.io.*;


public class Main {

    //static int arr[][];
    static int dp[][];
    static int result=0;
    static int num;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        num= Integer.parseInt(br.readLine());
        while(num--!=0){
            String s[] = br.readLine().split(" ");
            n=Integer.parseInt(s[0]);
            m=Integer.parseInt(s[1]); 
            dp=new int[n+1][m+1];
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    dp[i][j]=0;
                }
            }
            System.out.println(dfs(n,m));
        }
    }
    static int dfs(int row,int col){
        int ans = 0;
        if(col-row<0){
            return 0;
        } 
              
        if(row==1){
            return col;
        }
        if(dp[row][col]!=0){
            return dp[row][col];
        }       
        for(int i=1;i<col;i++){
            ans += dfs(row-1,col-i);           
        }
        return dp[row][col]=ans;
        }

}