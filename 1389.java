import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] distances;
    static final int INF = 1000000000;

    public static void main(String[] args) throws Exception{
        input();
        solve();
        print();
    }

    private static void input() throws Exception{
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        distances = new int[N+1][N+1];

        for(int i = 0 ; i <= N ; i++) // distances 초기화
            Arrays.fill(distances[i], INF);

        for(int i = 0 ; i < M ; i++){ // weight 입력
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            distances[u][v] = 1;
            distances[v][u] = 1;
        }

        for(int i=1;i<=N;i++)
            distances[i][i]=0;
    }

    private static void solve() {
        for(int k = 1 ; k <= N ; k++){
            for(int i = 1 ; i <= N ; i++){
                for(int j = 1 ; j <= N ; j++){
                    edgeRelaxation(i, j, k);
                }
            }
        }
    }

    private static void edgeRelaxation(int i, int j, int k) {
        if(distances[i][j] > distances[i][k] + distances[k][j])
            distances[i][j] = distances[i][k] + distances[k][j];
    }

    private static void print(){

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int i=N;i>=1;i--){
            int tmp = 0;
            for(int j=N;j>=1;j--)
                if(distances[i][j]!=INF)
                    tmp += distances[i][j];
            treeMap.put(tmp, i);
        }
        System.out.println(treeMap.firstEntry().getValue());
    }
}
