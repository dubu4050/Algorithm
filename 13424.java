import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, K;
    static int[][] distances;
    static int INF = 1000000000;
    static int[] persons;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int TC = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < TC ; i++) {
            input();
            solve();
            check();
        }
        System.out.println(stringBuilder.toString().trim());
    }

    private static void check(){
        for(int i = 0 ; i < N + 1 ; i++)
            distances[i][i]=0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 1 ; i < N + 1 ; i++){
            int sum = 0;
            for(int person : persons)
                sum += distances[person][i];
            map.put(i, sum);
        }

        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> {
            if(map.get(o1)!=map.get(o2))
                return map.get(o1).compareTo(map.get(o2));
            else
                return o1.compareTo(o2);
        });
        stringBuilder.append(list.get(0)).append("\n");
    }


    private static void input() throws IOException{
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        distances = new int[N+1][N+1];

        for(int i = 1 ; i < N + 1 ; i++)
            Arrays.fill(distances[i], INF);

        for(int i = 0 ; i < M ; i++) {
            input = br.readLine().split(" ");
            int departure = Integer.parseInt(input[0]);
            int destination = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            distances[departure][destination] = weight;
            distances[destination][departure] = weight;
        }

        for(int i = 0 ; i < N ; i++)
            distances[i][i] = 0;

        K = Integer.parseInt(br.readLine());
        persons = new int[K+1];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for(int i = 1 ; i < K + 1 ; i++)
            persons[i] = Integer.parseInt(stringTokenizer.nextToken());
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
