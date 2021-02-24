import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[][] arr;
    static int[][] dp;
    static final int WEIGHT = 0;
    static final int VALUE = 1;


    public static void main(String[] args) throws Exception{
        input();
        System.out.println(solve(0, K));
    }

    private static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        arr = new int[N][2];
        dp = new int[N][K+1];

        for(int i = 0 ; i < N ; i++){
            input = br.readLine().split(" ");
            arr[i][WEIGHT] = Integer.parseInt(input[0]);
            arr[i][VALUE] = Integer.parseInt(input[1]);
            Arrays.fill(dp[i], -1);
        }
    }

    private static int solve(int pos, int capacity){
        if (pos == N) return 0;

        int tmp = dp[pos][capacity];
        if (tmp != -1) return tmp;
        if (arr[pos][WEIGHT] <= capacity)
            tmp = solve(pos + 1, capacity - arr[pos][WEIGHT])
                    + arr[pos][VALUE];
        tmp = Math.max(tmp, solve(pos + 1, capacity));
        return dp[pos][capacity] = tmp;
    }
}
