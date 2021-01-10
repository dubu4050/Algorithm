import java.io.*;
        import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int N;
    static int cnt = 0;
    static Queue<Integer> queue = new LinkedList<>();

    static void bfs(int v){
        queue.add(v);
        visited[v]=true;
        while(!queue.isEmpty()){
            v = queue.poll();

            for(int item : list[v]) {
                if (visited[item])
                    continue;
                queue.add(item);
                visited[item]=true;
            }
        }
        cnt++;
    }

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0])+1;
        int T = Integer.parseInt(input[1]);
        list = new ArrayList[N];
        visited = new boolean[N];

        for(int i=0;i<N;i++)
            list[i]=new ArrayList<>();
        int x, y;
        for(int i=0;i<T;i++){
            input = br.readLine().split(" ");
            x=Integer.parseInt(input[0]);
            y=Integer.parseInt(input[1]);
            list[x].add(y);
            list[y].add(x);
        }
        for (int i = 1; i < N; i++)
            Collections.sort(list[i]);

        for(int i=1;i<N;i++){
            if(!visited[i])
                bfs(i);
        }
        System.out.println(cnt);
    }
}
