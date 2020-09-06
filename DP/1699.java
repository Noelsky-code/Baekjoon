import java.util.*;
import java.io.*;


public class Main {

    //static int arr[][];
    static int dp[];
    static int result=0;
    static int num;
    //static int n;
    //static int m;

    public static void main(String[] args) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        num=Integer.parseInt(br.readLine());
        dp=new int[num+1];
        for(int i=1;i<=num;i++){
            dp[i]=0;
        }
        for(int i=1;i<num;i++){
            dfs(i);
        }
        System.out.println(dfs(num));
    }
    static int dfs(int n){
        double sqrt = Math.sqrt(n);
        int min = 10000000;

        if(dp[n]!=0){
            return dp[n];
        }
        if(sqrt==(int)sqrt){
            return 1;
        }
        for(int i=1;i*i<=n;i++){
            int ans= 0;
            ans+=1+dfs(n-i*i);
            min=Math.min(min,ans);
        }
    return dp[n]=min;       
    }
}