import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parent;
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

    static boolean check(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y)
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws Exception{
        StringBuilder stringBuilder = new StringBuilder();
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0])+1;
        parent = new int[N];
        for(int i=1;i<N;i++)
            parent[i]=i;

        int T = Integer.parseInt(input[1]);
        int calc, node1, node2;
        for(int i=0;i<T;i++){
            input = br.readLine().split(" ");
            calc = Integer.parseInt(input[0]);
            node1 = Integer.parseInt(input[1]);
            node2 = Integer.parseInt(input[2]);
            if(calc==0)
                union(node1, node2);
            else {
                if(check(node1, node2))
                    stringBuilder.append("YES").append("\n");
                else
                    stringBuilder.append("NO").append("\n");
            }
        }
        System.out.println(stringBuilder.toString().trim());
    }
}
