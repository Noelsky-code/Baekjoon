
//백준 2098 외판원 순회 
import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int arr[][];
    static int dp[][];
        public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        n = Integer.parseInt(br.readLine());
        arr= new int[n][n];
        dp = new int[n][1<<n];
        for(int i=0;i<n;i++){
            for(int j=0;j<(1<<n);j++){
                dp[i][j]=-1;
            }
        }
        String s[];
        for(int i=0;i<n;i++){
            s=br.readLine().split(" ");
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(s[j]);
            }
        }
     
        System.out.println(dfs(0,1));
        
        
    }
    static int dfs(int now,int visit){

        int min = 100000000;
        if(dp[now][visit]!=-1){//방문 했던 곳
            return dp[now][visit];
        }
        
        if(visit==(1<<n)-1){//모두 방문 했을 시 
            if(arr[now][0]!=0){//마지막 도시에서 출발점으로 돌아갈수 있으면
                return arr[now][0];
            }
            else{
                return 10000001;//방문 할수 없을 경우 매우 큰 값 리턴
            }
        }
        
        for(int i=0;i<n;i++){
            if(arr[now][i]!=0&&(visit&(1<<i))==0){//이동 가능하고 방문 했던 곳이 아니라면  
                min=Math.min(min,arr[now][i]+dfs(i,visit|(1<<i)));
            }
        }
     
        return dp[now][visit]=min;
    }

}
