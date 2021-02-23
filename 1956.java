import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] distances;
    static int INF = 1000000000;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        print();
    }

    private static void print() {
        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i < N + 1 ; i++){
            for(int j = 1 ; j < N + 1 ; j++){
                if(i==j || !check(i, j)) continue;
                min = Math.min(distances[i][j] + distances[j][i], min);
            }
        }
        if(min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }

    private static boolean check(int i, int j){
        if(distances[i][j] != INF && distances[j][i] != INF)
            return true;
        return false;
    }

    private static void input() throws IOException{
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
            int weight = Integer.parseInt(input[2]);
            distances[departure][destination] = weight;
        }

        for(int i = 0 ; i < N ; i++)
            distances[i][i] = 0;
    }

    private static void solve(){
        for(int k = 1 ; k < N + 1 ; k++){
            for(int i = 1 ; i < N + 1 ; i++){
                for(int j = 1 ; j < N + 1 ; j++)
                    edgeRelaxation(i, j, k);
            }
        }
    }

    private static void edgeRelaxation(int i, int j, int k) {
        if(distances[i][j] > distances[i][k] + distances[k][j])
            distances[i][j] = distances[i][k] + distances[k][j];
    }
}
