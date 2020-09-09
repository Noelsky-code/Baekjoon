import java.util.*;
import java.io.*;


public class Main {

    static int arr[];
    static int dp[];
    static int result=0;
    static int num;
    //static int n;
    //static int m;

    public static void main(final String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        num = Integer.parseInt(br.readLine());
        dp = new int[num+1];
        arr = new int[num+1];
        String s[] = br.readLine().split(" ");
        
        for(int i=1;i<=num;i++){
            arr[i]=Integer.parseInt(s[i-1]);
            dp[i]=-1;
        }
        arr[0]= 1001;
        dfs(0);
        System.out.println(result);
    
    }
    static int dfs(int in){
        int max=0;
        
        if(dp[in]>0){
            return dp[in];
        }
       
        for(int i=in+1;i<=num;i++){
            if(i==4){
                int k=0;
            }
            if(arr[i]<arr[in]){
                max=Math.max(max,1+dfs(i));
            }           
        }
        result=Math.max(max,result);
        return dp[in]=max;
    }
}
