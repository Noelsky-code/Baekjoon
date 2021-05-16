import java.util.*;



import java.io.*;

public class Main {
    
// 1005 ACM Craft 
// 
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(Scolstem.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int t = Integer.parseInt(br.readLine());
        while(t!=0){
            String s[] = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int[] time = new int[n+1];
            ArrayList[] lists = new ArrayList[n+1];
            int[] degree = new int[n+1];
            int[] ans = new int[n+1];
            s= br.readLine().split(" ");
            for(int i=0;i<n;i++){
                time[i+1] = Integer.parseInt(s[i]);
                lists[i+1] = new ArrayList<Integer>();
                ans[i+1]=time[i+1];
                degree[i+1]=0;
                
            }
            while(k!=0){
                s= br.readLine().split(" ");
                int from = Integer.parseInt(s[0]);
                int to = Integer.parseInt(s[1]);  
                lists[from].add(to);
                degree[to]++;
                k--;
            }
            int dest = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new LinkedList<Integer>();
            for(int i=0;i<n;i++){
                if(degree[i+1]==0){
                    queue.add(i+1);
                }
            }
            while(!queue.isEmpty()){
                int temp = queue.poll();
                for(int j=0;j<lists[temp].size();j++){
                    int idx = (int)lists[temp].get(j);
                    degree[idx]--;
                    ans[idx] = Math.max(ans[idx],time[idx]+ans[temp]);
                    if(degree[idx]==0)queue.add(idx);
                }
            }
            System.out.println(ans[dest]);
            
            t--;
        }
    }
}
