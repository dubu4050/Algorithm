import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static boolean[][] visited;
    static int N;
    static int cnt = 0;
    static Queue<Pair> queue = new LinkedList<>();

    static void bfs(int x, int y, int pivot){
        queue.add(new Pair(x, y));
        visited[y][x]=true;
        List<Pair> list = new ArrayList<>();
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            if(pair.x!=0)
                list.add(new Pair(pair.x-1, pair.y));
            if(pair.y!=0)
                list.add(new Pair(pair.x, pair.y-1));
            if(pair.x<N-1)
                list.add(new Pair(pair.x+1, pair.y));
            if(pair.y<N-1)
                list.add(new Pair(pair.x, pair.y+1));
            Pair tmp;

            for(int i=0;i<list.size();i++) {
                tmp = list.get(i);
                if(arr[tmp.y][tmp.x]<= pivot || visited[tmp.y][tmp.x])
                    continue;
                queue.add(tmp);
                visited[tmp.y][tmp.x]=true;
            }
            list.clear();
        }
        cnt++;
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        String[] input;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            input = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(input[j]);
                if(arr[i][j]<min)
                    min=arr[i][j];
                if(arr[i][j]>max)
                    max=arr[i][j];
            }
        }
        int result = 0;
        if(min==1)
            min--;
        for(int pivot = min; pivot <= max ; pivot++) {
            cnt=0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] > pivot && !visited[i][j])
                        bfs(j, i, pivot);
                }
            }
            if( result < cnt )
                result = cnt;
            visited = new boolean[N][N];
        }
        System.out.println(result);
    }
}

class Pair{
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}