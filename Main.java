import java.util.*;
import java.io.*;


public class Main {
    
    public static void main(String[] args) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String s[];
        int num = Integer.parseInt(br.readLine());
        int arr[][]= new int[num][2];
        for(int i=0;i<num;i++){
            s=br.readLine().split(" ");
            arr[i][0]=Integer.parseInt(s[0]);//시간
            arr[i][1]=Integer.parseInt(s[1]);//금액
        }

        int dp[]= new int[num+1];
        int result= 0;
        for(int i=0;i<num;i++){
            if(i+arr[i][0]<=num){
                dp[i+arr[i][0]]=Math.max(dp[i+arr[i][0]],dp[i]+arr[i][1]);
                result = Math.max(result,dp[i+arr[i][0]]);
            }
            dp[i+1]=Math.max(dp[i+1],dp[i]);
            result=Math.max(result,dp[i+1]);

        }
        System.out.println(result);
        

    }
}