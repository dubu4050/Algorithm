import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N=0;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static ArrayList<Pair> parents;

    static void dfs(int v){
        visited[v]=true;
        for(int item : list[v]){
            if(!visited[item]) {
                parents.add(new Pair(item, v));
                dfs(item);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine())+1;
        list = new ArrayList[N];
        visited = new boolean[N];
        parents = new ArrayList<>();

        for(int i=0;i<N;i++){
            list[i] = new ArrayList<Integer>();
        }

        String[] input;
        int x, y=0;
        for(int i=0;i<N-2;i++) {
            input = br.readLine().split(" ");
            x=Integer.parseInt(input[0]);
            y=Integer.parseInt(input[1]);
            list[x].add(y);
            list[y].add(x);
        }

        for (int i = 1; i < N; i++) { // 방문 순서를 위해 오름차순 정렬
            Collections.sort(list[i]);
        }

        dfs(1);
        Collections.sort(parents);
        parents.stream().forEach(s-> System.out.println(s.parent));
    }
}
class Pair implements Comparable<Pair>{
    int node;
    int parent;
    public Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }

    @Override
    public int compareTo(Pair o) {
        return this.node < o.node?-1:1;
    }
}