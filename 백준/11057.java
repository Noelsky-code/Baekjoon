import java.util.*;
import java.io.*;


public class Main {

    //static int arr[][];
    static long dp[][];
    static long result=0;
    static int num;
    //static int n;
    //static int m;

    public static void main(String[] args) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        num= Integer.parseInt(br.readLine());
        dp=new long[10][num];
        for(int i=0;i<10;i++){
            result+=dfs(i,0)%10007;           
        }
        System.out.println(result%10007);
        }
    
    static long dfs(int row,int col){
        long ans = 0;
        if(col>=num-1){
            return 1;
        }
        if(dp[row][col]!=0){
            return dp[row][col];
        }
        for(int i=row;i<10;i++){
            ans+=dfs(i,col+1)%10007;
        }
        return dp[row][col]= ans%10007;
    }

}