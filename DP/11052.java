import java.util.*;
import java.io.*;


public class Main {
    static int num;
    static int arr[];
    static int dp[][];
    static int result=0;
    public static void main(String[] args) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String s[];
        int num = Integer.parseInt(br.readLine());
        arr=new int[num];
        dp=new int[num][num];
        s=br.readLine().split(" ");
        for(int i=0;i<num;i++){
            arr[i]=Integer.parseInt(s[i]);
            for(int j=0;j<num;j++){
                dp[i][j]=0;
            }
        }
        for(int i=0;i<num;i++){
            buy(i,0);
        }
        System.out.println(result);
    }
    static int buy(int in,int cnt){
        int max=0;
        if(cnt>num){
            return 0;
        }
        if(dp[in][cnt]!=0){
            return dp[in][cnt];
        }
        for(int i=in;i<num;i++){
           max=Math.max(max,arr[in]+buy(i,cnt+1)); 
        }
        result=Math.max(max,result);
        return dp[in][cnt]= max;
    }
}