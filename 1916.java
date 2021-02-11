import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int V, E, A, B;
    static ArrayList<Edge>[] arrayLists;
    static int[] distances;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        input();
        solve();
        System.out.println(distances[B]);

    }

    private static void input() throws Exception{
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        arrayLists = new ArrayList[V+1];
        for(int i=1;i<V+1;i++)
            arrayLists[i] = new ArrayList<Edge>();
        String[] input;
        for(int i=0;i<E;i++){
            input = br.readLine().split(" ");
            arrayLists[Integer.parseInt(input[0])].add(new Edge(Integer.parseInt(input[1]), Integer.parseInt(input[2])));
        }
        input = br.readLine().split(" ");
        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);

        distances = new int[V+1];
        visited = new boolean[V+1];
        Arrays.fill(distances, Integer.MAX_VALUE);
    }

    private static void solve() {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        distances[A]=0;
        priorityQueue.add(new Edge(A, distances[A]));

        while(!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();

            for(Edge next : arrayLists[edge.destination]){
                if(visited[next.destination]) continue;
                if(distances[next.destination] > distances[edge.destination] + next.weight) {
                    distances[next.destination] = distances[edge.destination] + next.weight;
                    
                    priorityQueue.add(new Edge(next.destination, distances[next.destination]));
                }
            }
            visited[edge.destination]=true;
            if(edge.destination == B)
                return;
        }
    }

}

class Edge implements Comparable<Edge>{
    int destination;
    int weight;

    public Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}
