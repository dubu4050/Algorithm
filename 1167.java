import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int V, E;
    static ArrayList<Edge>[] arrayList;
    static PriorityQueue<Edge> priorityQueue;
    static boolean[] visited;
    static Edge[] edges;

    public static void main(String[] args) throws Exception{
        input();
        init(1);
        solve();
        init(check());
        solve();
        print();
    }

    private static void print() {
        int max = Integer.MIN_VALUE;
        for(int i = 1 ; i < edges.length ; i ++){
            int tmp = edges[i].distance;
            if(tmp == Integer.MAX_VALUE) continue;
            max = Math.max(edges[i].distance, max);
        }

        System.out.println(max);
    }

    private static int check() {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=1;i<V+1;i++) {
            int tmp = edges[i].distance;
            if(tmp == Integer.MAX_VALUE)
                continue;
            else
                map.put(i, tmp);
        }

        List<Integer> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        return keySetList.get(0);
    }

    private static void input() throws Exception{
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        V = Integer.parseInt(stringTokenizer.nextToken());

        arrayList = new ArrayList[V+1];
        for(int i=0;i<V+1;i++)
            arrayList[i] = new ArrayList<>();

        String[] input;
        for(int i = 0 ; i < V ; i ++){
            input = br.readLine().split(" ");
            int cycle = (input.length - 2) / 2;
            for(int j = 0 ; j < cycle ; j ++)
                arrayList[Integer.parseInt(input[0])].add(new Edge(Integer.parseInt(input[2 * j + 1]), Integer.parseInt(input[2 * j + 2])));
        }

    }

    private static void init(int start) {
        priorityQueue = new PriorityQueue<>();
        visited = new boolean[V+1];
        edges = new Edge[V+1];

        for(int i=1;i<V+1;i++){
            if(i==start)
                edges[i] = new Edge(i, 0);
            else
                edges[i] = new Edge(i, Integer.MAX_VALUE);
            priorityQueue.add(edges[i]);
        }
    }

    private static void solve() {
        while(!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();
            if(edge.distance == Integer.MAX_VALUE) break;

            for(Edge next : arrayList[edge.node]){
                if(visited[next.node]) continue;
                if(edges[next.node].distance > edges[edge.node].distance + next.distance) {
                    edges[next.node].distance = edges[edge.node].distance + next.distance;

                    priorityQueue.remove(edges[next.node]);
                    priorityQueue.add(edges[next.node]);
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
