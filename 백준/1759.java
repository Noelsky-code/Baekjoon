import java.util.*;



import java.io.*;

public class Main {
    
//1759, 암호 만들기 
    static TreeSet<String> answer;
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(Scolstem.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
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
    }
    
}
