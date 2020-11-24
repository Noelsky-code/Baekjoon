// 1562 계단수 

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static long dp[][][];
    static long div = 1000000000;
        public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        n = Integer.parseInt(br.readLine());
        dp= new long[n][10][1<<10];
        for(int i=0;i<n;i++){
            for(int k=0;k<10;k++){
                for(int j=0;j<(1<<10);j++){
                    dp[i][k][j]=-1;
                }
            }
        }
        long ans = 0;
        for(int i=1;i<=9;i++){
            ans+=dfs(0,i,1<<i,false)%div;
        }

        System.out.println(ans%div);
        /*for(int i=0;i<10;i++){
            for(int j=0;j<n;j++){
                System.out.printf("%d ",dp[i][j]);
            }
            System.out.println();
        }*/

    }
    static long dfs(int cnt,int num,int bit,boolean zero){//cnt = 현재위치 , num = 이전 숫자 
        int bit_t = bit|(1<<num);
        long ret=0;
        
        if(num==0){
            zero=true;
        }

        if(cnt==n-1){
            if(((bit_t&((1<<10)-1))==((1<<10)-1))&&zero){//10개 다 썻다면
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[cnt][num][bit_t]!=-1){
            return dp[cnt][num][bit_t]%div;
        }
        if(num==0){
            ret=dfs(cnt+1,num+1,bit_t,zero)%div;
            return dp[cnt][num][bit_t]=ret%div;
        }
        if(num==9){
            ret=dfs(cnt+1,num-1,bit_t,zero);
            return dp[cnt][num][bit_t]=ret%div;
        }
        ret=(dfs(cnt+1,num+1,bit_t,zero)%div+dfs(cnt+1,num-1,bit_t,zero)%div)%div;
        return dp[cnt][num][bit_t]=ret%div;
    }
}
