import java.util.*;



import java.io.*;

public class Main {
    
// 1197 최소 스패닝 트리 
// 수업 시간에 배운 Prim's algorithm 을 이용해 구현해봄 . 
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(Scolstem.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String s[] = br.readLine().split(" ");
        int v = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);
        ArrayList<Edge> Edges[] = new ArrayList[v+1];
        for(int i=0;i<v+1;i++){
            Edges[i] = new ArrayList<Edge>();
        }
        for(int i=0;i<e;i++){
            s= br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            Edges[a].add(new Edge(a,b,c));
            Edges[b].add(new Edge(b,a,c));
        }
        //System.out.println(Edges[1].get(0));
        System.out.println(find_MST(Edges));
        

    }
    static int find_MST(ArrayList<Edge> Edges[]){

        int answer = 0; 
        PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
        Vertex[] vertexs = new Vertex[Edges.length+1];
        vertexs[1] = new Vertex(1, 0);

        for(int i=2;i<Edges.length;i++){
            vertexs[i] = new Vertex(i, Integer.MAX_VALUE);
            pq.add(vertexs[i]);
        }
        //boolean[] polled = new boolean[Edges.length];

        pq.add(vertexs[1]);
        while(!pq.isEmpty()){
            Vertex poll = pq.poll();
            answer += poll.cost; 
            for(int i=0;i<Edges[poll.idx].size();i++){
                Edge k =Edges[poll.idx].get(i);
                if(pq.contains(vertexs[k.to])){
                    if(vertexs[k.to].cost > k.cost){
                        pq.remove(vertexs[k.to]);
                        vertexs[k.to].cost = k.cost;
                        pq.add(vertexs[k.to]);
                    }
                }
            }
            
            
        }
       
        
        return answer;
    }

}
class Edge{
    int from;
    int to;
    int cost;
    public Edge(int from, int to, int cost){
        this.from= from;
        this.to = to;
        this.cost = cost;
    }
}

class Vertex implements Comparable<Vertex>{
    
    int idx;
    int cost;
    public Vertex(int idx,int cost){
        this.idx = idx;
        this.cost = cost;
    }
    @Override
    public int compareTo(Vertex o) {
        
        return Integer.compare(cost, o.cost);
    }

}

