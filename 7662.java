import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static TreeMap<Integer, Integer> map;
    static StringBuilder stringBuilder = new StringBuilder();


    public static void main(String[] args) throws Exception{
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            map = new TreeMap<Integer, Integer>();
            for(int j=0;j<N;j++) {
                StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
                String command = stringTokenizer.nextToken();
                int value = Integer.parseInt(stringTokenizer.nextToken());
                control(command, value);
            }
            print();
        }
        System.out.println(stringBuilder.toString().trim());
    }

    static void control(String command, int value){
        if(command.equals("I"))
            insert(value);
        else
            delete(value);
    }

    static void insert(int key){
        int cnt=0;
        if(map.containsKey(key))
            cnt = map.get(key) + 1;
        map.put(key, cnt);
    }

    static void delete(int key){
        if(map.isEmpty()) return;
        if(key == 1) {
            int lastKey = map.lastKey();
            int lastValue = map.get(lastKey);
            if(lastValue>=1)
                map.replace(lastKey, lastValue-1);
            else
                map.remove(lastKey);
        }
        else {
            int firstKey = map.firstKey();
            int firstValue = map.get(firstKey);
            if(firstValue>=1)
                map.replace(firstKey, firstValue-1);
            else
                map.remove(firstKey);
        }
    }


    static void print(){
        if(map.isEmpty())
            stringBuilder.append("EMPTY");
        else
            stringBuilder.append(map.lastKey()).append(" ").append(map.firstKey());
        stringBuilder.append("\n");
    }
}
