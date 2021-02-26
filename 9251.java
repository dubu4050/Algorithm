import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static String first, second;
    static ArrayList<Integer>[] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception{
        input();
        solve();
        System.out.println(dp[N][M]);
    }

    private static void input() throws IOException {
        first = br.readLine();
        N = first.length();
        second = br.readLine();
        M = second.length();

        arr = new ArrayList[N];
        for(int i = 0 ; i < N ; i++)
            arr[i] = new ArrayList<Integer>();

        for(int i = 0 ; i < N ; i++){
            char tmp = first.charAt(i);
            for(int j = 0 ; j < M ; j++){
                if(tmp == second.charAt(j))
                    arr[i].add(j);
            }
        }
        dp = new int[N+1][M+1];
    }

    private static void solve(){
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= M ; j++){
                if(first.charAt(i - 1) == second.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }


}
