import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] visited = new int[1001];
    static int[][] arr = new int[1001][1001];
    static StringBuilder stringBuilder = new StringBuilder();

    static void dfs(int V){
        stringBuilder.append(V).append(" ");
        visited[V]=1;
        for(int i=1;i<1001;i++){
            if(arr[V][i]==0 || visited[i]==1)
                continue;
            dfs(i);
        }
    }

    static void bfs(int V){
        stringBuilder.setLength(0);
        Queue<Integer> queue = new LinkedList<>();

        queue.add(V);
        visited[V]=0;
        while(!queue.isEmpty()){
            V = queue.poll();
            stringBuilder.append(V).append(" ");
            for(int i=1;i<1001;i++){
                if(arr[V][i]==0 || visited[i]==0)
                    continue;
                queue.add(i);
                visited[i]=0;
            }
        }
        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) throws IOException {
        String input[] = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]),
                M = Integer.parseInt(input[1]),
                V = Integer.parseInt(input[2]);
        String[] xy;
        int x = 0, y = 0;

        for(int i=0;i<M;i++){
            xy=br.readLine().split(" ");
            x = Integer.parseInt(xy[0]);
            y = Integer.parseInt(xy[1]);
            arr[x][y]=1;
            arr[y][x]=1;
        }
        dfs(V);
        System.out.println(stringBuilder.toString());
        bfs(V);
    }
}
