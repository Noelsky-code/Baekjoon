
//백준 1102 발전소 

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int p;
    static int arr[][];
    static int dp[];
        public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        n = Integer.parseInt(br.readLine());
        String s[];
        arr=new int[n][n];
        dp= new int[1<<n];
        for(int i=0;i<n;i++){
            s=br.readLine().split(" ");
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(s[j]);
            }
        }
        String in=br.readLine();
        int on=0 ;//Y의 갯수 
        p =Integer.parseInt(br.readLine());//적어도 p개 고장 x
         
        int visit=0;//계속 틀린 포인트  1로 주면 안됨. 1이면 이미 방문한것
        for(int i=0;i<n;i++){
            if(in.charAt(i)=='Y'){
                on++;
                visit=visit|(1<<i);
            }
        }
        //System.out.println(visit);

        for(int j=0;j<(1<<n);j++){
            dp[j]=-1;
        }
        int must = p-on;//must = 켜야하는 발전기 수 
        if(on==0){
            if(p==0){
                System.out.println("0");
            }
            else{
                System.out.println("-1");
            }
        }
        else if(on>=p){
            System.out.println("0");
        }
        else{
        //int min= Integer.MAX_VALUE;
        System.out.println(dfs(visit,on));
    
        }  
    }

    static int dfs(int visit,int num){
        
        int min= Integer.MAX_VALUE;
       
        if(num==p){//더이상 킬게 없는 경우 
            return 0;
        }
        if(dp[visit]!=-1){//방문 했던 경우 
            return dp[visit];
        }
        for(int i=0;i<n;i++){
            if((visit&(1<<i))!=0){//Y인 곳에서 
                for(int j=0;j<n;j++){
                    if(i==j)continue;
                    if((visit&(1<<j))==0){//N인 곳을 가면 
                        min=Math.min(min,arr[i][j]+dfs(visit|(1<<j),num+1));
                    }
                }
            } 
        }
        return dp[visit]=min;
    }

}



// 구글링 하기 전 원래 코드 . visit = 1 로 삽질함 
/*

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
        String s[];
        arr=new int[n][n];
        dp= new int[n][1<<n];
        for(int i=0;i<n;i++){
            s=br.readLine().split(" ");
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(s[j]);
            }
        }
        String in=br.readLine();
        int on=0 ;//Y의 갯수 
        int p =Integer.parseInt(br.readLine());//적어도 p개 고장 x
         
        int visit=0;
        for(int i=0;i<in.length();i++){
            if(in.charAt(i)=='Y'){
                on++;
                visit=visit|(1<<i);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<(1<<n);j++){
                dp[i][j]=-1;
            }
        }
        int must = p-on;//must = 켜야하는 발전기 수 
        if(must<=0){//킬 필요가 없을경우0 출력후  종료 
            System.out.println(0);
            return;
        }
        if(on==0){//킬수 없는 경우 (0,0 이면 위에서 걸러짐) 
            System.out.println(-1);
            return;
        }  
        //int min= Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if((visit&(1<<i))!=0){//가장 첫번째의 Y인 곳에서 출발 
                System.out.println(dfs(i,visit,must));
                break;
            }
        }  
    }

    static int dfs(int next,int visit,int must){
        //dp[next][visit] = visit 값일때 next를 방문할때 드는 최소비용  
        int min= Integer.MAX_VALUE;
       
        if(must==0){//더이상 킬게 없는 경우 
            return 0;
        }
        if(dp[next][visit]!=-1){//방문 했던 경우 
            return dp[next][visit];
        }
        for(int i=0;i<n;i++){
            if((visit&(1<<i))!=0){//Y인 곳에서 
                for(int j=0;j<n;j++){
                    if((visit&(1<<j))==0){//N인 곳을 가면 
                        min=Math.min(min,arr[i][j]+dfs(j,visit|(1<<j),must-1));
                    }
                }
            } 
        }
        return dp[next][visit]=min;
    }

}
*/