import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static ArrayList<Integer>[] arrayList;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] visited;
    static int result = Integer.MAX_VALUE;
    static int MAX_LEN = 100001*2;

    static void bfs(){
        queue.add(N);
        visited[N]=1;
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            if(tmp == K)
                result = Math.min(result, visited[K] - 1);

            int tmpCnt = visited[tmp];
            ArrayList<Integer> iter = arrayList[tmp];
            for(int i = 0 ; i < arrayList[tmp].size() ; i++){
                int w = iter.get(i);
                if(w < MAX_LEN){
                    if (visited[w] != 0 && visited[w] <= tmpCnt) continue;
                    queue.add(w);
                    visited[w] = tmpCnt;
                    if(i == 0 && tmp != 0) continue;
                    visited[w] += 1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList[MAX_LEN];
        visited = new int[MAX_LEN];

        for(int i = 0 ; i < MAX_LEN ; i++)
            arrayList[i] = new ArrayList<>();

        arrayList[0].add(1);

        for(int i = 1 ; i < MAX_LEN ; i++) {
            arrayList[i].add(i*2);
            arrayList[i].add(i+1);
            arrayList[i].add(i-1);
        }
        bfs();
        System.out.println(result);
    }
}
