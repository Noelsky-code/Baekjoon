
//2263 백준  
import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int inOrder[];
    static int postOrder[];
    
    /*
        pre 오더 : node -> left -> right
        in 오더 : left -> node -> right
        post 오더 : left -> right -> node 

        
    */
        public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        n = Integer.parseInt(br.readLine());
        inOrder = new int[n+1];
        postOrder = new int[n+1];
        String s1[] = br.readLine().split(" ");
        String s2[] = br.readLine().split(" ");
        for(int i=1;i<=n;i++){
            inOrder[i]=Integer.parseInt(s1[i-1]);
            postOrder[i]=Integer.parseInt(s2[i-1]);
        }
        inorder(1, n,n);

    }
    static int find_index(int node){//inorder에서 node의 index 구하기 
        int ret = 0;
        for(int i=1;i<=n;i++){
            if(inOrder[i]==node){
                ret=i;
                break;
            }

        }
        return ret;
    }
    static void inorder(int left,int right,int pre_right){//inoder 에서의 검색 범위 
        int node = postOrder[pre_right];//루트 노트의 숫자
        System.out.printf("%d ",node);//루트노드 방문
        int index = find_index(node);//inorder 에서의 루트노드 인덱스 
        int l_size = index - left;// 왼쪽 서브 트리 사이즈
        int r_size = right- index  ;//오른쪽 서브 트리 사이즈

        
        if(left==right){//리프 노드에 도달 (더이상 서브트리가 없음 )
            return;// index-1 이 right 면 

        }
        if(index-1>=left)inorder(left,index-1,pre_right-r_size-1);//왼쪽 서브트리 방문
        if(index+1<=right)inorder(index+1,right,pre_right-1);//오른쪽 서브트리 방문
        
    }
}
