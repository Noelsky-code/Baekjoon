import java.util.*;



import java.io.*;

public class Main {
    
// 9252 , LCS2 
// 수업시간에 배운 lCS 활용 . 

    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(Scolstem.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String s1 = br.readLine();
        String s2 = br.readLine();
        int l1 =s1.length();
        int l2 =s2.length();
        int dp[][] = new int[l1+1][l2+1];
        int arr[][] = new int[l1+1][l2+1];
        StringBuilder sb = new StringBuilder();
        int cnt= 0; 
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    cnt = Math.max(dp[i][j],cnt);
                    arr[i][j]=1;
                    //sb.append(s1.charAt(i-1));
                    
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(cnt);
        int i=l1;int j=l2;
        while(i!=0&&j!=0){
            if(arr[i][j]==1){
                sb.append(s1.charAt(i-1));
                i--;j--;
            }
            else if(dp[i-1][j]<dp[i][j-1]){
                j--;
            }
            else{
                i--;
            }
        }
        if(cnt==0){
        }
        else{
            System.out.println(sb.reverse().toString());
        }
        
    }
    
}
