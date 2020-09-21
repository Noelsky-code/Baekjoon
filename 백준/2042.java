
/*
처음 작성해보는 세그먼트트리 
어렵진 않지만 처음해봐서 낯섬 
구글에서 보면서 구현했음 
*/ 





import java.util.*;
import java.io.*;


public class Main {

    static int n;   
    static int m;
    static int k;
    static long arr[];
    static long tree[];
    
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
                long dif=c-arr[b-1];
                arr[b-1]=c;
                update(0, n-1, 1, b-1, dif);

            }
            else if(a==2){
                int c = Integer.parseInt(s[2]);
                System.out.println(sum(0,n-1,1,b-1,c-1));
            }
        }
        
    }

    static long init(int start, int end , int node){
        if(start==end){
            return tree[node] = arr[start];
        }
        int mid = (start+end)/2;
        return tree[node] = init(start,mid,node*2)+init(mid+1,end,node*2+1);

    }
    static void update(int start,int end,int node,int index,long dif){
        if(index<start||index>end)return;
        tree[node]+=dif;
        if(start==end)return;
        int mid=(start+end)/2;
        update(start,mid,node*2,index,dif);
        update(mid+1,end,node*2+1,index,dif);

    }
    static long sum(int start,int end,int node,int left,int right){
        if(left>end||right<start){
            return 0;
        }
        if(start>=left&&right>=end){
            return tree[node];
        }
        int mid=(start+end)/2;
        return sum(start,mid,node*2,left,right)+sum(mid+1,end,node*2+1,left,right);
    }
}

