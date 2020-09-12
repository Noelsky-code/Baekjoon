import java.util.*;
import java.io.*;


public class Main {

    static int arr[][];
    //static int dp[];
    static int result=0;
    static int num;
    static int n;
    static int m;
    static int look;
    static int row;
    static int col;

    public static void main(final String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String s[] = br.readLine().split(" ");
        n=Integer.parseInt(s[0]); m=Integer.parseInt(s[1]);
        s=br.readLine().split(" ");
        row=Integer.parseInt(s[0]); col=Integer.parseInt(s[1]); look =Integer.parseInt(s[2]);
        arr = new int[n][m];
        for(int i=0;i<n;i++){
            s= br.readLine().split(" ");
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(s[j]);
            } 
        }
        //look -> 0:북 1:동 2:남 3:서 
        boolean can = true;   
        int clean =0;
        while(can){
            if(arr[row][col]==0){
                clean++;
            }
            arr[row][col]=2;//청소시 2부여
            int i=0;
            boolean k=false;
            for(i=0;i<4;i++){
                if(robot()){//청소기 돌리기 성공
                    k=true;
                    break;
                }
            }
            if(!k){
                if(row-1<0||row+1>=n||col-1<0||col+1>=m){//후진을 하면 벗어남
                    break;
                }
                back();//후진하기
                if(arr[row][col]==1){//후진한곳이 벽이면끝
                    can=false;
                }
            }
        }
        System.out.println(clean);
     }
    static boolean check(int r,int c){
        if(r<0||r>=n||c<0||c>=m){
            return false;
        }
        if(arr[r][c]>0){
            return false;
        }
        return true;
    }
    static boolean robot(){
        boolean turn = false;
        if(look==0){
            if(check(row,col-1)){
            col--;
            turn = true;
          }
        }
        if(look==1){
            if(check(row-1,col)){
                row--;
                turn=true;
            }
        }
        if(look==2){
            if(check(row,col+1)){
                col++;
                turn=true;
            }
        }
        if(look==3){
            if(check(row+1,col)){
                row++;
                turn=true;
            }
        }
        look=(look+4-1)%4;
        return turn;
    }
    static void back(){
        if(look==0){
            row++;
        }
        if(look==1){
            col--;
        }
        if(look==2){
            row--;
        }
        if(look==3){
            col++;
        }
    }
}