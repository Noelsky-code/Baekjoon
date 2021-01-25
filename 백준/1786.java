// 1786, 찾기 , kmp알고리즘 

import java.util.*;
import java.io.*;

public class Main {
    
    static int pi[];


    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String t = br.readLine();
        String p=  br.readLine();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        pi= new int[p.length()];
        get_pi(p,p.length());
        int j=0;
        for(int i=0;i<t.length();i++){
            while(j>0&&t.charAt(i)!=p.charAt(j)){
                j=pi[j-1];
            }
            if(t.charAt(i)==p.charAt(j)){
                if(j==p.length()-1){
                    ans.add(i-p.length()+1);
                    j=pi[j];// 맞을 경우 최선의 경우로 j 이동 

                }
                else{
                    j++;
                }
            }
        }
        bw.write(ans.size()+"\n");
        for(int i:ans){
            bw.write(i+1+" ");
        }
        bw.flush();
        bw.close();


     }
     static void get_pi(String a ,int len){
         for(int i=0;i<len;i++){
             pi[i]=0;
         }
         int j=0;
         for(int i=1;i<len;i++){
            while(j>0&&a.charAt(i)!=a.charAt(j)){
                j=pi[j-1];
            }
            if(a.charAt(i)==a.charAt(j)){
                pi[i]=++j;
            }

         }
     }
 }
