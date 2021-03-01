import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < TC ; i++){
            input();
            solve();
            stringBuilder.append(Math.max(dp[0][N], dp[1][N])).append("\n");
        }
        System.out.println(stringBuilder.toString().trim());
    }

    private static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[2][N+1];
        dp = new int[2][N+1];
        StringTokenizer st;
        for(int i = 0 ; i < 2 ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j < N + 1 ; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[0][1] = arr[0][1];
        dp[1][1] = arr[1][1];
    }

    private static void solve() {
        for(int i = 2 ; i < N + 1 ; i++){
            dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i];
            dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i];
        }
    }
}
