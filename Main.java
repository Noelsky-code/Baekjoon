import java.util.*;



import java.io.*;

public class Main {
    
<<<<<<< HEAD
//1759, 암호 만들기 
    static TreeSet<String> answer;
=======
    static int answer;
    static HashSet<Integer> set;
// 9466 , 텀 프로젝트 . 
// 1, 2는 서로 원하지 않으므로 실패 , 3은 혼자 팀 했기떄문에 팀 성립 , 4 -> 7 -> 6 -> 4 싸이클 .. 싸이클 !!
// 싸이클이 성립되면 팀 성립 
// 싸이클에 들어가지 않는 노드 구하면 됨 . 
// 자기 자신 가르키는건 pass 
// 싸이클 체크 
    
>>>>>>> b190fd26eabb5a186da0a9b1f3ccd85d46e65f20
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(Scolstem.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
<<<<<<< HEAD
        TreeSet<String> set_vowel = new TreeSet<String>();
        TreeSet<String> set_word = new TreeSet<String>();
        TreeSet<String> set = new TreeSet<String>();
        answer = new TreeSet<String>();
        String s[] = br.readLine().split(" ");
        int l = Integer.parseInt(s[0]);
        int c = Integer.parseInt(s[1]);
        String in[] = br.readLine().split(" ");
        
        for(String a:in){
            if(is_vow(a.charAt(0))){
                set_vowel.add(a);
            }
            else{
                set_word.add(a);
            }
            set.add(a);
=======
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

            
>>>>>>> b190fd26eabb5a186da0a9b1f3ccd85d46e65f20
        }
        String[] arr = new String[set.size()];
        for(int i=0;i<c;i++){
            arr[i]=set.pollFirst();
        }
        make_enc(l, -1, c, arr, "");
        while(!answer.isEmpty()){
            System.out.println(answer.pollFirst());
        }



    }
    static boolean is_vow(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
<<<<<<< HEAD
    static void make_enc(int n,int num,int c,String[] s,String a){//남은 모음 갯수, 남은 자음 갯수 
        if(n==0){
            if(is_make(a)){
                answer.add(a);
            }            
        }
        if(num==c){
            return;
        }
        for(int i=num+1;i<c;i++){
            make_enc(n-1,i,c,s,a+s[i]);
        }
    }
    static boolean is_make(String s){
        int vow=0;
        int word=0;
        for(int i=0;i<s.length();i++){
            if(is_vow(s.charAt(i))){
                vow++;
            }
            else{
                word++;
            }
        }
        if(vow>=1&&word>=2){
            return true;
        }
        return false;
=======
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
>>>>>>> b190fd26eabb5a186da0a9b1f3ccd85d46e65f20
    }
}
