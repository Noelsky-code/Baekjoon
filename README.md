# Baekjoon 알고리즘 문제 연습

dynamic 알고리즘, kmp 알고리즘, 그래프 알고리즘, 구현 문제 집중 

---

## 14052, 연구소  , java


골드 5문제 , 브루트 포스 + BFS이용
* 브루트 포스 이용하면 충분히 시간안에 해결가능 할거라 생각.  

*  벽을 세울 수 있는 지점 3 곳을 조합으로 구한 후 각각의 경우에 대해 
bfs로 돌려 해결 
* 구현하는데에 시간이 걸려 40분?~ 1시간 정도 걸린 문제.


## 1197 , 최소 스패닝 트리, java
---
마침 알고리즘 수업시간에 MST를 막 다뤘었음. 그래서 풀어 보기로 함.  
  
수업시간에 배운 Prim's 알고리즘을 써도 시간 초과 하지 않을 것 같아서  
Prim's 알고리즘으로 구현하기로 함 
  
그냥 크루스칼이나 프림 알고리즘 둘중에 하나만 알고 있으면 쉽게 풀 수 있을 거라 생각  
단 , 프림 알고리즘으로 풀 때 우선순위큐를 써야 시간초과가 안걸릴 거 같음. 

---
## 1005, ACM Craft
처음에는 bfs로 풀려고 했는데 bfs로 풀면 안된다는 걸 인지 .  
알고있는 알고리즘으로는 풀 수 없는 문제인거 같아서 검색함.  
위상정렬을 사용하는 문제였고 위상정렬 이름은 알고 있었지만 처음으로 배워봄.
### 위상정렬
* 순서가 정해져 있는 작업을 차례로 수행해야할 때 그 순서를 결정해주는 알고리즘. 즉, 방향그래프에 존재하는 각 정점들의 선행 순서를 위배하지 않으면서 모든 정점을 나열함. 
* 방향 그래프에서 가능한 정렬방법. 여러 위상정렬이 가능함. 사이클이 존재하지 않아야함. 
* 진입차수가 0 인 것으로 시작함
* O(V+E)로 가능 

* dfs + 스택 이나 큐를 이용한 방법으로 위상정렬이 가능
---
## 2252 , 줄세우기 

의도치 않게 위상정렬 사용하는 문제 바로 만남     
노드들 간에 먼저 출력해야하는 순서가 정해져 있고  명백하게 순위가 존재하므로 싸이클이 존재 하지 않는다는 걸 단서로 위상정렬을 쓰면 풀 수 있다고 생각함.

위상정렬을 구현하니 바로 풀렸던 문제. 

---

## 1157 , 버블 소트

당연히 input이 50만이니 nlogn 인 다른 정렬방식을 선택해야 하고 머지소트를 이용.  
arr[i] > arr[j] 일 떄 swap 되는 특성은 버블 소트와 동일.  
이 떄, swap되는 횟수는 버블 소트라고 생각하면 swap 은 a[j]와 a[i]가 위치 바꿀 때 mid - i + 1 만큼 스왑해 이동하는 것과 같으므로 answer += mid - i + 1 을 더해줌 . 이 부분이 핵심.  

---

## 9252, LCS2

수업시간에 배운 LCS 문제. 원래 였다면 dfs + dp로 풀었겠지만 bottom up 방식 연습하기 위해 수업시간에 배운 그대로 활용 .  
수업시간에 나온대로 작성하고 dp[i][j] == dp[i-1][j-1]+1 일떄 마킹하는 방법으로 print해줌 .   
print해주는 부분이 조금 생각했어야했던 문제.  

---
## 1759, 암호 만들기
난 TreeSet을 통해 정렬 후 combination 을 만든 후 자음 ,모음 갯수 체크해서 맞다면 출력하는 형식으로 풀었음  
다른 사람 풀이보니까 백트래킹으로 푼 사람도 있는데 굳이? 라는 생각이 들었음  
TreeSet 안쓰고 ArraySort 후 combi 만들고 check후 출력하는게 제일 좋은 풀이라고 생각. 




## 9466, 텀 프로젝트

dfs를 이용. 싸이클을 확인하면 되는 문제라고 생각함.  
내가 생각한 방법으로 풀려니 생각보다 visit_list와 visit_set , checked 배열 등등 필요한 자료구조가 많아서 구현이 생각보다 귀찮았던 문제.    

1. dfs로 탐색하는 동시에 boolean 배열에 탐색했던 index를 넣어줌 (시간 초과 방지하기 위한 배열) 
2. dfs로 탐색을 시작하면 visit_set에 dfs동안 방문했던 index를 넣으며 진행 (싸이클 발생을 확인하기 위함) + visit_list에 방문했던 index를 넣으며 진행
3.  a. visit_set에 이미 있는 index를 탐색한다면 싸이클이 발생한 것이므로 dfs를 정지시키고 list를 poll하여 싸이클을 발생시킨 index가 나올 때 까지 poll함.  
 ->  poll한 갯수를 ++ 해줌 (나는 그냥 전역변수 set에 넣어버림, 이제와서 생각해보니 poll할때마다 갯수만 카운트했으면 됐을 듯)
b.  계속 탐색 진행하다 이미 이전에 탐색했던 index라면 (boolean 배열이 true라면) return하며 종료함 (시간 초과 방지)
  
다른사람 코드를 보니 boolean 배열 두 개로 해결하였음.    
내 코드에서의 checked 역할을 하는 배열 하나(finished), visit_set역할과 같은 배열 하나.(visited)  
싸이클이 발생하면 나는 list에서 poll 하는 형태, 다른 사람들은  visited를 역으로 돌아가서 발생시킨 index를 찾으며 cnt++을 하는 코드를 작성.  

---
