import java.util.*;
import java.io.*;

/**
 init 에 min과 max를 같이 구하려고하면 
 재귀가 4개씩 증가하므로 overflow 발생 
 => min max 따로 구해야함 
*/
public class Main {

    static int n;   
    static int dp[];
    static ArrayList<node> tree[];
    static boolean visit[];
    static int max= Integer.MIN_VALUE;
    static node mnode;

    
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        n=Integer.parseInt(br.readLine());
        tree=new ArrayList[n+1];
        visit=new boolean[n+1];
    
        Arrays.fill(visit,false);

        for(int i=0;i<=n;i++){
            tree[i]=new ArrayList<node>();           
        }
     
        for(int i=1;i<=n;i++){    
            String s[]= br.readLine().split(" ");
            int index = Integer.parseInt(s[0]);
            for(int j=1;j<s.length;j+=2){
                int idx=Integer.parseInt(s[j]);
                if(idx==-1)break;
                int dis=Integer.parseInt(s[j+1]);
                tree[index].add(new node(idx,dis));
            }
        }
        node temp = dfs(tree[1].get(0),0);
        max=0;
        Arrays.fill(visit,false);
        mnode=null;
        dfs(temp,0);
        System.out.println(max);
    }
    static node dfs(node a,int val){
        int ret=0;
        int index=a.index;
        visit[index]=true;
        for(int i=0;i<tree[index].size();i++){
        
            int idx=tree[index].get(i).index;
            if(!visit[idx]){
                dfs(tree[index].get(i),val+tree[index].get(i).dis);
            }
        }
        if(val>max){
            max=val;
            mnode=a;
        }
        return mnode;
    }
}
class node{
    int index;
    int dis;
   
        public node(int index,int dis){
            this.index=index;
            this.dis=dis;           
        }
}
 