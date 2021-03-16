import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] arr;
    static int[][] distance;

    public static void main(String[] args) throws Exception{
        input();
        System.out.println(Math.min(Math.min(distance[N][0], distance[N][1]), distance[N][2]));
    }

    private static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][3];
        distance = new int[N+1][3];

        arr[0][0] = arr[0][1] = arr[0][2] = distance[0][0] = distance[0][1] = distance[0][2] = 0;
        StringTokenizer st;
        for(int i = 1 ; i <= N ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3 ; j ++)
                arr[i][j] = Integer.parseInt(st.nextToken());
            distance[i][0] = Math.min(distance[i-1][1], distance[i-1][2]) + arr[i][0];
            distance[i][1] = Math.min(distance[i-1][0], distance[i-1][2]) + arr[i][1];
            distance[i][2] = Math.min(distance[i-1][0], distance[i-1][1]) + arr[i][2];
        }
    }
}