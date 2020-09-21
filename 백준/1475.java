import java.util.*;
import java.io.*;


public class Main {

    //static int arr[][];
    //static int dp[][];
    //static int result=0;
    static int num;
    //static int n;
    //static int m;

    public static void main(final String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        //String s[]= br.readLine().split(" ");
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        String s = br.readLine();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i)-'0',0);           
        }
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i)-'0',map.get(s.charAt(i)-'0')+1);
        }
        int a=0;
        int max=0;
        for(int key:map.keySet()){
            if(key==6||key==9){
                a+=map.get(key);
            }else{
                max=Math.max(max,map.get(key));
            }
        }
        if(a%2==1)a++;
        System.out.println(Math.max(max,a/2));
    }
}