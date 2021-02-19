//프로그래머스 , 크레인 인형뽑기게임 

import java.util.*;
import java.io.*;

public class Main {
    
    

    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
       
        int t= Integer.parseInt(br.readLine());
        while(t!=0){
            boolean answer=true;
        int min=11;
        int max=0; 
        
        boolean[] len = new boolean[11];
        Arrays.fill(len,false);
        int n=Integer.parseInt(br.readLine());
        String[] phone_book=new String[n];
        for(int i=0;i<n;i++){
            phone_book[i]=br.readLine();
        }
        
        for(String s:phone_book){
            min=Math.min(s.length(),min);//가장 작은길이     
            max=Math.max(s.length(),max);//가장 긴 길이
            len[s.length()]=true;
        }
        
        for(int i=min;i<=max;i++){//최대 2천만
            if(!len[i])continue;
            HashSet<String> set = new HashSet<String>();//길이 맞는거 담을거 
            HashSet<String> temp = new HashSet<String>();// 자른거 담을거 
            for(String s:phone_book){
                if(s.length()>i){
                    temp.add(s.substring(0,i));
                    if(set.contains(s.substring(0,i))){
                        answer=false;
                        break;
                    }
                }
                else if(s.length()==i){
                    set.add(s.substring(0, i));
                    if(temp.contains(s.substring(0,i))){
                        answer=false;
                        break;
                    }
                }
            }
            if(!answer)break;
        }
        t--;
        if(answer){
          System.out.println("YES");  
        } 
        else{
            System.out.println("NO");
        }   
    }
        
    }
}