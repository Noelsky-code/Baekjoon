import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> max = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}

		});
		PriorityQueue<Integer> min = new PriorityQueue<Integer>();
		int mid = Integer.parseInt(br.readLine());
		n--;
		bw.write(mid+"\n");
		while(n!=0) {
			int temp = Integer.parseInt(br.readLine());
			int size_max=max.size();
			int size_min=min.size();
			int size = max.size()+min.size();
			// max= 작은값들의 집합,  min = 큰값들의 집합  
			if(size_min>size_max) {
				if(temp>mid) {
					max.add(mid);
					min.add(temp);
					mid=min.poll();
				}
				else {
					max.add(temp);
				}
			}
			else {
				if(temp<mid) {
					min.add(mid);
					max.add(temp);
					mid=max.poll();
				}
				else {
					min.add(temp);
				}	
			}
			
			
			bw.write(mid+"\n");
			n--;
		}
		bw.flush();
	}	
}