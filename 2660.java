import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] distances;
    static int INF = 1000000000;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        print();
    }

    private static void print() {
        Map<Integer, Integer> result = new HashMap<>();
        for(int i = 1 ; i < N + 1 ; i++){
            int max = Integer.MIN_VALUE;
            for(int j = 1 ; j < N + 1 ; j++){
                if(distances[i][j] == 0 || distances[i][j] == INF || i==j)
                    continue;
                max = Math.max(distances[i][j], max);
            }
            if(max!=Integer.MIN_VALUE)
                result.put(i, max);
        }

        List<Integer> keySetList = new ArrayList<Integer>(result.keySet());
        Collections.sort(keySetList, (o1, o2) -> (result.get(o1).compareTo(result.get(o2))));
        int min = Collections.min(result.values());
        int cnt = 0;
        StringBuilder list = new StringBuilder();
        for(int key : keySetList){
            if(result.get(key) == min) {
                cnt ++;
                list.append(key).append(" ");
            }
        }
        stringBuilder.append(min+" "+cnt).append("\n");
        stringBuilder.append(list);
        System.out.println(stringBuilder.toString().trim());
    }

    private static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        String[] input;
        distances = new int[N+1][N+1];

        for(int i = 1 ; i < N + 1 ; i++)
            Arrays.fill(distances[i], INF);

        while(true){
            input = br.readLine().split(" ");
            int departure = Integer.parseInt(input[0]);
            int destination = Integer.parseInt(input[1]);
            if(departure == -1 && destination == -1)
                break;
            int weight = 1;
            distances[departure][destination] = weight;
            distances[destination][departure] = weight;
        }

        for(int i = 0 ; i < N ; i++)
            distances[i][i] = 0;
    }

    private static void solve(){
        for(int k = 1 ; k < N + 1 ; k++){
            for(int i = 1 ; i < N + 1 ; i++){
                for(int j = 1 ; j < N + 1 ; j++)
                    edgeRelaxation(i, j, k);
            }
        }
    }

    private static void edgeRelaxation(int i, int j, int k) {
        if(distances[i][j] > distances[i][k] + distances[k][j])
            distances[i][j] = distances[i][k] + distances[k][j];
    }
}
