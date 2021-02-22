import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A, B, C;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve(A, B, C));
    }

    private static void input() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
    }

    private static long solve(int A, int B, int C) {
        if(B == 1)
            return A % C;
        else if(B % 2 == 0) {
            long tmp = solve(A, B / 2, C);
            return (tmp * tmp) % C;
        }
        else
            return (solve(A, B / 2, C) * solve(A, B / 2 + 1, C)) % C;
    }

}
