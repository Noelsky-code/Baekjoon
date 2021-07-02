import java.util.*;
import java.io.*;

public class Main {
// 13460, 구슬 탈출2
// . : 빈칸 , #: 벽, o : 구멍 
// 외각이 벽이므로 index 걱정은 안해도됨
    static String[] board;
    static int o_row;//구멍의 위치
    static int o_col;
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(Scolstem.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        o_row = 0;
        o_col = 0;
        board = new String[n];
        for(int i=0;i<n;i++){
            board[i] = br.readLine();
        }
        Queue<Balls> queue = new LinkedList<Balls>();//볼의 위치 담을 큐 
        board=clean_board(queue);// 큐에 Balls 추가 후 board 에 R,B 지움
        int answer=-1;
        boolean end = true;// while문 빠져나오기 위해 
        while(!queue.isEmpty()&&end){//bfs 
            Balls poll = queue.poll();
            for(int i=0;i<4;i++){
                Ball red = move(i,poll.red);//이동한 볼 
                Ball blue = move(i,poll.blue);//이동한 볼
                if(check(red)&&!check(blue)){
                    answer = poll.cnt+1;
                    end = false;
                    break;
                } 
                else if(!check(blue)&&poll.cnt+1<=9){//파란공이 안빠졋을 때
                    if(red.row==blue.row&&red.col==blue.col){//둘이 겹쳐버릴때 .. 흠 ... , 하드 코딩 
                        move_one(i,poll,red,blue);//겹침 처리 
                    } 
                    queue.add(new Balls(red,blue,poll.cnt+1));
                }
            }    
            
        }
        System.out.println(answer);
    }
    static void move_one(int i, Balls poll, Ball red, Ball blue){
        if(i==0){
            if(poll.red.col<poll.blue.col){
                blue.col++;
            }
            else{
                red.col++;
            }
        }
        else if(i==1){
            if(poll.red.col<poll.blue.col){
                red.col--;
            }
            else{
                blue.col--;
            }
        }
        else if(i==2){
            if(poll.red.row<poll.blue.row){
                blue.row++;
            }
            else{
                red.row++;
            }
        }
        else if(i==3){
            if(poll.red.row<poll.blue.row){
                red.row--;
            }
            else{
                blue.row--;
            }

        }

    }
    static boolean check(Ball ball){//구멍인지 아닌지 체크 
    
        return ball.row==o_row&&ball.col==o_col;

    }
    static Ball move(int n,Ball ball){
        Ball ret = new Ball(-1,-1);
        if(n==0){
            ret = move_left(ball.row,ball.col);
        }
        else if(n==1){
            ret = move_right(ball.row,ball.col);
        }
        else if(n==2){
            ret = move_up(ball.row,ball.col);
        }
        else if(n==3){
            ret = move_down(ball.row,ball.col);
        }
        return ret;

    }

    static Ball move_left(int row,int col){
        Ball ret = new Ball(-1,-1);

        while(board[row].charAt(col)=='.'){
            col--;
        }
        if(board[row].charAt(col)=='O'){
            ret=new Ball(row,col);
        }
        else{
            ret=new Ball(row,col+1);
        }


        return ret;
    }
    static Ball move_right(int row,int col){
        Ball ret = new Ball(-1,-1);

        while(board[row].charAt(col)=='.'){
            col++;
        }
        if(board[row].charAt(col)=='O'){
            ret=new Ball(row,col);
        }
        else{
            ret=new Ball(row,col-1);
        }

        return ret;
    }
    static Ball move_up(int row,int col){
        Ball ret = new Ball(-1,-1);

        while(board[row].charAt(col)=='.'){
            row--;
        }
        if(board[row].charAt(col)=='O'){
            ret=new Ball(row,col);
        }
        else{
            ret=new Ball(row+1,col);
        }

        return ret;
    }
    static Ball move_down(int row,int col){
        Ball ret = new Ball(-1,-1);

        while(board[row].charAt(col)=='.'){
            row++;
        }
        if(board[row].charAt(col)=='O'){
            ret=new Ball(row,col);
        }
        else{
            ret=new Ball(row-1,col);
        }

        return ret;
    }
    
    static String[] clean_board(Queue<Balls> queue){
        
        Ball red=new Ball(0,0);
        Ball blue=new Ball(0,0);
        String[] ret = new String[board.length];
        for(int i=0;i<board.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<board[0].length();j++){
                char c = board[i].charAt(j);
                if(c=='B'){
                    sb.append('.');
                    blue=new Ball(i,j);   
                }
                else if(c=='R'){
                    sb.append('.');
                    red= new Ball(i,j);
                }
                else if(c=='O'){
                    o_row=i;
                    o_col=j;
                    sb.append(c);
                }
                else{
                    sb.append(c);
                }

            }
            ret[i]=sb.toString();
        }
        queue.add(new Balls(red,blue,0));
        return ret;
    }
}

class Balls{
    Ball red;
    Ball blue;
    int cnt;//몇 번 
    public Balls(Ball red,Ball blue,int cnt){
        this.red =red;
        this.blue =blue;
        this.cnt = cnt;
    }    
}

class Ball{
    int row;
    int col;
    public Ball(int row,int col){
        this.row = row;
        this.col = col;
    }
}