import java.util.*;
import java.io.*;
/*
뫼비우스 함수
*/

public class Main {

    //static int arr[];
    
    static int n;   
    static int arr[];
    static int dp[][];
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        n=Integer.parseInt(br.readLine());
        arr=new int[200001];
        for(int i=1;i<=200000;i++){
            arr[i]=1;           
        }
        for(int i=2; i*i <=200000;i++){
            if(arr[i]==1){
            for(int j=i;j<=200000;j+=i){
                arr[j]*=-i;
            }
            for(int j=i*i;j<=200000;j+=i*i){
                arr[j]=0;
            }
        }
        }
        for(int i=2;i<=200000;i++){
            if(arr[i]==i){
                arr[i]=1;
            }
            else if(arr[i]==-i){
                arr[i]=-1;
            }
            else if(arr[i]<0){
                arr[i]=1;
            }
            else if(arr[i]>0){
                arr[i]=-1;
            }

        }
        long left = 1; long right=2000000000;
        while(left<right){
            long mid = (right+left)/2;
            long ret = cnt(mid);
           // System.out.println(mid);
            if(ret>n){
                right = mid-1;
            }
            else if(ret==n){
                right=mid;
            }
            else{
                left=mid+1;
            }
            
        }
        System.out.println(right);
      
    }
    static long cnt(long mid){
        long ret =0;
        
        for(int i=1;i*i<=mid;i++){
            ret+=(arr[i]*(mid/(i*i))); 
        }
        return ret;       
    }
    
}

