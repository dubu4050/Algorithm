import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, X;
    static ArrayList<Edge>[] arrayLists;
    static int[] distances, result;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        input();
        for(int i = 1 ; i <= N ; i++){
            if(i == X) { // X -> i
                solve(X);
                for(int j = 1; j <= N ; j++) {
                    result[j] += distances[j];
                }
            } else  // i -> X
                result[i] += solve(i);
        }
        int max = Arrays.stream(result).max().orElse(-1);
        System.out.println(max);
    }

    private static void input() throws Exception{
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        X = Integer.parseInt(stringTokenizer.nextToken());

        arrayLists = new ArrayList[N+1];
        for(int i = 0 ; i <= N ; i++)
            arrayLists[i] = new ArrayList<>();

        String[] input;
        for(int i = 0 ; i < M ; i++){
            input = br.readLine().split(" ");
            arrayLists[Integer.parseInt(input[0])].add(new Edge(Integer.parseInt(input[1]), Integer.parseInt(input[2])));
        }
        distances = new int[N+1];
        result = new int[N+1];
    }

    private static int solve(int start) {
        visited = new boolean[N+1];
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        priorityQueue.add(new Edge(start, distances[start]));

        while(!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();
            if(visited[edge.destination]) continue;
            visited[edge.destination]=true;

            for(Edge next : arrayLists[edge.destination]){
                if(distances[next.destination] > distances[edge.destination] + next.weight){
                    distances[next.destination] = distances[edge.destination] + next.weight;

                    priorityQueue.add(new Edge(next.destination, distances[next.destination]));
                }
            }
        }
        return distances[X];
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
