import java.util.*;
import java.io.*;

public class Main {
    // 1766, 문제집
    // 3번 조건은 정렬 .. 
    // 우선순위 큐 사용 -> 3번 조건 해결 
    // 2번조건의 우선순위는 선행문제, 후행문제 set으로 나눠서 선행 문제 set의 size에 따라 우선순위 배치
    // poll된 문제는 후행문제들을 순회하여 후행문제들의 선행문제 set에 poll된 문제 삭제해줌 
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        PriorityQueue<Problem> pq = new PriorityQueue<Problem>();
        Problem[] problems = new Problem[n+1];
        for(int i=0;i<n;i++){
            problems[i+1]=new Problem(i+1);
        }
        for(int i=0;i<m;i++){//선행 , 후행학습 set 넣어줌 
            s = br.readLine().split(" ");
            int preceed = Integer.parseInt(s[0]);
            int proceed = Integer.parseInt(s[1]);
            problems[preceed].add_proceed(proceed);
            problems[proceed].add_preceed(preceed);
        }

        for(int i=1;i<=n;i++){
            pq.add(problems[i]);//큐에 넣어줌 
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){//del 후 큐를 업데이트 시켜주기 위해  마지막에 poll해줌
            Problem temp = pq.poll();
            sb.append(temp.num+" ");// 꺼낸 거 기록 
            for(int p : temp.proceed){//꺼낸 거의 후행 학습들에 대해 
                pq.remove(problems[p]);
                problems[p].del_preceed(temp.num);//선행학습 목록 삭제해줌 
                pq.add(problems[p]);
            }
               
        }
        
        String answer = sb.toString();
        System.out.println(answer.substring(0,answer.length()-1));
    } 
}

class Problem implements Comparable<Problem>{
    int num;
    HashSet<Integer> preceed;//선행
    HashSet<Integer> proceed;//후행
    public Problem(int num){
        this.num = num;
        this.preceed = new HashSet<Integer>();
        this.proceed = new HashSet<Integer>();
    }
    public void add_proceed(int num){
        this.proceed.add(num);
    }
    public void add_preceed(int num){
        this.preceed.add(num);
    }
    public void del_preceed(int num){
        this.preceed.remove(num);
    }
    

    @Override
    public int compareTo(Problem o) {
        if(o.preceed.size()==this.preceed.size()){
            return Integer.compare(this.num,o.num);
        }

        return Integer.compare(this.preceed.size(),o.preceed.size());
    }

}