import java.util.*;
import java.io.*;

public class Main {
    //1620, 나는야 포켓몬 마스터   
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        HashMap<String,Integer> map_s = new HashMap<String,Integer>();
        HashMap<Integer,String> map_i = new HashMap<Integer,String>();

        for(int i=0;i<n;i++){
            String t = br.readLine();
            map_s.put(t,i+1);
            map_i.put(i+1,t);    
        }
        for(int i=0;i<m;i++){
            String in = br.readLine();
            if(in.charAt(0)-'0'>=0&&in.charAt(0)-'0'<=9){
                System.out.println(map_i.get(Integer.parseInt(in)));
            }
            else{
                System.out.println(map_s.get(in));
            }
        }
    }
} 