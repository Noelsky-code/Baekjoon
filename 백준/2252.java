import java.util.*;



import java.io.*;

public class Main {
    
// 2252, 줄 세우기
// 위상정렬 같은데 ? 
//
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(Scolstem.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] degree = new int[n+1];
        ArrayList[] lists = new ArrayList[n+1];
        for(int i=0;i<n;i++){
            lists[i+1] = new ArrayList<Integer>();
        }
        while(m-->0){
            s = br.readLine().split(" ");
            int from = Integer.parseInt(s[0]);
            int to = Integer.parseInt(s[1]);
            lists[from].add(to);
            degree[to]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();

        for(int i=1;i<=n;i++){
            if(degree[i]==0)queue.add(i);
        }
        while(!queue.isEmpty()){
            int poll = queue.poll();
            System.out.println(poll);
            for(int i=0;i<lists[poll].size();i++){
                int j = (int)lists[poll].get(i);
                degree[j]--;
                if(degree[j]==0){
                    queue.add(j);
                }
            }
        }

    }
}
