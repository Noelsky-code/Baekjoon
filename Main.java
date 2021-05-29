import java.util.*;



import java.io.*;

public class Main {
    
    static int answer;
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
            
            int n = Integer.parseInt(br.readLine());
            answer =n;
            boolean[] checked = new boolean[n+1];
            HashSet<Integer> set = new HashSet<Integer>();
            int arr[] = new int[n+1];
            String s[] = br.readLine().split(" ");
            for(int i =1 ; i<=n ; i++ ){
                arr[i] = Integer.parseInt(s[i-1]);                
            }

            for(int i=0;i<n;i++){
                if(!set.contains(i)){
                    LinkedList<Integer> list = new LinkedList<Integer>();
                    list.add(i);
                    find_cycle(i,arr[i],arr,set,list);
                }
            }
            System.out.println(n-set.size());
            
        }
        
    }
    static void find_cycle(int root,int from,int[] arr,HashSet<Integer> set,LinkedList<Integer> list){//dfs 방식 , 싸이클을 확인함  
        
        
        if(set.contains(arr[from])){// 만약 이미 사이클이 형성된 곳을 연결하려고 하면
            return;     
        }
        
        if(root == arr[from]){
            int size = list.size();
            while(size--!=0){
                set.add(list.poll());
            }
            return;
        }

        if(list.contains(arr[from]))return; //만약 방문했던곳을 또 가려고 한다면. 

        list.add(arr[from]);
        find_cycle(root,arr[from],arr,set,list);
    }
    
}
