import java.util.*;



import java.io.*;

public class Main {
    
// 1157 , 버블 소트
//  
    static int[] copy;
    static int[] arr;
    static long answer;
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(Scolstem.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int n = Integer.parseInt(br.readLine());
        String s[] = br.readLine().split(" ");
        arr = new int[n];
        copy=  new int[n];
        answer =0;
        for(int i=0;i<n;i++)arr[i]=Integer.parseInt(s[i]);
        merge_sort(0,n-1);
        System.out.println(answer);

    }
    static void merge_sort(int left, int right){
        if(left>=right){
            return;
        }
        int mid = (left+right)/2;
        merge_sort(left,mid);
        merge_sort(mid+1,right);
        merge(left,mid,right);
    }
    static void merge(int left,int mid, int right){
        int i = left;
        int j = mid+1;
        int cnt= left;
        while(i<=mid && j <=right){
            if(arr[i]>arr[j]){
                copy[cnt++] = arr[j++];
                answer += mid - i +1 ;
            }
            else{
                copy[cnt++]=arr[i++];
            }
        }
        
        while(j<=right){
            copy[cnt++]= arr[j++];
        }
       
        while(i<=mid){
            copy[cnt++] = arr[i++];
        }

        for(int t = left ; t<= right ; t++){
            arr[t] = copy[t];
        }
    }
    
}
