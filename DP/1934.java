import java.util.*;
import java.io.*;


public class Main {

    //static int arr[][];
    static long dp[][];
    static long result=0;
    static int num;
    //static int n;
    //static int m;

    public static void main(String[] args) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        num=Integer.parseInt(br.readLine());
        while(num--!=0){
            String s[]=br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int g = gcd(Math.max(n,m),Math.min(n,m));
            System.out.println(n*m/g);

        }
    }
    static int gcd(int a,int b){
        if(a%b==0){
            return b;
        }
        return gcd(b,a%b);
    }
}