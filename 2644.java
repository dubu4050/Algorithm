import java.io.*;
        import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static boolean[] visited;
    static int N;
    static int cnt = 0;
    static int start, end;
    static boolean flag = false;

    static boolean dfs(int v){
        cnt++;
        visited[v] = true;
        if(v == end)
            return true;
        for(int i=1;i<N;i++){
            if(arr[v][i] == 0 || visited[i])
                continue;
            else{
                if(dfs(i))
                    return true;
                else
                    cnt--;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine())+1;
        String[] input = br.readLine().split(" ");
        start = Integer.parseInt(input[0]);
        end = Integer.parseInt(input[1]);

        arr = new int[N][N];
        visited = new boolean[N];
        int x, y;
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            input = br.readLine().split(" ");
            x = Integer.parseInt(input[0]);
            y = Integer.parseInt(input[1]);
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        if(dfs(start))
            System.out.println(cnt-1);
        else
            System.out.println(-1);
    }
}
