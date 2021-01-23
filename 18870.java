import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];

        for(int i=0;i<input.length;i++)
            arr[i] = Integer.parseInt(input[i]);
        int[] copiedArr = arr.clone();
        Arrays.sort(copiedArr);

        int cnt = 0;
        for(int key : copiedArr){
            if(map.containsKey(key)) continue;
            map.put(key, cnt);
            cnt++;
        }
        Arrays.stream(arr).forEach( i -> {
            stringBuilder.append(map.get(i)).append(" ");
        });
        System.out.println(stringBuilder.toString().trim());
    }
}
