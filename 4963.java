import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static boolean[][] visited;
    static int w, h;
    static int cnt=0;

    static void bfs(int x, int y){
        Queue<Pair> queue = new LinkedList<>();
        List<Pair> list = new ArrayList<>();
        queue.add(new Pair(x, y));
        visited[y][x]=true;

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            if(pair.x!=0) {
                list.add(new Pair(pair.x - 1, pair.y));
                if(pair.y!=0)
                    list.add(new Pair(pair.x -1, pair.y -1));
                if(pair.y<h-1)
                    list.add(new Pair(pair.x -1, pair.y +1));
            }
            if(pair.y!=0)
                list.add(new Pair(pair.x, pair.y - 1));
            if(pair.x<w-1) {
                list.add(new Pair(pair.x + 1, pair.y));
                if(pair.y!=0)
                    list.add(new Pair(pair.x + 1, pair.y -1));
                if(pair.y<h-1)
                    list.add(new Pair(pair.x + 1, pair.y +1));
            }
            if(pair.y<h-1)
                list.add(new Pair(pair.x, pair.y+1));


            Pair tmp;
            for(int i=0;i<list.size();i++) {
                tmp = list.get(i);
                if(arr[tmp.y][tmp.x]==0 || visited[tmp.y][tmp.x])
                    continue;
                queue.add(tmp);
                visited[tmp.y][tmp.x]=true;
            }
        }
        cnt++;
    }


    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        while(!input[0].equals("0") && !input[1].equals("0")){
            cnt=0;
            w = Integer.parseInt(input[0]);
            h = Integer.parseInt(input[1]);
            arr = new int[h][w];
            visited = new boolean[h][w];

            for(int i=0;i<h;i++){
                input = br.readLine().split(" ");
                for(int j=0;j<w;j++){
                    arr[i][j]=Integer.parseInt(input[j]);
                }
            }
            for(int i=0;i<w;i++){
                for(int j=0;j<h;j++){
                    if(arr[j][i]==0 || visited[j][i])
                        continue;
                    bfs(i, j);
                }
            }
            stringBuilder.append(cnt).append("\n");
            input = br.readLine().split(" ");
        }
        System.out.println(stringBuilder.toString().trim());
    }
}

class Pair{
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}