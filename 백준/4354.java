// 4354 , kmp 응용, 문자열 제곱 

import java.util.*;
import java.io.*;

public class Main {
    static int pi[];
    

    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
        while(true){
            String s = br.readLine();
            if(s.length()==1&&s.charAt(0)=='.'){
                break;
            }
            pi=new int[s.length()];
            get_pi(s);
            int n = s.length();
            int len = pi[s.length()-1];
            if(len*2<n||n%(n-len)!=0){
                System.out.println(1);
            }
            else{
                System.out.println(n/(n-len));
            }
        }

     }
     public static void get_pi(String p){
        int len = p.length();
        for(int i=0;i<len;i++){
            pi[i]=0;
        }
        int j=0;
        for(int i=1;i<len;i++){
        
            while(j>0&&p.charAt(i)!=p.charAt(j)){
                j=pi[j-1];
            }
            if(p.charAt(j)==p.charAt(i)){
                pi[i]=++j;
            }

        }
     }
 }
