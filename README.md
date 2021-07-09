# Baekjoon 알고리즘 문제 연습

골드5 ~ 골드 1

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
## 1987, 알파벳 
String의 contains 메소드 이용해서 dfs로 풀었음.
시간초과 수준으로 오래 걸림 . 최대 4초 ...간신히 통과한 느낌  
다른 사람 풀이 -> 비트마스킹 활용 
2차원 배열이라 비트 마스킹을 재끼고 contains 썻는데 알파벳 - 'A'로 비트마스킹 하는 거 보고 새로웠음.  
boolean 배열에서 똑같이 알파벳 - 'A'로 인덱싱해서 백트래킹 하는 방법도 있었음. 

---
## 1644, 소수의 연속합
투 포인터, 에라토스테네스의 체 이용  
다른 사람들도 똑같이 풀었음.  

--- 
## 13460, 구슬 탈출2
구현 문제. bfs를 이용해서 탐색함.  
공이 겹치는 부분 처리할 때 더 좋은 방법을 찾지 못해서 일일이 체크해서 처리했는데 다른사람들도 똑같이 한걸 보니 더 좋은 방법은 없는듯.
구현이 조금 시간걸리는거 뺴고는 쉬웠던 문제.   

---
## 1799, 비숍
N-Queen 문제랑 비슷하다고 생각했고 비슷하게 풀었음.  
기본적으로 백트래킹으로 풀었고 2차원 평면이라고 생각하고 대각선을 하나하나 옮기면서 비숍을 놨음.
마치 row하나에 퀸 하나를 두듯 대각선 하나에 비숍 하나를 두게 설계함.  
y=-x+diagonal 로 y,x 인덱싱했음.  
   
내 풀이는 2초 가량 걸려서 간신히 통과함.  

당연히 다른사람들도 비슷한 방법으로 풀었을 줄 알았는데 체스판의 흰색, 검은색을 구분해서 따로 따로 백트래킹함 
-> 흰색 백트래킹 결과 + 검은색  백트래킹 결과 = 답 
검은색, 흰색부분에 비숍을 각각 놓으면 서로 절대 공격할 수 없는 특징을 이용했는 것 같음.  

* 대각선 체크하는 코드 -> while문으로 대각선 오른 위,오른 아래 , 왼 .. 이렇게 일일이 구현안해도 아래 코드처럼 구현하는게 편할것 같음. 메모  

        int[] dx = {-1,-1};
        int[] dy = {-1,1};

        for (int i = 0; i < 2; i++){
            int nx = x;
            int ny = y;
            while (true) {
                if (0 > nx || nx >= N || 0 > ny || ny >= N)
                    break;
                if (visited[nx][ny])
                    return false;

                nx += dx[i];
                ny += dy[i];
            }
        }

---
## 2493, 탑

시간 제한 1.5초 + 입력 500,000 이라서 바로 풀 순 없는 문제.  
고민하다가 가장 가까우면서 가장 큰 값을 계속 찾아내야 한다는 점에서 스택을 이용하기로 결정함.  
두 가지 Case가 발생할 수 있다고 생각함.  
#### 1. 만약 peek 값이 i번째 값보다 큰 경우 
 -> 이 케이스는 문제의 조건에 바로 부합하므로 peek 값을 출력해줌 
 -> 그 다음, i번째 값을 stack에 push해줌. 
 
#### 2. 만약 peek 값이 i번째 값보다 작은 경우
  -> 이 케이스는 1번 조건에 만족할 때 까지 stack을 pop해줌 
  -> 조건에 만족한다면 1번을 그대로 수행해줌 

다른 사람풀이도 비슷했음.  
문제를 보고 스택을 떠올리는 과정이 조금 까다로웠지만 스택을 떠올렸다면 풀만했던 문제. 

---
## 2800, 괄호 제거
어렵진 않았지만 중복을 제거해야하는 케이스 존재...
 1. 스택을 이용해 괄호 위치를 찾음
 2. 찾은 괄호 위치를 이용해 재귀로 모든 경우의 수를 만들어냄 
 3. 정렬 메소드로 정렬한 후 set을 이용해 중복을 제거한 후 출력

