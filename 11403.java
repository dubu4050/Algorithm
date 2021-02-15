import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
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

        distances = new int[N][N];

        for(int i = 0 ; i < N ; i++) // distances 초기화
            Arrays.fill(distances[i], INF);

        StringTokenizer stringTokenizer;
        for(int i = 0 ; i < N ; i++) { // weight 입력
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if(Integer.parseInt(stringTokenizer.nextToken())!=1) continue;
                distances[i][j]=1;
            }
        }

    }

    private static void solve() {
        for(int k = 0 ; k < N ; k++){
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
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
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            Arrays.stream(distances[i]).forEach(s-> {
                if(s==INF)
                    stringBuilder.append(0+" ");
                else
                    stringBuilder.append(1+" ");
            });
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString().trim());
    }
}
