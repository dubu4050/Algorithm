import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Vertex> parent = new ArrayList<>();
    static int N;
    static int M;

    static int find(Vertex x) {
        if(x.parent == parent.get(x.parent).parent)
            return x.parent;
        else
            return parent.get(x.parent).parent = find(parent.get(x.parent));
    }

    static void union(Vertex x, Vertex y){
        x.parent = find(x);
        y.parent = find(y);
        if(x.parent != y.parent){
            if(x.parent < y.parent) parent.get(y.parent).parent = x.parent;
            else parent.get(x.parent).parent = y.parent;
        }
    }

    public static void main(String[] args) throws Exception{
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0])+1;
        M = Integer.parseInt(input[1]);
        parent.add(new Vertex(0, 0, 0));
        ArrayList<Edge> list = new ArrayList<Edge>();
        Vertex tmp, target;
        double tmpWeight;
        for(int i=1;i<N;i++){
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            tmp = new Vertex(x, y, i);
            for(int j=1;j<parent.size();j++){
                target = parent.get(j);
                tmpWeight = Math.sqrt(Math.pow((target.x-tmp.x),2)+Math.pow((target.y-tmp.y),2));
                list.add(new Edge(tmp, target, tmpWeight));
            }
            parent.add(tmp);
        }

        for(int i=0;i<M;i++) {
            input = br.readLine().split(" ");
            union(parent.get(Integer.parseInt(input[0])), parent.get(Integer.parseInt(input[1])));
        }
        Collections.sort(list);

        Edge tmpEdge;
        Vertex tmpX, tmpY;
        double cost = 0;
        for(int i=0;i<list.size();i++) {
            tmpEdge = list.get(i);
            tmpX = tmpEdge.vertex;
            tmpY = tmpEdge.adjVertex;
            if (find(tmpX) == find(tmpY)) continue;
            union(tmpX, tmpY);
            cost += tmpEdge.weight;
        }
        System.out.println(String.format("%.2f", cost));
    }
}

class Edge implements Comparable<Edge> {
    Vertex vertex;
    Vertex adjVertex;
    double weight;

    public Edge(Vertex vertex, Vertex adjVertex, double weight) {
        this.vertex = vertex;
        this.adjVertex = adjVertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(o.weight, this.weight)*-1;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "vertex=" + vertex.x+":"+vertex.y +
                ", adjVertex=" + adjVertex.x +":"+adjVertex.y+
                ", weight=" + weight +
                '}';
    }
}

class Vertex {
    int x;
    int y;
    int parent;

    public Vertex(int x, int y, int parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }
}