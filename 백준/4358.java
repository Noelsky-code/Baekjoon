import java.util.*;



import java.io.*;

public class Main {
    //4358, 생태학
    //    
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        PriorityQueue<String> pq = new PriorityQueue<String>();
        int total = 0;
        String s=br.readLine();
        while(s!=null){
            if(!map.containsKey(s)){
                pq.add(s);
            }
            map.put(s,map.getOrDefault(s, 0)+1);
            total++;
            s=br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<map.size();i++){
            s = pq.poll();
            if(map.containsKey(s)){
                double p = (double)map.get(s)*100/total;
                sb.append(s+" "+String.format("%.4f",p)+"\n");
            }
        }
        System.out.println(sb.toString());


    }
} 