import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] arr;
    static int[][] distances;
    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        int cnt = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while(N != 0) {
            input();
            stringBuilder.append("Problem "+(++cnt)+": "+solve()).append("\n");
            N = Integer.parseInt(br.readLine());
        }
        System.out.println(stringBuilder.toString().trim());
    }

    private static void input() throws Exception{
        arr = new int[N][N];
        distances = new int[N][N];

        StringTokenizer stringTokenizer;
        for(int i=0;i<N;i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                distances[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    private static int solve() {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        distances[0][0] = arr[0][0];
        priorityQueue.add(new Edge(0, 0, distances[0][0]));
        while(!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();

            for(int i=0;i<4;i++){
                int tmpX = edge.x + moveX[i];
                int tmpY = edge.y + moveY[i];

                if(isValid(tmpX, tmpY)){
                    if(distances[tmpX][tmpY] > distances[edge.x][edge.y] + arr[tmpX][tmpY]) {
                        distances[tmpX][tmpY] = distances[edge.x][edge.y] + arr[tmpX][tmpY];

                        priorityQueue.add(new Edge(tmpX, tmpY, distances[tmpX][tmpY]));
                    }
                }
            }
        }
        return distances[N-1][N-1];
    }

    private static boolean isValid(int tmpX, int tmpY) {
        if(tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= N)
            return false;
        return true;
    }


}

class Edge implements Comparable<Edge>{
    int x;
    int y;
    int weight;

    public Edge(int x, int y, int weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}
