import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static boolean[][] visited;
    static int M, N;
    static int max;
    static Queue<Pair> queue = new LinkedList<>();

    static void bfs(int x, int y){
        queue.add(new Pair(x, y));
        List<Pair> list = new ArrayList<>();
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
                if(arr[tmp.y][tmp.x]<1||arr[tmp.y][tmp.x]>1)
                    continue;
                queue.add(tmp);
                max = Math.max(max, arr[pair.y][pair.x]+1);
                arr[tmp.y][tmp.x]=arr[pair.y][pair.x]+1;
                if(tmp.y==(N-1) && tmp.x==(M-1)) {
                    return;
                }
            }
            list.clear();
        }
    }


    public static void main(String[] args) throws IOException {
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            input = br.readLine().split("");
            for(int j=0;j<M;j++)
                arr[i][j]=Integer.parseInt(input[j]);
        }
        bfs(0,0);
        System.out.println(max);
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