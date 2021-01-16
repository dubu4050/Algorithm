import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parent;
    static int N, M;

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

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        parent = new int[N];
        for(int i=0;i<N;i++)
            parent[i]=i;
        int i, x, y;
        boolean flag = false;
        for(i=0;i<M;i++){
            input = br.readLine().split(" ");
            x = Integer.parseInt(input[0]);
            y = Integer.parseInt(input[1]);
            if(find(x)==find(y)) {
                flag = true;
                break;
            }
            union(x, y);
        }
        if(flag) System.out.println(i+1);
        else System.out.println(0);
    }
}
