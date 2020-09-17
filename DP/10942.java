import java.util.*;
import java.io.*;


public class Main {

    //static int arr[];
    
    static int n;   
    static int arr[];
    static int dp[][];
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        n=Integer.parseInt(br.readLine());

        arr=new int[n];
        dp =new int[n][n];
       String in[]=br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(in[i]);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        int num = Integer.parseInt(br.readLine());
        for(int i=0;i<num;i++){
            in=br.readLine().split(" ");
            int a=Integer.parseInt(in[0]);
            int b=Integer.parseInt(in[1]);
            bw.write(dfs(a-1,b-1)+"\n");
        }
        bw.flush();
        bw.close();       
    }
    static int dfs(int start,int end){
        int re=0;
        if(start>end){
            return 0;
        }
        if(dp[start][end]>-1){
            return dp[start][end];
        }
        if(start==end||(end-start==1)){
            if(arr[start]==arr[end]){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(arr[start]==arr[end]){
            re=dfs(start+1,end-1);
        }
        else{
            re=0;
        }
        return dp[start][end]=re;
    }
    
}