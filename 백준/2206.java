import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int arr[][];
    static boolean check[][][];
    static int a[][]={
        {-1,0},{1,0},{0,1},{0,-1}
    };
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String s[] = br.readLine().split(" ");
        n= Integer.parseInt(s[0]); m= Integer.parseInt(s[1]);
        arr = new int[n+1][m+1];
        check = new boolean[2][n+1][m+1];
        for(int i=0;i<2;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(check[i][j],false);
            }
        }
        boolean flag=false;
        Queue<point> queue = new LinkedList();
        
        for(int i=0;i<n;i++){
            s=br.readLine().split("");
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(s[j]);
            }
        }
        queue.add(new point(0,0,0,false));
        check[0][0][0]=true;
        check[1][0][0]=true;
        
        
        while(!queue.isEmpty()){
            point temp = queue.poll();
            int row = temp.row;
            int col = temp.col;
            int cnt = temp.cnt;
            boolean had= temp.had;
            int visit=0;
            if(had)visit=1;

            //check[visit][row][col]=true;//방문표시

            if(row==n-1&&col==m-1){//종료지점
                System.out.println(cnt+1);
                flag= true;
                break;
            }

            int temp_row;
            int temp_col;

            if(had==false){//break를 사용하지 않았을때
                
                for(int i=0;i<4;i++){
                    temp_row=a[i][0]+row;
                    temp_col=a[i][1]+col;
                    if(temp_row<=n-1&&temp_row>=0&&temp_col<=m-1&&temp_col>=0){
                    //범위 안에 있을때
                        if(arr[temp_row][temp_col]==0){
                            //이동가능
                            if(!check[visit][temp_row][temp_col]){
                            queue.add(new point(temp_row,temp_col,cnt+1,had));
                            check[visit][row][col]=true;//방문표시
                            }
                        }
                        else if(arr[temp_row][temp_col]==1){
                            if(!check[1][temp_row][temp_col]){
                            queue.add(new point(temp_row,temp_col,cnt+1,true));
                            check[1][row][col]=true;//방문표시
                            }
                        }
                    }
                }                

            }else{//break 사용
                for(int i=0;i<4;i++){
                    temp_row=a[i][0]+row;
                    temp_col=a[i][1]+col;
                    if(temp_row<=n-1&&temp_row>=0&&temp_col<=m-1&&temp_col>=0){
                    //범위 안에 있을때 
                        if(arr[temp_row][temp_col]==0){
                            //이동가능
                            if(!check[visit][temp_row][temp_col]){
                            check[visit][row][col]=true;//방문표시
                            queue.add(new point(temp_row,temp_col,cnt+1,had));
                            }
                        }
                    }
                }

            }
            /*for(int i=0;i<4;i++){
                temp_row=a[i][0]+row;
                temp_col=a[i][1]+col;
                if(temp_row<=n-1&&temp_row>=0&&temp_col<=m-1&&temp_col>=0){
                    
            
                if(arr[temp_row][temp_col]==1){
                    if(visit==0&&!check[1][temp_row][temp_col]){
                        check[1][temp_row][temp_col]=true;
                        queue.add(new point(temp_row,temp_col,cnt+1,true));
                    }
                }
                else{
                    if(!check[visit][temp_row][temp_col]){
                        queue.add(new point(temp_row,temp_col,cnt+1,had));
                        check[visit][temp_row][temp_col]=true;
                    }
                }
            }
        }*/
            
        }//bfs 종료 
        if(!flag){
            System.out.println(-1);
        }


    }
}

class point{
    int row;
    int col;
    int cnt;
    boolean had;
    
        public point(int row,int col,int cnt,boolean had){
            this.row=row;
            this.col=col;
            this.cnt=cnt;
            this.had=had;
        }
}package 백준;

public class 2206 {
    
}
