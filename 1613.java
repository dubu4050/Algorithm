import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] distances;
    static StringBuilder stringBuilder = new StringBuilder();
    static final int INF = 1000000000;

    public static void main(String[] args) throws Exception{
        input();
        solve();
        check();
    }

    private static void input() throws Exception{
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        distances = new int[N+1][N+1];

        for(int i = 1 ; i < N + 1 ; i++)
            Arrays.fill(distances[i], INF);

        for(int i = 0 ; i < M ; i++){
            input = br.readLine().split(" ");
            int departure = Integer.parseInt(input[0]);
            int destination = Integer.parseInt(input[1]);
            int weight = 1;
            distances[departure][destination] = weight;
        }

        for(int i = 1 ; i < N + 1 ; i++)
            distances[i][i] = 0;
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
        if(distances[i][j] > distances[i][k] + distances[k][j])
            distances[i][j] = distances[i][k] + distances[k][j];
    }

    private static void check() throws IOException{
        int T = Integer.parseInt(br.readLine());
        String[] input;
        for(int i = 0 ; i < T ; i++){
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int result = distances[x][y];
            if(result == INF){
                if(distances[y][x] == INF)
                    stringBuilder.append(0).append("\n");
                else
                    stringBuilder.append(1).append("\n");
            }else
                stringBuilder.append(-1).append("\n");
        }
        System.out.println(stringBuilder.toString().trim());
    }
}
