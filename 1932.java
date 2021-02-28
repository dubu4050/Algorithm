import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(Arrays.stream(dp[N-1]).max().getAsInt());
    }

    private static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][N];
        String[] input;
        for(int i = 0 ; i < N ; i++){
            input = br.readLine().split(" ");
            for(int j = 0 ; j < i + 1 ; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        dp[0][0] = arr[0][0];
    }

    private static void solve() {
        for(int i = 1 ; i < N ; i++){
            for(int j = 0 ; j < i + 1 ; j++){
                for(int k = j-1 ; k < j+1; k++){
                    if(k<0) continue;
                    dp[i][j] = Math.max(arr[i][j]+dp[i-1][k], dp[i][j]);
                }
            }
        }
    }


}
