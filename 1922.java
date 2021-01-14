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

    static boolean check(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y)
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine())+1;
        M = Integer.parseInt(br.readLine());
        ArrayList<Edge> list = new ArrayList<>();
        parent = new int[N];
        for(int i=0;i<N;i++)
            parent[i] = i;
        String[] input;
        for(int i=0;i<M;i++){
            input = br.readLine().split(" ");
            list.add(new Edge(Integer.parseInt(input[0]),Integer.parseInt(input[1]),Integer.parseInt(input[2])));
        }

        Collections.sort(list);
        Edge tmp;
        int x, y;
        int cost = 0;
        for(int i=0;i<list.size();i++){
            tmp = list.get(i);
            x = tmp.vertex;
            y = tmp.adjvertex;
            if( find (x) == find(y)) continue;
            union(x, y);
            cost += tmp.weight;
        }
        System.out.println(cost);
    }
}

class Edge implements Comparable<Edge> {
    int vertex;
    int adjvertex;
    int weight;

    public Edge(int vertex, int adjvertex, int weight) {
        this.vertex = vertex;
        this.adjvertex = adjvertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return o.weight < this.weight ? 1 : -1;
    }
}