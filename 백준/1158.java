import java.util.*;
import java.io.*;

public class Main {
    //1158, 요세푸스 문제
    
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(Scolstem.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        Queue<Integer> queue = new LinkedList<Integer>();
        StringBuilder sb  = new StringBuilder();
        sb.append("<");
        
        
        for(int i=0;i<n;i++){
            queue.add(i+1);
        }
        
        while(!queue.isEmpty()){
            int cnt=0;
            while(cnt!=k-1){
                int temp= queue.poll();
                queue.add(temp);
                cnt++;
            }
            int t = queue.poll();
            sb.append(t);
            sb.append(", ");
        }
        String answer = sb.toString();
        answer=answer.substring(0,answer.length()-2);
        answer=answer+">";
        System.out.println(answer);
        
    }

}