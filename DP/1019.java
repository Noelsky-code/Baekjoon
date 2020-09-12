import java.util.*;
import java.io.*;


public class Main {

    //static int arr[];
    static int ans[];
    static int mul;
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String s = br.readLine();
        int start =1 ;
        int end = Integer.parseInt(s);
        ans = new int[10];
        mul= 1;
        for(int i=0;i<10;i++){
            ans[i]=0;
        }

        while(end>=start){
            while(end%10!=9&&end>=start){
                cnt(end);
                end--;                   
            }
            while(start%10!=0&&end>=start){
                cnt(start);
                start++;
            }
            if(start>end){
                break;
            }
            start /= 10;
            end /=10;
            for(int i=0;i<10;i++){
                ans[i]+=(end-start+1)*mul;
            }
            mul*=10;       
        }        
        for(int i=0;i<10;i++){
            System.out.printf("%d ",ans[i]);
        }
    }
    static void cnt(int n){
        while(n>0){
            ans[n%10]+=mul;
            n/=10;                      
        }
    }
}