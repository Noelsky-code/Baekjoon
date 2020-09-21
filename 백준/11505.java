import java.util.*;
import java.io.*;


public class Main {

    static int n;   
    static int m;
    static int k;
    static long arr[];
    static long tree[];
    static long div = 1000000007;
    
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        String s[] = br.readLine().split(" ");
        n= Integer.parseInt(s[0]);
        m= Integer.parseInt(s[1]);
        k= Integer.parseInt(s[2]);
        arr=new long[n];
        tree= new long[4*n];
        
        for(int i=0;i<n;i++){
            arr[i]=Long.parseLong(br.readLine());
        }
        init(0,n-1,1);

        for(int i=0;i<m+k;i++){
            s=br.readLine().split(" ");
            int a= Integer.parseInt(s[0]);
            int b=Integer.parseInt(s[1]);
            if(a==1){
                long c= Long.parseLong(s[2]);
                update(0,n-1,1,b-1,arr[b-1],c);
                arr[b-1]=c;

            }
            else if(a==2){
                int c = Integer.parseInt(s[2]);
                System.out.println(mul(0,n-1,b-1,c-1,1)%div);
               /* for(long k:tree){
                    System.out.println(k);
                }*/
            }
        }
        
    }
    static long init (int start,int end,int node){
        if(end==start){
             return tree[node]=arr[start];
    
        }
        int mid=(start+end)/2;
        return tree[node]=(init(start,mid,node*2)%div)*(init(mid+1,end,node*2+1)%div)%div;
    }
    static long update(int start,int end,int node,int index,long a,long b){
        if(index>end||index<start)return tree[node];  
        if(start==end)return tree[node]=b;

        int mid = (start+end)/2;
        return tree[node]=(update(start,mid,node*2,index,a,b)*update(mid+1,end,node*2+1,index,a,b))%div;
    }

    static long mul(int start,int end,int left,int right,int node){
        if(left>end||right<start)return 1;
        if(left<=start&&right>=end){
            return tree[node]%div;
        } 
        int mid = (start+end)/2;
        return ((mul(start,mid,left,right,node*2)%div)*(mul(mid+1,end,left,right,node*2+1)%div))%div;       
    }

}
 

