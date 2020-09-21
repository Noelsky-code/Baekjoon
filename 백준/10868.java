import java.util.*;
import java.io.*;

/**
 init 에 min과 max를 같이 구하려고하면 
 재귀가 4개씩 증가하므로 overflow 발생 
 => min max 따로 구해야함 
*/
public class Main {

    static int n;   
    static int m;
    static int arr[];
    static int tree[];
    static int min_val;
    //static int max_val;

    
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        String s[] = br.readLine().split(" ");
        n= Integer.parseInt(s[0]);
        m= Integer.parseInt(s[1]);
    
        arr=new int[n];
        tree= new int[4*n];
        
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());    
        }

        init_min(0,n-1,1);

        /*for(int i:tree){
            System.out.println(i.min+" "+i.max);
        }*/
        for(int i=0;i<m;i++){
            min_val=Integer.MAX_VALUE;
            s=br.readLine().split(" ");
            int a=Integer.parseInt(s[0]);
            int b=Integer.parseInt(s[1]);
            get(0,n-1,a-1,b-1,1);
            bw.write(min_val+"\n");
        
       }
        bw.flush();     
        
    }
    static int init_min (int start,int end,int node){
        if(end==start){
            tree[node]=arr[start];
            return tree[node];
        }
    
        
        int mid=(start+end)>>1;
        tree[node]=Math.min(init_min(start,mid,node*2),init_min(mid+1,end,node*2+1));
        
        return tree[node];
    }

    /*static int update(int start,int end,int node,int index,long a,long b){
        if(index>end||index<start)return tree[node];  
        if(start==end)return tree[node]=b;

        int mid = (start+end)/2;
        return tree[node]=(update(start,mid,node*2,index,a,b)*update(mid+1,end,node*2+1,index,a,b))%div;
    }*/
    static void get(int start,int end,int left,int right,int node){
        if(right<start||left>end){
            return;
        }
        if(left<=start && right>=end){
           min_val=Math.min(min_val,tree[node]);
           return;
        }
        
        int mid=(start+end)>>1;
        get(start,mid,left,right,node*2);
        get(mid+1,end,left,right,node*2+1);
    }
}
 