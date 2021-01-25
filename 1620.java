import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        StringBuilder stringBuilder = new StringBuilder();

        HashMap<String, Integer> hashMapName = new HashMap<>();
        HashMap<Integer,String> hashMapIdx = new HashMap<>();

        for(int i=0;i<N;i++) {
            String tmp = br.readLine();
            hashMapName.put(tmp, i + 1);
            hashMapIdx.put(i+1, tmp);
        }
        for(int i=0;i<M;i++){
            String command = br.readLine();
            try {
                int idx = Integer.parseInt(command);
                stringBuilder.append(hashMapIdx.get(idx)).append("\n");
            }catch (NumberFormatException e){
                stringBuilder.append(hashMapName.get(command)).append("\n");
            }
        }
        System.out.println(stringBuilder.toString().trim());

    }
}
