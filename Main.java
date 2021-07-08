import java.util.*;
import java.io.*;

public class Main {
    // 1238, 파티
    // 
    static ArrayList[] roads;
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int x = Integer.parseInt(s[2]);
        roads = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            roads[i] = new ArrayList<Road>();
        }

        for(int i=0;i<n;i++){
            s = br.readLine().split(" ");
            int from= Integer.parseInt(s[0]);
            int to = Integer.parseInt(s[1]);
            int time = Integer.parseInt(s[2]);
            roads[from].add(new Road(from,to,time));
        }
        int[] times = new int[n+1];
        for(int i=1;i<=n;i++){
            int arr[] = find_time(i,x,n);
            times[i] = arr[x];           
        }
        int arr[] = find_time(x,x,n);
        int max=0;
        for(int i=1;i<=n;i++){
            max = Math.max(arr[i]+times[i],max);
        }
        System.out.println(max);
    }
    static int[] find_time(int src,int dest,int n){
    
        int[] dist = new int[n+1];
        Arrays.fill(dist,987654321);
        PriorityQueue<Road> pq = new PriorityQueue<Road>();
        pq.add(new Road(src,src,0));
        while(!pq.isEmpty()){
            Road temp = pq.poll();
            for(int i=0;i<roads[temp.from].size();i++){
                Road road = (Road) roads[temp.from].get(i);
                if(dist[road.to]>dist[road.from]+road.time){
                    dist[road.to]=dist[road.from]+road.time;
                    pq.add(road);
                }
            }
        }
        
        return dist;
    }
}

class Road implements Comparable<Road>{
    int from;
    int to;
    int time;
    public Road(int from, int to, int time){
        this.from = from;
        this.to = to;
        this.time = time;
    }
    @Override
    public int compareTo(Road o) {
        
        return Integer.compare(this.time, o.time);
    } 
}