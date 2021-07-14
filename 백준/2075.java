import java.util.*;



import java.io.*;

public class Main {
    //2075, N번쨰 큰 수
    //    
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        /*PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i=0;i<n-1;i++){
            pq.poll();
        }
        System.out.println(pq.poll());*/
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){// n개를 큐에 넣어줌 
            int t = Integer.parseInt(st.nextToken());
            pq.add(t);
        }
        //나머지 n-1개 줄을 큐에 넣어주는데 최대 n개만 큐에 넣어줌. 
        for(int i=1;i<n;i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int t = Integer.parseInt(st.nextToken());
                if(pq.peek()<t){//만약 n개의 수 중 가장 min 값 보다 큰게 들어온다면
                    pq.poll();//큐에서 최소값 꺼내줌 
                    pq.add(t);//큐에 넣어줌 
                }
                //min값보다 작은게 들어오면 pass 
            }
        }
        //-> n개 

        System.out.println(pq.poll());

    }
} 