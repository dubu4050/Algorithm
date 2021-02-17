import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Edge[] edges;
    static boolean[][] distances;
    static StringBuilder stringBuilder = new StringBuilder();
    static final int INF = 1000000000;

    public static void main(String[] args) throws Exception{
        int TC = Integer.parseInt(br.readLine());
        for(int i=0;i<TC;i++) {
            input();
            solve();
            print();
        }
        System.out.println(stringBuilder.toString().trim());
    }

    private static void input() throws Exception{
        N = Integer.parseInt(br.readLine()) + 2;
        distances = new boolean[N+1][N+1];
        edges = new Edge[N+1];
        String[] input;

        for(int i = 1 ; i < N + 1 ; i++)
            Arrays.fill(distances[i], false);
        for(int i = 0 ; i < N ; i++){
            input = br.readLine().split(" ");
            edges[i+1] = new Edge(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            if(i>0)
                getEdges(i+1);
        }
        for(int i = 1 ; i < N + 1 ; i++)
            distances[i][i] = false;
    }

    private static void getEdges(int idx) {
        for(int i = 1 ; i < idx ; i++){
            distances[i][idx] = getDistance(i, idx) <= 1000 ? true : false;
            distances[idx][i] = getDistance(idx, i) <= 1000 ? true : false;
        }
    }

    private static void solve() {
        for(int k = 1 ; k < N + 1 ; k++){
            for(int i = 1 ; i < N + 1 ; i++){
                for(int j = 1 ; j < N + 1 ; j++){
                    edgeRelaxation(i, j, k);
                }
            }
        }
    }

    private static void edgeRelaxation(int i, int j , int k) {
        if(distances[i][k] && distances[k][j])
            distances[i][j] = true;
    }

    private static void print(){
        if(distances[1][N])
            stringBuilder.append("happy").append("\n");
        else
            stringBuilder.append("sad").append("\n");
    }

    private static int getDistance(int x, int y){
        return Math.abs(edges[x].x-edges[y].x) + Math.abs(edges[x].y - edges[y].y);
    }

}

class Edge{
    int x, y;

    public Edge(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
