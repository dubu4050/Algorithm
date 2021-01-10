import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static boolean[][] visited;
    static int N;
    static int cnt = 0;
    static int R = 82;
    static int G = 71;
    static int B = 66;
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

            for(Pair tmp : list){
                if(arr[tmp.y][tmp.x] != pivot || visited[tmp.y][tmp.x])
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
        String input;
        int[] rgb = {R, G, B};
        int[] rgb_weak = {R, B};

        for (int i = 0; i < N; i++) {
            input = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        for(int c:rgb){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(arr[i][j]!=c || visited[i][j])
                        continue;
                    bfs(j, i, c);
                }
            }
        }
        System.out.print(cnt+" ");
        cnt=0;
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j]==G) arr[i][j]=R;
            }
        }

        for(int c:rgb_weak){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(arr[i][j]!=c || visited[i][j])
                        continue;
                    bfs(j, i, c);
                }
            }
        }
        System.out.print(cnt);
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

