
import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
    static int n;
    static int m;
    static BigInteger dp[][];
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String s[]= br.readLine().split(" ");
        n= Integer.parseInt(s[0]);
        m= Integer.parseInt(s[1]);
        dp=new BigInteger[n+1][m+1];
        System.out.println(combi(n,m));

    }
    static BigInteger combi(int a,int b){
       
        if(dp[a][b]!=null){
            return dp[a][b];
        }
        if(a==b||b==0){
            return dp[a][b]=BigInteger.ONE;            
        }
        dp[a][b]=new BigInteger("0");
    
        if(a==b+1||b==1){
            return dp[a][b]=dp[a][b].add(BigInteger.valueOf(a));
        }
        return dp[a][b]=dp[a][b].add(combi(a-1,b-1)).add(combi(a-1,b));

    }
}