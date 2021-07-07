import java.util.*;
import java.io.*;

public class Main {
    //2493, 탑
    // 시간제한 1.5초 
    // peek 보다 체크(k)하는게 더 큼 -> 앞쪽에꺼 살펴봐야함 -> pop해서 가까운 것들 꺼내주며 업데이트 해줌
    // -> 만약 더 큰걸 찾음 -> peek, 체크하는거 푸시 -> 반복 
    // 만약 peek가 더 큼 -> k를 push해줌

    static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int n = Integer.parseInt(br.readLine());
        String in[] = br.readLine().split(" ");
        int arr[] = new int[n];
        stack = new Stack<Integer>();

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(in[i]);
        }
        StringBuilder sb = new StringBuilder();
        stack.push(1);//stack 에 인덱스들 넣어줄거임 
        sb.append(0+" ");
        for(int i=1;i<n;i++){
            if(arr[stack.peek()-1]<arr[i]){//만약 peek가 더 작다면
                clean_stack(arr,i);//pop해주고
                if(stack.isEmpty()){ 
                    sb.append(0+" ");
                }
                else{
                    sb.append(stack.peek()+" ");
                }
                stack.push(i+1);//i+1 푸시해줌 
            }
            else{//만약 peek가 더 크다면 
                sb.append(stack.peek()+" ");
                stack.push(i+1);
            }        
        }
        System.out.println(sb.substring(0,sb.length()-1).toString());
        
    }
    static void clean_stack(int[] arr,int i){
        int check = arr[i];
        while(check>arr[stack.peek()-1]){
            stack.pop();
            if(stack.isEmpty())break;
        }
        
    }
}