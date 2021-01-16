import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parent;
    static Vertex[] vertexs;
    static ArrayList<Edge> list = new ArrayList<>();
    static int N;

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

        N = Integer.parseInt(input[0]);
        parent = new int[N];
        vertexs = new Vertex[N];

        int x,y,z;
        for(int i=0;i<N;i++){
            input = br.readLine().split(" ");
            x = Integer.parseInt(input[0]);
            y = Integer.parseInt(input[1]);
            z = Integer.parseInt(input[2]);
            vertexs[i]= new Vertex(x, y, z, i);
            parent[i]=i;
        }

        int weight=0;
        Arrays.sort(vertexs, (x1, x2)->{
            return Integer.compare(x1.x, x2.x);
        });
        for(int i=0;i<N-1;i++){
            weight = Math.abs(vertexs[i].x - vertexs[i+1].x);
            list.add(new Edge(vertexs[i].idx, vertexs[i+1].idx, weight));
        }
        Arrays.sort(vertexs, (y1, y2)->{
            return Integer.compare(y1.y, y2.y);
        });
        for(int i=0;i<N-1;i++){
            weight = Math.abs(vertexs[i].y - vertexs[i+1].y);
            list.add(new Edge(vertexs[i].idx, vertexs[i+1].idx, weight));
        }
        Arrays.sort(vertexs, (z1, z2)->{
            return Integer.compare(z1.z, z2.z);
        });
        for(int i=0;i<N-1;i++){
            weight = Math.abs(vertexs[i].z - vertexs[i+1].z);
            list.add(new Edge(vertexs[i].idx, vertexs[i+1].idx, weight));
        }

        Collections.sort(list);

        Edge tmpEdge;
        int tmpX, tmpY;
        int cost = 0;
        for(int i=0;i<list.size();i++) {
            tmpEdge = list.get(i);
            tmpX = tmpEdge.vertex;
            tmpY = tmpEdge.adjVertex;
            if (find(tmpX) == find(tmpY)) continue;
            union(tmpX, tmpY);
            cost += tmpEdge.weight;
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

class Vertex {
    int x;
    int y;
    int z;
    int idx;

    public Vertex(int x, int y, int z, int idx) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.idx = idx;
    }
}