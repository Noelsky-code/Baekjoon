import java.util.*;
import java.io.*;

public class Main {
    
//14502 연구소 , 골드 5 문제 
//벽 3개를 꼭 세워야함 
//0 빈칸 1 벽 2 바이러스 
// 브루트 포스 -> 64 칸에 대해 벽3개 세운후 안전 공간 계산 .. 별로 안할듯 . 

    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String s[]=br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] arr = new int[n][m];
        ArrayList<Point> virus = new ArrayList<Point>();// 바이러스 위치 지정
        ArrayList<Point> blank = new ArrayList<Poiht>();//빈 공간 지정 
        for(int i=0;i<n;i++){
            s=br.readLine().split(" ");
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(s[j]);
                if(arr[i][j]==2){
                    virus.add(new Point(i,j));
                }
                
            }
        }
        
      

    }
    
}

class Point{
    int x;
    int y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;

    }

}