(((0))) 같은 테스트 케이스에서 중복해서 출력 가능했음 ..
1번쨰 괄호를 제거한 경우랑 2번쨰 괄호를 제거한 경우 둘 다 ((0))으로 중복되기 떄문. 

---
## 1238, 파티
플로이드 와샬을 사용하면 편했겟지만 n이 1000이기 떄문에 다익스트라 알고리즘을 사용해야 했음.  
다익스트라 알고리즘을 모든 n에 대해서 적용하여 풀었음.  
대충 n제곱*logE 정도의 시간이 걸릴것이라고 생각.
  
   1. 다익스트라 알고리즘을 구현함 
   2. 각 node들에 대해 다익스트라 알고리즘을 돌린 후 목적지 까지의 거리를 계산 
   3. 목적지 node에서 다익스트라 알고리즘을 돌린 결과와 2번에서 얻은 결과를 비교하여 최대값을 찾아냄 
   
다른사람 풀이 -> 역 인접리스트를 사용한 점이 달랐음.   
역 인접리스트를 사용한 이유는 모르겠음. 

--- 
## 1766, 문제집 
풀고 나서 검색해 보니 위상정렬 문제였고 대표 문제였음.  
따라서 위상 정렬을 사용하면 나처럼 복잡하게 안해도 쉽게 풀 수 있는 문제.  
나는 위상정렬임을 생각 못하고 그냥 풀었음.  

나는 3번 조건을 보고 정렬을 해야겠다고 생각했고 n이 32000이므로 nlogn으로 정렬이 가능한 우선순위 큐로 해결하기로 함.  
2번 조건이 이 문제의 핵심이었고 이거 떄문에 위상 정렬이 이 문제의 키워드가 된 거 같음.

나는 2번 조건을 구현하기 위해 Problem 클래스를 만든 후 클래스에 proceed(후행) set과 preceed(선행) set을 구현함 

1. **입력이 들어오면 (preceed proceed) 로 구분한 후 preceed 문제의 proceed set에 proceed를 추가, proceed 문제의 preceed set에 proceed를 추가함** 
2. 우선 순위는 먼저 preceed set의 크기로 구분한 후 만약 크기가 같다면 문제 난이도를 고려하도록 만듬 (preceed set의 크기가 선행 문제의 갯수를 의미)**
3. 우선순위 큐에 모두 넣어줌
4. 반복문을 돌며 매번 poll 해줌 . 이때 poll된 문제의 proceed set의 원소를 순회하며 후행 문제들의 preceed set에 poll된 문제를 제거해줌. -> **이 과정을 통해 선행문제를 제거해줌**   
5. 업데이트된 Problem를 우선순위큐에 다시 넣어줌으로써 우선 순위큐를 업데이트 시켜줌

이 문제를 풀면서 알게 된 점
  * 객체의 element를 업데이트 한다고 해도 우선 순위 큐가 자동으로 업데이트 되지 않음 (즉, 우선 순위 큐에서의 정렬 순위가 바뀌지 않음)
  * 어떤 객체를 poll 또는 add 하더라도 바뀐 객체의 element가 우선 순위 큐에서 정상적으로 업데이트 되지 않음 (힙의 특성 떄문인듯)
  * 따라서 어떤 객체의 element가 업데이트 되고 그 점이 우선 순위 큐에서 반영되길 원할 떄는 해당 객체를 remove 한 후 다시 add해줘야함 (검색 결과 이 방법이 최선인 것 처럼 보임)

---
## 11003, 최솟값 찾기
상당히 어렵? 까다로웠던 문제.  
슬라이딩 윈도우 문제였는데 시간제한이 너무 까다로워 O(n)에 해결할 방법이 필요했음.  
세그먼트 트리, 우선순위 큐의 경우 O(n)조건에 맞지 않을 것이라 생각되서 deque를 이용. 
deque의 맨 앞에 가장 작은 값을 두게 설정하고 i를 증가시키며 arr[i] 보다 큰 값은 윈도우에 굳이 없어도 되므로 삭제시키는 방식으로 O(n)에 맞춤.  
시간제한이 너무 까다로워 최대한 시간을 절약하도록 StringTonkenizer도 사용해야했고 .. 암튼 검색을 통해 최대한 시간을 줄이는 방법을 찾아 풀었음. 