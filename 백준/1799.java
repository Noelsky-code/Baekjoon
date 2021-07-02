import java.util.*;
import java.io.*;

public class Main {
    //1799, 비숍 
    // 시간 제한 10초 
    static int[][] board;
    static int answer;
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(Scolstem.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        answer=0;
        for(int i=0;i<n;i++){
            String in[] = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                board[i][j] = Integer.parseInt(in[j]);
            }
        }
        dfs(0,n,0);
        System.out.println(answer);
        
    }
    static void dfs(int row,int n,int cnt){
        int num = 0; 
        if(row==2*n){
            answer=Math.max(cnt,answer);
            return;
        }
        if(row<n){
            for(int x=0;row-x>=0;x++){
                if(board[row-x][x]==1&&check(row-x,x,n)){
                    board[row-x][x]=2;
                    num++; //놓은 갯수 
                    dfs(row+1,n,cnt+1);
                    board[row-x][x]=1;
                    
                }
            }
        }
        else if(row<2*n-1){
            for(int x = row-n+1;row-x>=row-n+1;x++){
                if(board[row-x][x]==1&&check(row-x,x,n)){
                    num++;
                    board[row-x][x]=2;
                    dfs(row+1,n,cnt+1);
                    board[row-x][x]=1;
                }
            }            
        }
        if(num==0){
            dfs(row+1,n,cnt);//비숍을 놓지 않았을 떄 
        }
    }
    static boolean check(int x,int y,int n){
        int x_t = x;
        int y_t = y;
        while(x_t>=0&&y_t>=0){//대각선 왼쪽 위 
            if(board[x_t][y_t]==2){
                return false;
            }
            x_t--;
            y_t--;
        }
        x_t = x;
        y_t = y;
        while(x_t<n&&y_t<n){//대각선 오른쪽 아래
            if(board[x_t][y_t]==2){
                return false;
            }
            x_t++;
            y_t++;
        }
        x_t = x;
        y_t = y;
        while(x_t<n&&y_t>=0){//대각선 오른쪽 위
            if(board[x_t][y_t]==2){
                return false;
            }
            x_t++;
            y_t--;
        }
        x_t = x;
        y_t = y;
        while(x_t>=0&&y_t<n){//대각선 왼쪽 아래
            if(board[x_t][y_t]==2){
                return false;
            }
            x_t--;
            y_t++;
        }
        return true;
    }
}