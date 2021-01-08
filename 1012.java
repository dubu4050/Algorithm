import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] visited;
    static int[][] arr;
    static int cnt = 0;
    static int N,M;

    static class Pair{
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y){
        Queue<Pair> queue = new LinkedList<>();
        List<Pair> list = new ArrayList<>();
        queue.add(new Pair(x, y));
        visited[y][x]=1;
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            if(pair.x!=0)
                list.add(new Pair(pair.x-1, pair.y));
            if(pair.y!=0)
                list.add(new Pair(pair.x, pair.y-1));
            if(pair.x<M-1)
                list.add(new Pair(pair.x+1, pair.y));
            if(pair.y<N-1)
                list.add(new Pair(pair.x, pair.y+1));
            Pair tmp;
            for(int i=0;i<list.size();i++) {
                tmp = list.get(i);
                if(arr[tmp.y][tmp.x]==0 || visited[tmp.y][tmp.x]==1)
                    continue;
                queue.add(tmp);
                visited[tmp.y][tmp.x]=1;
            }
        }
        cnt++;
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for(int t=0;t<T;t++){
            cnt=0;
            String[] input = br.readLine().split(" ");
            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            int K = Integer.parseInt(input[2]);

            arr = new int[N][M];
            visited = new int[N][M];
            String[] xy;
            for(int i=0;i<K;i++){
                xy=br.readLine().split(" ");
                arr[Integer.parseInt(xy[1])][Integer.parseInt(xy[0])]=1;
            }
            for(int i=0;i<M;i++){
                for(int j=0;j<N;j++){
                    if(arr[j][i]==0 || visited[j][i]==1)
                        continue;
                    bfs(i, j);
                }
            }
            stringBuilder.append(cnt).append("\n");
        }
        System.out.println(stringBuilder.toString().trim());
    }
}