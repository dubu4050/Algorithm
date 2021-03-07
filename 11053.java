import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int L, max;
    static int[] arr;
    static int[] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        solve();
        if(L==1)
            System.out.println(1);
        else
            System.out.println(max);
    }

    private static void input() throws IOException{
        L = Integer.parseInt(br.readLine());
        arr = new int[L];
        dp = new int[L];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < L ; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.fill(dp, 1);

        max = Integer.MIN_VALUE;
    }

    private static void solve() {
        for(int i = 1 ; i < L ; i ++){
            for(int j = 0 ; j < i ; j++){
                if(arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
                max = Math.max(dp[i], max);
            }
        }
    }
}
