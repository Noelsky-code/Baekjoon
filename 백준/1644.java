import java.util.*;



import java.io.*;

public class Main {
// 1644, 소수의 연속합
// 투 포인터, 에라토스테네스의 체 
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(Scolstem.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int n = Integer.parseInt(br.readLine());
        boolean[] is_prime = new boolean[n+1];
        is_prime[0]=is_prime[1]=true;
        for(int i=2;i*i<=n;i++){
            for(int j=i+i;j<=n;j+=i){
                is_prime[j]=true;
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=2;i<=n;i++){
            if(!is_prime[i]){
                list.add(i);
            }
        }
        int left=-1;
        int right=0;
        int sum=0;
        int answer=0;
        while(right!=list.size()){
            if(sum<n){
                sum+=list.get(right);
                right++;
            }
            else if(sum>n){
                left++;
                sum-=list.get(left);
            }
            else if(sum==n){
                answer++;
                left++;
                sum-=list.get(left);
            }
        }
        //자기자신이 소수일 경우
        if(!is_prime[n]){
            answer++;
        }
        System.out.println(answer);

    }
}
