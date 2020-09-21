import java.util.*;
import java.io.*;


public class Main {

    //static int arr[];
    
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String s[] = br.readLine().split(" ");
        long a = Long.parseLong(s[0]);
        long b = Long.parseLong(s[1]);
        int cnt=0;
        boolean arr[] = new boolean[(int)(b-a+1)];
        Arrays.fill(arr,false);
        //long sqrt = (long)Math.sqrt(b);
       
        for(long i=2;i*i<=b;i++){
            long start=a/(i*i);
            if(start*i*i!=a){
                start++;
            }
           // System.out.println(start);
            for(long j=start; j*i*i<=b; j++){
                if(arr[(int)(j*i*i-a)]==false){
                    arr[(int)(j*i*i-a)]=true;
                 } //System.out.println(1);
            }
        }
        for(int i=0;i<b-a+1;i++){
            if(!arr[i]){
                cnt++;
            }
        }

       System.out.println(cnt);
        

    }
}