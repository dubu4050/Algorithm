import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashSet<Integer> set = new HashSet<>();
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        String[] input;

        for (int i=0;i<N;i++)
            control(br.readLine().split(" "));
        System.out.println(stringBuilder.toString().trim());
    }

    static void control(String[] input){
        switch (input[0]){
            case "add":
                set.add(Integer.parseInt(input[1]));
                break;
            case "remove":
                set.remove(Integer.parseInt(input[1]));
                break;
            case "check":
                stringBuilder.append(set.contains(Integer.parseInt(input[1]))?1:0).append("\n");
                break;
            case "toggle":
                int tmp = Integer.parseInt(input[1]);
                if(set.contains(tmp)) set.remove(tmp);
                else set.add(tmp);
                break;
            case "all":
                for(int i=1;i<21;i++)
                    set.add(i);
                break;
            case "empty":
                set.clear();
                break;
        }
    }
}