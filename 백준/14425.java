import java.util.*;
import java.io.*;

public class Main {
    //14425, 문자열 집합    
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        HashSet<String> set = new HashSet<String>();
        for(int i=0;i<n;i++){
            set.add(br.readLine());
        }
        int answer= 0;
        for(int i=0;i<m;i++){
            if(set.contains(br.readLine()))answer++;
        }
        System.out.println(answer);


    }
} 