import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<N;i++)
            arr.add(Integer.parseInt(br.readLine()));
        Collections.sort(arr);

        for(int i:arr)
            stringBuilder.append(i).append('\n');
        System.out.println(stringBuilder.toString());
    }
}
