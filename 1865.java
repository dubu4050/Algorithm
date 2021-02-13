import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, W;
    static int[] distances;
    static List<Edge> edgeList;
    static StringBuilder stringBuilder = new StringBuilder();
    static final int INF = 1000000000;

    public static void main(String[] args) throws Exception{
        int TC = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < TC ; i++) {
            input();
            if(solve())
                stringBuilder.append("YES").append("\n");
            else
                stringBuilder.append("NO").append("\n");
        }
        System.out.println(stringBuilder.toString().trim());
    }

    private static void input() throws Exception{
        edgeList = new ArrayList<>();
         String[] input = br.readLine().split(" ");
         N = Integer.parseInt(input[0]);
         M = Integer.parseInt(input[1]);
         W = Integer.parseInt(input[2]);

        for(int i = 0 ; i < M ; i++){
            input = br.readLine().split(" ");
            int S = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);
            int T = Integer.parseInt(input[2]);

            edgeList.add(new Edge(S, E, T));
            edgeList.add(new Edge(E, S, T));
        }
        for(int i = 0 ; i < W ; i++) {
            input = br.readLine().split(" ");
            int S = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);
            int T = Integer.parseInt(input[2]);

            edgeList.add(new Edge(S, E, (-1) * T));
        }
    }

    private static boolean solve() {
        distances = new int[N + 1];
        Arrays.fill(distances, INF);
        distances[1] = 0;

        for(int i = 1; i <= N; i++) {
            for(Edge edge : edgeList) {
                if(distances[edge.destination] > distances[edge.departure] + edge.weight) {
                    distances[edge.destination] = distances[edge.departure] + edge.weight;

                    if (i == N) // Negative Cycle
                        return true;
                }
            }
        }
        return false;
    }
}

class Edge{
    int departure;
    int destination;
    int weight;

    public Edge(int departure, int destination, int weight) {
        this.departure = departure;
        this.destination = destination;
        this.weight = weight;
    }
}