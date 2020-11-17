import java.util.*;
import java.io.*;


public class Main {

    static int n;   
    static int arr[];
    static int tree[];

    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        while(true){
            String s[] = br.readLine().split(" ");
            n= Integer.parseInt(s[0]);
            if(n==0)break;

            arr=new int[n];
            tree= new int[4*n];
           
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(s[i+1]);
            }
            init(0,n-1,1);
            bw.write(find_max(0,n-1)+"\n");//0~n-1 구간 최대값 
        }

        bw.flush();
        bw.close();

    }

    static int init(int start, int end , int node){
        if(start==end){
            return tree[node] = start;
        }
        int mid = (start+end)/2;
        int a = init(start,mid,node*2);
        int b=  init(mid+1,end,node*2+1);
        if(arr[a]>arr[b]){
            tree[node]=b;
        }
        else{
            tree[node]=a;
        }
        //System.out.println(tree[node]*(end-start+1));
        return tree[node];
    }
   
    static int find_idx(int start,int end,int node,int left,int right){
        
        if(left>end||right<start){
            return -1;
        }
        if(start>=left&&right>=end){
            return tree[node];
        }

        int mid = (start+end)/2;
        int a = find_idx(start,mid,node*2,left,right);
        int b = find_idx(mid+1,end,node*2+1,left,right);
        
        if(a==-1){
            return b;
        }
        else if(b==-1){
            return a;
        }
        else{

            if(arr[a]>arr[b]){
                return b;
            }
            else{
                return a;
            }
        }
    }

    static long find_max(int left,int right){
        int idx = find_idx(0,n-1,1,left,right);//left~right 사이의 최소 index;
        long ret = (long)(right-left+1)*(long)arr[idx];//left~right 사이의 넓이 
        if(idx-1>=left){//범위안에 최소 index 보다 왼쪽 막대가 있으면 
            long a = find_max(left,idx-1);// left~ (최소 index -1)까지의 최대넓이
            if(a>ret){//구한게 더 크다면 
                ret= a;
            }
        }
        if(idx+1<=right){
            long a = find_max(idx+1,right);
            if(a>ret){
                ret=a;
            }
        }
        return ret;
    }
}