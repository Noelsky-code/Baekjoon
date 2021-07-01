import java.util.*;



import java.io.*;

public class Main {
// 1987, 알파벳 
    static int move[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    static HashSet<String> set;
    static int answer;
    static int r;
    static int c;
    static String[] board;
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(Scolstem.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        set = new HashSet<String>();
        answer=0;
        String in[] = br.readLine().split(" ");
        r = Integer.parseInt(in[0]);
        c = Integer.parseInt(in[1]);

        
        board = new String[r];
        for(int i=0;i<r;i++){
            board[i]=br.readLine();
        }
        dfs(Character.toString(board[0].charAt(0)),0,0,1);
        System.out.println(answer);

    }
    static void dfs(String visit,int row,int col,int cnt){
       
        answer = Math.max(cnt,answer);
        for(int i=0;i<4;i++){
            int n_row = row+move[i][0];
            int n_col = col+move[i][1];
            if(n_row>=0&&n_row<r&&n_col>=0&&n_col<c){
                if(!visit.contains(Character.toString(board[n_row].charAt(n_col)))){
                    dfs(visit+Character.toString(board[n_row].charAt(n_col)),n_row,n_col,cnt+1);
                }
                
            }
        }
    }
}
