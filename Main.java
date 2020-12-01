// 2169, 로봇 조종하기  

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
                        }
                        else if(cube=='D'){
                            d_rotate();
                        }
                        else if(cube=='B'){
                            b_rotate();
                        }
                        else if(cube=='F'){
                            f_rotate();
                        }
                        else if(cube=='R'){
                            b_rotate();
                        }
                        else if(cube=='L'){
                            l_rotate();
                        }
                    }
                }
                else{
                    if(cube=='U'){
                        u_rotate();
                    }
                    else if(cube=='D'){
                        d_rotate();
                    }
                    else if(cube=='B'){
                        b_rotate();
                    }
                    else if(cube=='F'){
                        f_rotate();
                    }
                    else if(cube=='R'){
                        b_rotate();
                    }
                    else if(cube=='L'){
                        l_rotate();
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
        char[] temp=new char[3];
        temp=B[0];
        B[0]=L[0];
        L[0]=F[0];
        F[0]=R[0];
        R[0]=temp;
    }
    static void d_rotate(){
        char[] temp=new char[3];
        temp=B[2];
        B[2]=L[2];
        L[2]=F[2];
        F[2]=R[2];
        R[2]=temp;
    }
    static void l_rotate(){
        char a[]=new char[3];
        char b[]=new char[3];
        char c[]=new char[3];
        char d[]=new char[3];
        
        for(int i=0;i<3;i++){
            a[i]=U[i][0];
        }
        for(int i=0;i<3;i++){
            b[i]=F[i][0];
        }
        for(int i=0;i<3;i++){
            c[i]=D[i][0];
        }
        for(int i=0;i<3;i++){
            d[i]=B[i][2];
        }
        for(int i=0;i<3;i++){
            U[i][0]=d[i];
            F[i][0]=a[i];
            D[i][0]=b[i];
            B[i][0]=c[i];
        }
    }
    static void f_rotate(){
        char a[]=new char[3];
        char b[]=new char[3];
        char c[]=new char[3];
        char d[]=new char[3];
        
        for(int i=0;i<3;i++){
            a[i]=U[2][i];
        }
        for(int i=0;i<3;i++){
            b[i]=R[i][0];
        }
        for(int i=0;i<3;i++){
            c[i]=D[0][i];
        }
        for(int i=0;i<3;i++){
            d[i]=L[i][2];
        }
        for(int i=0;i<3;i++){
            U[2][i]=d[i];
            R[i][0]=a[i];
            D[0][i]=b[i];
            L[i][2]=c[i];
        }


    }
    static void r_rotate(){
        
        char a[]=new char[3];
        char b[]=new char[3];
        char c[]=new char[3];
        char d[]=new char[3];
        
        for(int i=0;i<3;i++){
            a[i]=U[i][2];
        }
        for(int i=0;i<3;i++){
            b[i]=F[i][2];
        }
        for(int i=0;i<3;i++){
            c[i]=D[i][2];
        }
        for(int i=0;i<3;i++){
            d[i]=B[i][0];
        }
        for(int i=0;i<3;i++){
            U[i][2]=b[i];
            F[i][2]=c[i];
            D[i][2]=d[i];
            B[i][0]=a[i];
        }
    }
    static void b_rotate(){
        
        char a[]=new char[3];
        char b[]=new char[3];
        char c[]=new char[3];
        char d[]=new char[3];
        
        for(int i=0;i<3;i++){
            a[i]=U[0][i];
        }
        for(int i=0;i<3;i++){
            b[i]=R[i][2];
        }
        for(int i=0;i<3;i++){
            c[i]=D[2][i];
        }
        for(int i=0;i<3;i++){
            d[i]=L[i][0];
        }
        for(int i=0;i<3;i++){
            U[0][i]=b[i];
            R[i][2]=c[i];
            D[2][i]=d[i];
            L[i][0]=a[i];
        }
    }

 }

