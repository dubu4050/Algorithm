import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static int[][] sum;
    static Point[] ranges;
    static int N, M;

    static public void main (String []args ) throws IOException {
        input();
        init();
        solve();
    }

    static private void input() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]) + 1;
        M = Integer.parseInt(input[1]);
        arr = new int[N][N];
        sum = new int[N][N];
        ranges = new Point[M];

        StringTokenizer st;
        for(int i = 1 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j < N ; j ++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0 ; i < M ; i ++){
            input = br.readLine().split(" ");
            int sourceX = Integer.parseInt(input[0]);
            int sourceY = Integer.parseInt(input[1]);
            int destX = Integer.parseInt(input[2]);
            int destY = Integer.parseInt(input[3]);
            ranges[i] = new Point(sourceX, sourceY, destX, destY);
        }
    }

    private static void init() {
        sum[0][0] = arr[0][0];
        //col
        for(int i = 1 ; i < N ; i ++){
            sum[i][1] = arr[i][1];
            for(int j = 2 ; j < N ; j ++)
                sum[i][j] = sum[i][j-1] + arr[i][j];
        }

        //row
        for(int i = 2 ; i < N ; i ++){
            for(int j = 1 ;  j < N ; j ++){
                sum[i][j] += sum[i-1][j];
            }
        }
    }

    private static void solve() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Point point : ranges){
            stringBuilder.append(
                    sum[point.dX][point.dY]
                            - sum[point.sX - 1][point.dY]
                            - sum[point.dX][point.sY - 1]
                            + sum[point.sX - 1][point.sY - 1]
            ).append("\n");
        }
        System.out.println(stringBuilder.toString());
    }
}

class Point{
    int sX, sY;
    int dX, dY;

    public Point(int sX, int sY, int dX, int dY) {
        this.sX = sX;
        this.sY = sY;
        this.dX = dX;
        this.dY = dY;
    }
}
