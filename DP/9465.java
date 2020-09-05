
import java.util.*;
import java.io.*;


public class Main {
    
    static int arr[][];
    static int dp[][];
    static int result=0;
    static int n;
    public static void main(String[] args) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String s1[];
        String s2[];
        int num = Integer.parseInt(br.readLine());
        
        while(num!=0){
            result = 0;
            n=Integer.parseInt(br.readLine());
            arr=new int[n][2];
            dp= new int[n][2];
            s1=br.readLine().split(" ");
            s2=br.readLine().split(" ");

            for(int i=0;i<n;i++){
                arr[i][0]=Integer.parseInt(s1[i]);
                arr[i][1]=Integer.parseInt(s2[i]);
                dp[i][0]=-1;
                dp[i][1]=-1;
            }   
            dfs(0,0);
            dfs(0,1);
            System.out.println(result);           
            num--;
        }

    }
    static int dfs(int row,int col){
       int max= 0;
        if(row>=n){
            return 0;
        }
        if(dp[row][col]>=0){
            return dp[row][col];
        }
        max=Math.max(max,arr[row][col]+dfs(row+1,Math.abs(col-1)));
        max=Math.max(max,arr[row][col]+dfs(row+2,col));
        max=Math.max(max,arr[row][col]+dfs(row+2,Math.abs(col-1)));
        result=Math.max(result,max);
        return dp[row][col]=max;
    }
}class 9465 {
    
}
