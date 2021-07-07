import java.util.*;
import java.io.*;

public class Main {
    // 2800, 괄호 제거 
    // 시간제한 1초 
    // 최대 2^10-1 
    // 1. 괄호 쌍 위치 찾음  2. 제거할거 만들기  3.제거 하고 String 만든 후 정렬 4. 중복 제거 
    static StringBuilder sb;
    static ArrayList<String> list;
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String s = br.readLine();
        sb= new StringBuilder();
        list = new ArrayList<String>();
        find(s);// 괄호 위치 찾음
        String[] answer = sb.toString().split(" ");
        Arrays.sort(answer);
        HashSet<String> check = new HashSet<String>();//중복 체크

        for(String a : answer){
            if(!check.contains(a)){
                check.add(a);
                bw.write(a+"\n");
            }
        }
        bw.flush();
        
             
    }
    static void find(String s){// 괄호 위치 찾는 함수
        
        Stack<Integer> stack = new Stack<Integer>();
    
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }
            else if(s.charAt(i)==')'){
                int t = stack.pop();
                list.add(t+" "+i);
            }
        }
        delete(s,0,1);
       
    }

    static void delete(String s,int now,int del){//비트연산자 사용
        if(now==list.size()){
            if(del!=1){//아무것도 삭제 안한 경우 넘어감 
                make_str(s,del);
            }
            
            return;
        }
        delete(s,now+1,del|(1<<(now+1)));//now 삭제
        delete(s,now+1,del);//now 삭제 안함
    }

    static void make_str(String s,int del){
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=1;i<=list.size();i++){ //set에 del할것들 위치 넣어둠
            if((del&(1<<i))==(1<<i)){//만약 del이라면 
                String temp[] = list.get(i-1).split(" ");
                set.add(Integer.parseInt(temp[0]));
                set.add(Integer.parseInt(temp[1]));
            }
        }
        
        for(int i=0;i<s.length();i++){
            if(!set.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        sb.append(" ");
        
    }
}