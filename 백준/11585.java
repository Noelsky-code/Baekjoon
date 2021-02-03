// 11585 , kmp 응용 , 속타는 저녁 메뉴 

import java.util.*;
import java.io.*;

public class Main {
    
    static int[] pi;

    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int n= Integer.parseInt(br.readLine());
        String s = br.readLine().replaceAll(" ", "");
        s=s.trim();
        String p = br.readLine().replaceAll(" ", "");
        p=p.trim();
        //공백 없애기 
        pi= new int[n];
        get_pi(p);
        String str = s+s;//문자열 이어붙이기 룰렛 효과 
        int ret = 0;
        for(int i=0,j=0;i<str.length()-1;i++){//마지막 글자는 뺴주기 (중복)
            while(j>0&&str.charAt(i)!=p.charAt(j)){
                j=pi[j-1];                
            }
            if(str.charAt(i)==p.charAt(j)){
                if(j==n-1){
                    ret++;
                    j=pi[j];
                }
                else{
                    j++;
                }
            }
        }//kmp 완료 , ret에 가능한 가짓수 나옴 
        //가능한 전체 가짓수는 n 
    
        int div = gcd(n,ret);
        n=n/div;
        ret=ret/div;
        System.out.println(ret+"/"+n);
     
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
     public static int gcd(int a,int b){
        int temp=0;
        while(b!=0){
            temp = a%b;
            a=b; 
            b=temp;
        }
       return a;
                
     }
 }
