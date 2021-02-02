import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, S=0;
    static ArrayList<Integer> arr = new ArrayList<>();
    static boolean[] visited;
    static int cnt=0;

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        for(int i=0;i<N;i++) {
            int tmp = Integer.parseInt(input[i]);
            S+=tmp;
            arr.add(tmp);
            arr.add(tmp*-1);
        }
        Collections.sort(arr);
        visited = new boolean[S];
        getResult(0, 0);
        System.out.println(S-cnt);
    }

    static void getResult(int v, int sum){
        if(sum > 0 && sum <= S){
            if(!visited[sum-1]) {
                visited[sum-1] = true;
                cnt++;
            }
        }
        if(v==2*N)
            return;
        getResult(v + 1, sum + arr.get(v));
        getResult(v + 1, sum);

    }
}
