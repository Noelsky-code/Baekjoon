import java.util.*;



import java.io.*;

public class Main {
    // 21939, 문제 추천 시스템 version1 
    // Priority 큐 이용 -> add , recommend는 nlogn 안에 모두 해결가능
    // 삭제 -> n^2 -> 시간 초과 예상 -> set을 이용해서 해결
    // solve 한 후 같은 문제를 다시 add 할 떄 예외 사항 발생가능  
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Problem> pq_max = new PriorityQueue<Problem>(Collections.reverseOrder());
        PriorityQueue<Problem> pq_min = new PriorityQueue<Problem>();
        HashSet<Problem> set = new HashSet<Problem>();
        HashMap<Integer,Problem> map = new HashMap<Integer,Problem>();//삭제된 문제들  

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int diff = Integer.parseInt(st.nextToken());
            Problem p = new Problem(num,diff);
            pq_max.add(p);
            pq_min.add(p);
            set.add(p);
            map.put(num,p);
        }
        int m = Integer.parseInt(br.readLine());
        while(m!=0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("recommend")){
                int t = Integer.parseInt(st.nextToken());
                if(t==-1){
                    while(!set.contains(pq_min.peek())){//set에 존재하지 않는다면 poll
                        pq_min.poll();
                    }
            
                    bw.write(pq_min.peek().num+"\n");
                }
                else if(t==1){
                    while(!set.contains(pq_max.peek())){//set에 존재하지 않는다면 poll
                        pq_max.poll();
                    }
                    bw.write(pq_max.peek().num+"\n");
                }
            }
            else if(order.equals("add")){
                int num = Integer.parseInt(st.nextToken());
                int diff = Integer.parseInt(st.nextToken());

                Problem p = new Problem(num,diff);
                pq_max.add(p);
                pq_min.add(p);
                set.add(p);
                map.put(num,p);
            }
            else if(order.equals("solved")){//푼 문제는 set에서 제거해줌. 
                int num = Integer.parseInt(st.nextToken());
                Problem p = map.get(num);
                set.remove(p);
                map.remove(p);
            }
            m--;
        }
        bw.flush();

    }
   
} 

class Problem implements Comparable<Problem>{
    int num;
    int diff;
    public Problem(int num, int diff){
        this.num = num;
        this.diff = diff;
    }
    @Override
    public int compareTo(Problem o) {
        // TODO Auto-generated method stub
        if(this.diff==o.diff){
            return Integer.compare(this.num,o.num);
        }
        return Integer.compare(this.diff,o.diff);
    }
}