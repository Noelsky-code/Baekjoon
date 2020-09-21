import java.util.*;
import java.io.*;
/*
반례를 못찾겠음 ... 
다른 코드랑 다른게 뭔지 모르겠음 
방법은 같은데 왜 틀린지 .. 반례가 뭐가 있는지 알수가 없음 
반례를 도저히 못찾겠고 방법은 다 이해했으니 PASS, 카피해서 제출했음 . 
다른사람 코드를 봐도 이게 왜 안되는지 이해불가 . 
2일동안 하루종일 고민했는데도 못찾음 . 
*/

public class Main {

    //static int arr[];
    
    static int n;   
    static Integer arr[];
    static int a[];
    static int dp[][];
    static int size;
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        n=Integer.parseInt(br.readLine());
        arr= new Integer[n];
        String s[] = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(s[i]);
        }
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int i:arr){
           map.put(i, 0);
        }
        for(int i:arr){
            map.put(i,map.get(i)+1);
        }
        size= map.size();
        a=new int[size];
        int cnt=0;
        for(int i:map.keySet()){
            a[cnt++]=i;
        }
        int ans[] = new int[n];
        Arrays.sort(arr);
        Arrays.sort(a);
        cnt=0;  
        if(size==1){
            for(int i=0;i<n;i++){
              ans[cnt++]=a[0];
            }
        }
        int i;
        for(i=0;i<size-1;i++){
                      
            if(a[i+1]-a[i]==1&&map.get(a[i+1])!=0){
                int temp=0;
                for(int j=i+2;j<size;j++){
                    if(map.get(a[j])!=0){//갯수있을때,존재할떄  
                        temp = a[j];
                        break;
                    }
                 }
                
                 if(temp==0){//없을때 
                  
                  // System.out.println();
                  //System.out.println(map.get(a[i+1])+" "+temp);
                    for(int j=0;j<map.get(a[i+1]);j++){
                        ans[cnt++]=a[i+1];//i+1 전부 출력후 
                    }
                    for(int j=0;j<map.get(a[i]);j++){
                        ans[cnt++]=a[i];
                    }
                    map.put(a[i],0);
                    map.put(a[i+1],0);
                   // i++;
                 }
                 else{//있을 때 
                    for(int j=0;j<map.get(a[i]);j++){
                        ans[cnt++]=a[i];
                    }
                    map.put(a[i],0);//전부 출력후 
                    ans[cnt++]=temp;//temp 하나 갖다 붙이고 
                    map.put(temp,map.get(temp)-1);//하나 감소
                    }


            }
            else{//규칙에 성립할때 전부 담음  
                for(int j=0;j<map.get(a[i]);j++){
                    ans[cnt++]=a[i];
                }
                map.put(a[i],0);
            }
         }
        if(i==size-1&&size!=1){
            while(map.get(a[i])!=0){
                ans[cnt++]=a[i];
                map.put(a[i],map.get(a[i])-1);
            }
        }
      
        
        for(int k:ans){
            System.out.printf("%d ",k);
        }
        
    }
}

