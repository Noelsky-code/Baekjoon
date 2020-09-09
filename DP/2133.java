import java.util.*;
import java.io.*;


public class Main {

    //static int arr[][];
    static int dp[];
    //static int result=0;
    static int num;
    //static int n;
    //static int m;

    public static void main(final String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        num = Integer.parseInt(br.readLine());
        dp = new int[num+1];
        if(num%2==0){
            dp[2]=3;
            for(int i=4;i<=num;i+=2){
                for(int j=i-4;j>0;j-=2){
                    dp[i]+=dp[j]*2;//매 단계의 새로운거 앞에 붙이는것
                }
                dp[i]+=dp[i-2]*3+2;
            }
        }
        System.out.println(dp[num]);
        
    }
}