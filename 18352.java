import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int V, E, K, X;
    static ArrayList<Edge>[] arrayList;
    static Queue<Edge> queue;
    static boolean[] visited;
    static int[] distances;

    public static void main(String[] args) throws Exception{
        input();
        solve();
        print();
    }

    private static void print() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=1;i<V+1;i++) {
            if(distances[i]==K)
                stringBuilder.append(i).append("\n");
        }
        if(stringBuilder.length()!=0)
            System.out.println(stringBuilder.toString().trim());
        else
            System.out.println(-1);
    }

    private static void input() throws Exception{
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        V = Integer.parseInt(stringTokenizer.nextToken());
        E = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());
        X = Integer.parseInt(stringTokenizer.nextToken());

        arrayList = new ArrayList[V+1];
        for(int i=0;i<V+1;i++)
            arrayList[i] = new ArrayList<>();

        String[] input;
        for(int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            arrayList[Integer.parseInt(input[0])].add(new Edge(Integer.parseInt(input[1]), 1));
        }

        visited = new boolean[V+1];
        distances = new int[V+1];
    }


    private static void solve() {
        queue = new LinkedList<>();
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[X] = 0;
        queue.add(new Edge(X, 0));
        while(!queue.isEmpty()){
            Edge edge = queue.poll();
            if(edge.distance == Integer.MAX_VALUE) break;

            for(Edge next : arrayList[edge.node]){
                if(visited[next.node] || distances[next.node]==1) continue;
                if(distances[next.node] > distances[edge.node] + next.distance) {
                    distances[next.node] = distances[edge.node] + next.distance;

                    queue.add(new Edge(next.node ,distances[next.node]));
                }
            }
            visited[edge.node] = true;
        }
    }
}

class Edge implements Comparable<Edge>{
    int node;
    int distance;

    public Edge(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.distance, o.distance);
    }
}
