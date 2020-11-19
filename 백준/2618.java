
//백준 2618 경찰차  
import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int dp[][];
    static Case c[];
    static int choice[][];
        public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dp=new int[m+2][m+2];
        c=new Case[m+2];
        choice = new int[m+2][m+2];

        String s[];
        for(int i=2;i<=m+1;i++){
            s=br.readLine().split(" ");
            c[i]=new Case(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
        }
        c[0]=new Case(1,1);
        c[1]= new Case(n,n);
        for(int i=0;i<m+2;i++){
            for(int j=0;j<m+2;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(dfs(0,1));
        for(int i=0,j=1;Math.max(i,j)+1<m+2;){
            System.out.println(choice[i][j]);
            if(choice[i][j]==1){
                i=Math.max(i,j)+1;
            }
            else{
                j=Math.max(i,j)+1;
            }
        }
        


    }
        static int dfs(int x,int y){//x = 1경찰차 위치 , y = 2경찰차 위치 
            
            int next = Math.max(x,y)+1;//다음 사건 위치 
            if(next==m+2){
                return 0;
            }
            if(dp[x][y]!=-1){
                return dp[x][y];
            }
            
            //첫번째 경찰차가 다음 사건 해결할 경우 
            int a = dfs(next,y)+ Math.abs(c[x].row-c[next].row)+Math.abs(c[x].col-c[next].col);
            //두번째 경찰차가 다음 사건 해결할 경우
            int b = dfs(x,next)+ Math.abs(c[y].row-c[next].row)+Math.abs(c[y].col-c[next].col);
            
            if(a<b){//첫번째 차가 이득일 경우 
               
                choice[x][y]=1;
            }
            else{ // 두번째 차가 이득일 경우 
                
                choice[x][y]=2;
            }
            return dp[x][y]=Math.min(a,b);
        }
}

class Case{
    int row;
    int col;
    public Case(int row,int col){
        this.row=row;
        this.col=col;
    }

}