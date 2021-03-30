import java.util.*;
import java.io.*;

public class Main {
    
//역시 프로그래머스에선 되는데 여긴 안됨 
// 내 생각대로 삭제하는데 n 걸려서 안되나봄 
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
        int n= Integer.parseInt(br.readLine());
        while(n!=0){
            n--;
            int num = Integer.parseInt(br.readLine());
            TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
            int cnt=0;
            while(cnt!=num){
                cnt++;
                String op[] = br.readLine().split(" ");
                int data=Integer.parseInt(op[1]);
                if(op[0].equals("I")){
                    map.put(data,map.getOrDefault(data,0)+1);
                }
                else{
                    if(map.size()==0)continue;
                    int temp=0;
                    if(data==1){
                        temp=map.lastKey();
                    }
                    else{
                        temp=map.firstKey();
                    }
                    if(map.get(temp)==1){
                        map.remove(temp);
                    }
                    else{
                        map.put(temp,map.get(temp)-1);
                    }

                }

                
            }
            if(map.size()==0){
                System.out.println("EMPTY");
            }
            else{
                System.out.println(map.lastKey()+" "+map.firstKey());
            }
        } 
    }
    
}


