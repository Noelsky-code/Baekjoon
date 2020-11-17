
//백준 11438 
import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static ArrayList<Integer> arr[];
    static int parent[][];
    static int depth[];
    static boolean visit[];
        public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        n = Integer.parseInt(br.readLine());
        arr= new ArrayList[n+1];
        visit = new boolean[n+1];
        parent = new int[n+1][18];//0~17 제곱 
        depth= new int[n+1];
        Arrays.fill(visit,false);

        for(int i=0;i<=n;i++){
            arr[i]=new ArrayList<Integer>();
        }
        //초기화 
        for(int i=1;i<=n;i++){
            for(int j=0;j<18;j++){
                parent[i][j]=-1;
            }
            depth[i]=-1;
        }

        depth[1]=0;
        String in[];
        for(int i=1;i<n;i++){//입력 받기 
            in=br.readLine().split(" ");
            int a = Integer.parseInt(in[0]);
            int b = Integer.parseInt(in[1]);
            arr[a].add(b);
            arr[b].add(a);
        }

        make_parent(1);
        for(int j=0;j<17;j++){// i 의 2^j+1 번째 조상은 2^j번쨰 조상의 2^j번쨰 조상  
            for(int i=1;i<=n;i++){
                if(parent[i][j]!=-1){//조상이 있다면 
                parent[i][j+1]=parent[parent[i][j]][j];
                }
            }
        }
        
        m = Integer.parseInt(br.readLine());
        while(m!=0){
            in=br.readLine().split(" ");
            int a = Integer.parseInt(in[0]);
            int b= Integer.parseInt(in[1]);
            if(depth[b]>depth[a]){//b의 깊이가 더 크면 swap 해주기  
                int temp = a;
                a=b;
                b=temp;
            }
            int dif= depth[a]-depth[b];//깊이 차이 구하기 
            for(int i=0;dif!=0;i++){//깊이 차 0 까지 a를 끌어올림 
                if(dif%2==1){//2의 제곱수니까 2진수 이용 
                    a=parent[a][i];
                }
                dif/=2;
            }
            if(a!=b){//같은 높이 일떄 a,b가 같지 않다면 
                for(int i=17;i>=0;i--){
                    if(parent[a][i]!=-1&&parent[a][i]!=parent[b][i]){//조상이 존재하고 같은 조상이 아니라면 위로 이동
                        a=parent[a][i];
                        b=parent[b][i];
                    } 
                }
                a=parent[a][0];//위의 결과로 a,b에 들어간 값은 공통조상 바로 아래 노드 
            }
            bw.write(a+"\n");
            m--;
        }
        bw.flush();
        bw.close();
    }
    static void make_parent(int idx){//depth설정,parent 설정 
        visit[idx]=true;
        for(int i:arr[idx]){
            if(!visit[i]){//방문 하지 않았다면 
                depth[i]=depth[idx]+1;
                parent[i][0]=idx;
                make_parent(i);
            }
        }
    }
}