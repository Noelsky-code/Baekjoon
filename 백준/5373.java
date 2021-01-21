// 5373, 큐빙  

import java.util.*;
import java.io.*;

public class Main {
    
    static char[][] U;
    static char[][] D;
    static char[][] F;
    static char[][] B;
    static char[][] L;
    static char[][] R;

    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int n = Integer.parseInt(br.readLine());
        while(n!=0){
            int num = Integer.parseInt(br.readLine());
            String s[] = br.readLine().split(" ");
            //큐브 초기화 
            U = u_cube();
            D = d_cube();
            F = f_cube();
            B = b_cube();
            L = l_cube();
            R = r_cube();
            for(int i=0;i<num;i++){
                char cube = s[i].charAt(0);
                char clock= s[i].charAt(1);
                
                if(clock=='-'){
                    for(int j=0;j<3;j++){
                        if(cube=='U'){
                            u_rotate();
                            clock(0,U);
                        }
                        else if(cube=='D'){
                            d_rotate();
                            clock(1,D);
                        }
                        else if(cube=='B'){
                            b_rotate();
                            clock(1,B);
                        }
                        else if(cube=='F'){
                            f_rotate();
                            clock(0,F);
    
                        }
                        else if(cube=='R'){
                            r_rotate();
                            clock(0,R);
                        }
                        else if(cube=='L'){
                            l_rotate();
                            clock(0,L);
                        }
                    }
                }
                else{
                    if(cube=='U'){
                        u_rotate();
                        clock(0,U);
                    }
                    else if(cube=='D'){
                        d_rotate();
                        clock(1,D);
                    }
                    else if(cube=='B'){
                        b_rotate();
                        clock(1,B);
                    }
                    else if(cube=='F'){
                        f_rotate();
                        clock(0,F);

                    }
                    else if(cube=='R'){
                        r_rotate();
                        clock(0,R);
                    }
                    else if(cube=='L'){
                        l_rotate();
                        clock(0,L);
                    }
                }
        
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.printf("%c",U[i][j]);
            }
            System.out.println();
        }
        n--;
    }
}
    
    static char[][] u_cube(){
        char cube[][]={{'w','w','w'},{'w','w','w'},{'w','w','w'}};
        return cube;
    }
    static char[][] d_cube(){
        char cube[][]={{'y','y','y'},{'y','y','y'},{'y','y','y'}};
        return cube;
    }
    static char[][] f_cube(){
        char cube[][]={{'r','r','r'},{'r','r','r'},{'r','r','r'}};
        return cube;
    }
    static char[][] b_cube(){
        char cube[][]={{'o','o','o'},{'o','o','o'},{'o','o','o'}};
        return cube;
    }
    static char[][] l_cube(){
        char cube[][]={{'g','g','g'},{'g','g','g'},{'g','g','g'}};
        return cube;
    }
    static char[][] r_cube(){
        char cube[][]={{'b','b','b'},{'b','b','b'},{'b','b','b'}};
        return cube;
    }

    static void u_rotate(){
        char[] temp = new char[3];
        
        for(int i=0;i<3;i++){
            temp[i] = L[0][i];
        }
        for(int i=0;i<3;i++){
            L[0][i] = F[0][i];
        }
         for(int i=0;i<3;i++){
            F[0][i]=R[0][i];
        }
        for(int i=0;i<3;i++){
            R[0][i]=B[0][2-i];
        }
        for(int i=0;i<3;i++){
            B[0][i]=temp[2-i];
        }
    }
    static void d_rotate(){
        char[] temp = new char[3];
        for(int i=0;i<3;i++){
            temp[i]=L[2][i];
        }
        for(int i=0;i<3;i++){
            L[2][i]=B[2][2-i];
        }
        for(int i=0;i<3;i++){
            B[2][i]=R[2][2-i];
        }
        for(int i=0;i<3;i++){
            R[2][i]=F[2][i];
        }
        for(int i=0;i<3;i++){
            F[2][i]=temp[i];
        }
    }
    static void l_rotate(){
        char[] temp = new char[3];
        for(int i=0;i<3;i++){
            temp[i]=U[i][0];
        }
        for(int i=0;i<3;i++){
            U[i][0]=B[2-i][0];
        }
        for(int i=0;i<3;i++){
            B[i][0]=D[i][0];
        }
        for(int i=0;i<3;i++){
            D[i][0]=F[2-i][0];
        }
        for(int i=0;i<3;i++){
            F[i][0]=temp[i];
        }

       
    }
    static void f_rotate(){
      char[] temp= new char[3];
      for(int i=0;i<3;i++){
          temp[i]=U[2][i];
      }
      for(int i=0;i<3;i++){
          U[2][i]=L[2-i][2];
      }
      for(int i=0;i<3;i++){
          L[i][2]=D[2][i];
      }
      for(int i=0;i<3;i++){
          D[2][i]=R[2-i][0];
      }
      for(int i=0;i<3;i++){
          R[i][0]=temp[i];
      }

    }
    static void r_rotate(){
        char[] temp= new char[3];
        for(int i=0;i<3;i++){
            temp[i]=U[i][2];
        }
        for(int i=0;i<3;i++){
            U[i][2]=F[i][2];
        }
        for(int i=0;i<3;i++){
            F[i][2]=D[2-i][2];
        }
        for(int i=0;i<3;i++){
            D[i][2]=B[i][2];
        }
        for(int i=0;i<3;i++){
            B[i][2]=temp[2-i];
        }
       
    }
    static void b_rotate(){
        char[] temp= new char[3];
        for(int i=0;i<3;i++){
            temp[i]=U[0][i];
        }
        for(int i=0;i<3;i++){
            U[0][i]=R[i][2];
        }
        for(int i=0;i<3;i++){
            R[i][2]=D[0][2-i];
        }
        for(int i=0;i<3;i++){
            D[0][i]=L[i][0];
        }
        for(int i=0;i<3;i++){
            L[i][0]=temp[2-i];
        }
       
    }
    static void clock(int a, char[][] in){
        char temp[][]=new char[3][3];
        if(a==0){//시계 방향 
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    temp[j][2-i]=in[i][j];
                }
            }
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    in[i][j]=temp[i][j];
                }
            }


        }
        if(a==1){//반시계방향 
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    temp[2-j][i]=in[i][j];
                }
            }
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    in[i][j]=temp[i][j];
                }
            }
        }
    
    }

 }
