import java.util.*;
import java.io.*;

public class Main {
    // 1202, 보석도둑 
    // 그리디 전략 : 가방 무게가 w1이라고 하고 w1>w2이면 , 보석 무게가 wt라고 하면 wt<=w2가 될 떄 까지 w1에 들어갈 수 있는 보석의 가치를 최대로 함. 
    // 예를 들면 1. 무게 10인 가방을 먼저 채워넣음  2.무게 2인 가방에 들어 갈 수 있는 보석이 나올 떄 까지 보석 무게를 줄여가며 무게 10가방의 가치를 최대로 만듬 3. 무한반복

      // 1.무게 순으로 가방 ,보석을 정렬함  
    // 300,000 이므로 nlogn 정렬 필요 => 우선 순위 큐 
      // 2. 보석 큐만큼 loop을 돌며 넣을 수 있는 가방에 최대의 보석가치가 되도록 함.  
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Long answer = 0;

        PriorityQueue<Tiffany> tiffanies = new PriorityQueue<Tiffany>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value =  Integer.parseInt(st.nextToken());
            tiffanies.add(new Tiffany(weight, value));
        }
        PriorityQueue<Integer> bags = new PriorityQueue<Integer>(Collections.reverseOrder()); 
        
        for(int i=0;i<k;i++){
            bags.add(Integer.parseInt(br.readLine()));
        }
        
        while(!bags.isEmpty()){
            int bag = bags.poll();//가장 큰 가방 
            int max = 0;
            while(!tiffanies.isEmpty()){
                Tiffany tiffany = tiffanies.peek();
                if(!bags.isEmpty()){//다음 가방이 있다면 
                    if(bags.peek()>tiffany.weight){//다음 가방에 들어갈 수 있는 보석이라면 
                        break;
                    }
                }
                if(max<tiffany.value){//가방에 넣은 거 보다 더 크다면 
                    max = tiffany.value;
                }
                tiffanies.poll();
            }

            answer += max;
            if(tiffanies.isEmpty()){//만약 티파니를 다 넣었다면 끝내줌 
                break;
            }
        }
        System.out.println(answer);
    }
}
class Tiffany implements Comparable<Tiffany>{
    int weight;
    int value;
    public Tiffany(int weight,int value){
        this.weight = weight;
        this.value = value;
    }
    @Override
    public int compareTo(Tiffany o){
        return -Integer.compare(this.weight,o.weight);
    }
} 