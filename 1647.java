import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parent;
    static int N;
    static int M;

    static int find(int x) {
        if(x == parent[x])
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            if(x < y) parent[y] = x;
            else parent[x] = y;
        }
    }

    public static void main(String[] args) throws Exception{
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0])+1;
        M = Integer.parseInt(input[1]);

        ArrayList<Edge> list = new ArrayList<Edge>();

        for(int i=0;i<M;i++){
            input = br.readLine().split(" ");
            int vertex = Integer.parseInt(input[0]);
            int adjVertex = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            list.add(new Edge(vertex, adjVertex, weight));
        }

        parent = new int[N];
        for(int i=1;i<N;i++)
            parent[i] = i;

        Collections.sort(list);
        Edge tmp;
        int tmpX, tmpY;
        int cost = 0;
        int cnt =0;
        for(int i=0;i<list.size();i++) {
            tmp = list.get(i);
            tmpX = tmp.vertex;
            tmpY = tmp.adjVertex;
            if (find(tmpX) == find(tmpY)) continue;
            union(tmpX, tmpY);
            cost += tmp.weight;
            cnt++;
            if(cnt == N-3)
                break;
        }
        System.out.println(cost);
    }
}

class Edge implements Comparable<Edge> {
    int vertex;
    int adjVertex;
    int weight;

    public Edge(int vertex, int adjVertex, int weight) {
        this.vertex = vertex;
        this.adjVertex = adjVertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(o.weight, this.weight)*-1;
    }
}