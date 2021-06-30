import java.util.*;



import java.io.*;

public class Main {
    
    static int answer;
    static HashSet<Integer> set;
// 9466 , 텀 프로젝트 . 
// 1, 2는 서로 원하지 않으므로 실패 , 3은 혼자 팀 했기떄문에 팀 성립 , 4 -> 7 -> 6 -> 4 싸이클 .. 싸이클 !!
// 싸이클이 성립되면 팀 성립 
// 싸이클에 들어가지 않는 노드 구하면 됨 . 
// 자기 자신 가르키는건 pass 
// 싸이클 체크 
    
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(Scolstem.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int t = Integer.parseInt(br.readLine());
        while(t--!=0){
            set = new HashSet<Integer>();
            int n = Integer.parseInt(br.readLine());
            answer =n;
            boolean[] checked = new boolean[n+1];
            int arr[] = new int[n+1];
            String s[] = br.readLine().split(" ");
            for(int i =1 ; i<=n ; i++ ){
                arr[i] = Integer.parseInt(s[i-1]);                
            }
            for(int i=1;i<=n;i++){
                if(!checked[i]){
                    HashSet<Integer> visit =new HashSet<Integer>();
                    visit.add(i);
                    LinkedList<Integer> list = new LinkedList<Integer>();
                    list.add(i);
                    checked[i]=true;
                    find_cycle(checked,i,arr,visit,list);
                }
            }
            System.out.println(answer-set.size());

            
        }
        
    }
    static void find_cycle(boolean[] checked,int from,int[] arr,HashSet<Integer> visit,LinkedList<Integer> list){//dfs 방식 , 싸이클을 확인함  
        int to = arr[from];// 갈 곳
        if(visit.contains(to)){//갈곳이 이미 방문 된곳이라면 
            while(list.size()!=0){
                int poll = list.poll();
                set.add(poll);
                if(poll==to){     
                    return;
                }
            }
        }
        if(checked[to])return;
        list.addFirst(to);
        visit.add(to);
        checked[to]=true;
        find_cycle(checked, to, arr, visit, list);
    }
}
