import java.util.*;
import java.io.*;

public class Main {
    // 11003, 최솟값 찾기 
    // 슬라이딩 윈도우 문제 
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        Deque<Integer> deque = new LinkedList<Integer>();
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(!deque.isEmpty()&&deque.getFirst()<=i-l){
                deque.removeFirst();
            }
            while(!deque.isEmpty()&&arr[deque.getLast()]>arr[i]){
                deque.removeLast();
            }
            deque.offer(i);
            sb.append(arr[deque.getFirst()]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
} 