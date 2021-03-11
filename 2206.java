import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, result = 0;
    static boolean[][] arr;
    static int[][] visited;
    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, -1, 0, 1};

    static public void main (String []args ) throws IOException {
        input();
        bfs();
        print();
    }

    private static void print() {
        if(result != 0)
            System.out.println(result);
        else
            System.out.println(-1);
    }

    static private void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new boolean[N][M];
        visited = new int[N][M];
        String tmp;
        for(int i = 0 ; i < N ; i++){
            Arrays.fill(visited[i], Integer.MAX_VALUE);
            tmp = br.readLine();
            for(int j = 0 ; j < M ; j++)
                arr[i][j] = (tmp.charAt(j) == '0'); // 0 == true, 1 == false
        }
    }

    static private void bfs() {
        Queue<Edge> queue = new LinkedList<>();
        queue.add(new Edge(0,0, 1, 0));
        visited[0][0] = 0;

        while(!queue.isEmpty()) {
            Edge now = queue.poll();
            int row = now.row;
            int col = now.col;

            if(row == N-1 && col == M-1) {
                result = now.distance;
                return;
            }
            for(int i = 0 ; i < moveX.length ; i++) {
                int tmpX = col + moveX[i];
                int tmpY = row + moveY[i];

                if(isValid(tmpX, tmpY)) {
                    if(visited[tmpY][tmpX] > now.drill){
                        if(!arr[tmpY][tmpX]) {// 다음이 벽 ㅇㅇ
                            if (now.drill != 0) continue;  // 깬 기록이 있을 시
                            queue.add(new Edge(tmpY, tmpX, now.distance + 1, now.drill + 1));
                            visited[tmpY][tmpX] = now.drill + 1;
                        }else {// 다음이 벽 ㄴㄴ
                            queue.add(new Edge(tmpY, tmpX, now.distance + 1, now.drill));
                            visited[tmpY][tmpX] = now.drill;
                        }
                    }
                }
            }
        }
    }

    private static boolean isValid(int tmpX, int tmpY) {
        return !(tmpX < 0 || tmpX > M - 1 || tmpY < 0 || tmpY > N - 1);
    }
}

class Edge {
    int row;
    int col;
    int distance;
    int drill;

    public Edge(int row, int col, int distance, int drill) {
        this.row = row;
        this.col = col;
        this.distance = distance;
        this.drill = drill;
    }
}