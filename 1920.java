import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        br.readLine();
        String[] input = br.readLine().split(" ");
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(input).forEach(s -> hashMap.put(Integer.parseInt(s),0));

        br.readLine();
        input = br.readLine().split(" ");

        Arrays.stream(input).forEach(s -> {
            if (hashMap.containsKey(Integer.parseInt(s)))
                stringBuilder.append(1).append("\n");
            else
                stringBuilder.append(0).append("\n");
        });

        System.out.println(stringBuilder.toString().trim());
    }
}
