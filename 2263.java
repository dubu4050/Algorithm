import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder = new StringBuilder();
    static int N;
    static int[] in;
    static int[] position;
    static int[] post;

    public static void main(String[] args) throws Exception{
        input();
        solve(0, N-1, 0, N-1);
        System.out.println(stringBuilder.toString().trim());
    }

    private static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        in = new int[N];
        position = new int[N + 1];
        post = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            in[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            post[i] = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N ; i ++)
            position[in[i]] = i;
    }

    static void solve(int is, int ie, int ps, int pe) {
        if(is>ie || ps>pe) return ;
        int root = post[pe];
        stringBuilder.append(root+" ");

        int inRoot = position[root]; //인오더의 루트 인덱스
        int left = inRoot-is; //포스트오더의 왼쪽 자식의 수

        solve(is, inRoot-1, ps, ps+left-1);
        solve(inRoot+1, ie, ps+left, pe-1);
    }


}