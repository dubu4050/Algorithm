import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0 ; i < N+M ; i++ ){
            String tmp = br.readLine();
            if(hashMap.containsKey(tmp))
                hashMap.put(tmp,1);
            else
                hashMap.put(tmp,0);
        }
        int cnt = 0;
        ArrayList<String> list = new ArrayList<>();
        for(String key : hashMap.keySet()){
            if(hashMap.get(key)==1) {
                cnt++;
                list.add(key);
            }
        }
        stringBuilder.append(cnt).append("\n");
        list.stream().sorted().forEach(a-> stringBuilder.append(a).append("\n"));
        System.out.println(stringBuilder.toString().trim());
    }
}