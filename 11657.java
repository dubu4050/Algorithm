import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static long[] distances;
    static List<Edge> edgeList;
    static StringBuilder stringBuilder = new StringBuilder();
    static final long INF = 10000000000L;

    public static void main(String[] args) throws Exception{
        int cnt = input();
        if(cnt!=0 && solve())
            stringBuilder.append("-1").append("\n");
        else{
            for(int i = 2 ; i < distances.length ; i++) {
                if(distances[i]==INF)
                    distances[i]=-1;
                stringBuilder.append(distances[i]).append("\n");
            }
        }
        System.out.println(stringBuilder.toString().trim());
    }

    private static int input() throws Exception{
        edgeList = new ArrayList<>();
         String[] input = br.readLine().split(" ");
         N = Integer.parseInt(input[0]);
         M = Integer.parseInt(input[1]);
        int cnt = 0;
        for(int i = 0 ; i < M ; i++){
            input = br.readLine().split(" ");
            int S = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);
            int T = Integer.parseInt(input[2]);
            if(S==1) cnt++;
            edgeList.add(new Edge(S, E, T));
        }
        distances = new long[N + 1];
        Arrays.fill(distances, INF);
        return cnt;
    }

    private static boolean solve() {
        distances[1] = 0;
        edgeRelaxation();
        return isNegativeCycle();
    }

    private static void edgeRelaxation() {
        for (int i = 1; i < N; i++) {
            for (Edge edge : edgeList) {
                if (distances[edge.destination] > distances[edge.departure] + edge.weight)
                    distances[edge.destination] = distances[edge.departure] + edge.weight;
            }
        }
    }

    private static boolean isNegativeCycle() {
        for(Edge edge : edgeList){
            if (distances[edge.destination] > distances[edge.departure] + edge.weight)
                return true;
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