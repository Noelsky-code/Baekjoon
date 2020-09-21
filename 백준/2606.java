import java.util.*;
import java.io.*;


public class Main {

    //static int arr[];
    static int arr[][];
    static int mul;
    static boolean a[];
    static ArrayList<Integer> array[];
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int n= Integer.parseInt(br.readLine());
        int num= Integer.parseInt(br.readLine());
        arr=new int[num][2];
        a=new boolean[n];
        Arrays.fill(a,false);

        for(int i=0;i<num;i++){
            String s[]=br.readLine().split(" ");
            arr[i][0]=Integer.parseInt(s[0]);
            arr[i][1]=Integer.parseInt(s[1]);
        }
        array=new ArrayList[n];
        for(int i=0;i<n;i++){
            array[i]=new ArrayList<>();
        }

        for(int i=0;i<num;i++){
            array[arr[i][0]-1].add(arr[i][1]-1);
            array[arr[i][1]-1].add(arr[i][0]-1);
        }
        dfs(0);
        int ans=0;
        for(int i=0;i<n;i++){
            if(a[i])ans++;
        }
        System.out.println(ans-1);
    }
    static void dfs(int cnt){
        if(a[cnt])return;
        
        a[cnt]=true;
        for(int i=0;i<array[cnt].size();i++){
            dfs(array[cnt].get(i));
        }

    }
    
}