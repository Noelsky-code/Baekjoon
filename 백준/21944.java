import java.util.*;



import java.io.*;

public class Main {
    // 21944, 문제 추천 시스템 version 2 
    // Priority 큐 이용 -> add , recommend는 nlogn 안에 모두 해결가능
    // 삭제 -> n^2 -> 시간 초과 예상 -> set을 이용해서 해결
    // solve 한 후 같은 문제를 다시 add 할 떄 예외 사항 발생가능  
    // Group의 경우 Map하나 더 만들어서 indexing 후 여러 우선순위 큐 만들어 해결  
    // recommend 3의 경우 난이도 별로 우선순위 큐를 만들어 해결?흠 ...가장 간단한 풀이법.   
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Problem> total_pq_max = new PriorityQueue<Problem>(Collections.reverseOrder());
        PriorityQueue<Problem> total_pq_min = new PriorityQueue<Problem>();
        HashSet<Problem> total_set = new HashSet<Problem>();
        HashMap<Integer,Problem> total_map = new HashMap<Integer,Problem>();
        PriorityQueue<Problem> group_pq_max[] = new PriorityQueue[101];//그룹 우선순위 큐 
        PriorityQueue<Problem> level_pq_max[] = new PriorityQueue[101];//난이도 우선순위 큐
        PriorityQueue<Problem> group_pq_min[] = new PriorityQueue[101];//그룹 우선순위 큐 
        PriorityQueue<Problem> level_pq_min[] = new PriorityQueue[101];//난이도 우선순위 큐

        for(int i=0;i<101;i++){
            group_pq_max[i] = new PriorityQueue<Problem>(Collections.reverseOrder());
            group_pq_min[i] = new PriorityQueue<Problem>();
            level_pq_max[i] = new PriorityQueue<Problem>(Collections.reverseOrder());
            level_pq_min[i] = new PriorityQueue<Problem>();
        }

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int diff = Integer.parseInt(st.nextToken());
            int group = Integer.parseInt(st.nextToken());
            Problem p = new Problem(num,diff,group);
            total_pq_max.add(p);
            total_pq_min.add(p);
            total_set.add(p);
            total_map.put(num,p);
            group_pq_max[group].add(p);
            level_pq_max[diff].add(p);
            group_pq_min[group].add(p);
            level_pq_min[diff].add(p);
        }
        int m = Integer.parseInt(br.readLine());

        while(m!=0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            
            if(order.equals("recommend")){
                int group = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                if(t==-1){
                    while(!total_set.contains(group_pq_min[group].peek())){
                        group_pq_min[group].poll();
                    }
                    bw.write(group_pq_min[group].peek().num+"\n");
                }
                else if(t==1){
                    while(!total_set.contains(group_pq_max[group].peek())){
                        group_pq_max[group].poll();
                    }
                    bw.write(group_pq_max[group].peek().num+"\n");
                }
            }
            else if(order.equals("recommend2")){
                int t = Integer.parseInt(st.nextToken());
                if(t==-1){
                    while(!total_set.contains(total_pq_min.peek())){//set에 존재하지 않는다면 poll
                        total_pq_min.poll();
                    }
            
                    bw.write(total_pq_min.peek().num+"\n");
                }
                else if(t==1){
                    while(!total_set.contains(total_pq_max.peek())){//set에 존재하지 않는다면 poll
                        total_pq_max.poll();
                    }
                    bw.write(total_pq_max.peek().num+"\n");
                }
            }
            else if(order.equals("recommend3")){
                int t = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                boolean pass = false;
                if(t==1){
                    for(int i=level;i<101;i++){
                        if(!level_pq_min[i].isEmpty()){
                            while(!total_set.contains(level_pq_min[i].peek())){
                                level_pq_min[i].poll();
                                if(level_pq_min[i].isEmpty())break; 
                            }
                            if(!level_pq_min[i].isEmpty()){
                                pass= true;
                                bw.write(level_pq_min[i].peek().num+"\n");
                                break;
                            }
                        }
                        if(pass)break;
                    }
                    if(!pass){
                        bw.write(-1+"\n");
                    }
                }
                else if(t==-1){
                    for(int i=level-1;i>0;i--){
                        if(!level_pq_max[i].isEmpty()){
                            while(!total_set.contains(level_pq_max[i].peek())){
                                level_pq_max[i].poll();
                                if(level_pq_max[i].isEmpty())break;
                            }
                            if(!level_pq_max[i].isEmpty()){
                                pass= true;
                                bw.write(level_pq_max[i].peek().num+"\n");
                                break;
                            } 
                        }
                    }
                    if(!pass){
                        bw.write(-1+"\n");
                    }

                }

            }
            else if(order.equals("add")){
                int num = Integer.parseInt(st.nextToken());
                int diff = Integer.parseInt(st.nextToken());
                int group = Integer.parseInt(st.nextToken());
                Problem p = new Problem(num,diff,group);
                total_pq_max.add(p);
                total_pq_min.add(p);
                total_set.add(p);
                total_map.put(num,p);
                group_pq_max[group].add(p);
                level_pq_max[diff].add(p);
                group_pq_min[group].add(p);
                level_pq_min[diff].add(p);
            }
            else if(order.equals("solved")){//푼 문제는 set에서 제거해줌. 
                int num = Integer.parseInt(st.nextToken());
                Problem p = total_map.get(num);
                total_set.remove(p);
                total_map.remove(num);
            }
            m--;
        }
        bw.flush();

    }
   
} 

class Problem implements Comparable<Problem>{
    int num;
    int diff;
    int group;
    public Problem(int num, int diff,int group){
        this.num = num;
        this.diff = diff;
        this.group = group;
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