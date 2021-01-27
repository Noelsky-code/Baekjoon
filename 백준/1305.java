// 1305,광고 , kmp 알고리즘 활용 

import java.util.*;
import java.io.*;

public class Main {
    

    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int n= Integer.parseInt(br.readLine());
        String in = br.readLine();
        System.out.println(in.length()-get_pi(in));

     }
     public static int get_pi(String s){
        int len = s.length();
        int pi[] = new int[len];
        for(int i=0;i<len;i++){
            pi[i]=0;
        }
        int j=0;
        for(int i=1;i<len;i++){
            while(j>0&&s.charAt(i)!=s.charAt(j)){
                j=pi[j-1];
            }
            if(s.charAt(i)==s.charAt(j)){
                pi[i]=++j;
            }
        }        

        return pi[len-1];//입력된 string의 가장 긴 접미사=접두사 길이 반환 
     }
 }
