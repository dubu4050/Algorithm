import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N, M;
    static BigInteger[][] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve(N, M));
    }

    private static void input() throws IOException{
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        dp = new BigInteger[N + 1][N + 1];

        for(int i = 0 ; i < N + 1 ; i++){
            dp[i][i] = new BigInteger("1");
            dp[i][0] = new BigInteger("1");
        }
    }

    private static BigInteger solve(int n, int m) {
        if(dp[n][m] == null)
            dp[n][m] = solve(n - 1, m - 1).add(solve(n - 1, m));
        return dp[n][m];
    }
}
