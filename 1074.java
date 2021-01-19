import java.io.*;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int r, c;
    static int cnt=0;

    static void getResult(int a, int b, int N){
        if(N==1){
            if (a == r && b == c) System.out.println(cnt);
            cnt++;
            return;
        } else {
            int scale = N / 2;

            if (r < a + scale && c < b + scale)
                getResult(a, b, scale);
            else if (r < a + scale && c < b + 2 * scale) {
                cnt += Math.pow(scale, 2);
                getResult(a, b + scale, scale);
            } else if (r < a + 2 * scale && c < b + scale) {
                cnt += Math.pow(scale, 2)*2;
                getResult(a + scale, b, scale);
            } else {
                cnt += Math.pow(scale, 2)*3;
                getResult(a + scale, b + scale, scale);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        getResult(0, 0, (int)Math.pow(2,N));
    }
}
