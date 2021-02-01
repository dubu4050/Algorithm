import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, S;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws Exception{
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        S = Integer.parseInt(stringTokenizer.nextToken());

        ArrayList<Integer> arrayList = new ArrayList<>();
        getResult(arrayList);
        System.out.println(stringBuilder.toString().trim());
    }

    static void getResult(List list){
        ArrayList<Integer> visited = new ArrayList<>();
        visited.addAll(list);
        if(visited.size()==S){
            print(visited);
            return;
        }
        for(int i=1;i<=N;i++){
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.addAll(list);
            tmp.add(i);
            getResult(tmp);
        }
    }

    static void print(List list){
        for(int i=0;i<list.size()-1;i++){
            if((int)list.get(i)>(int)list.get(i+1))
                return;
        }
        list.stream().forEach(s -> stringBuilder.append(s).append(" "));
        stringBuilder.append("\n");
    }

}
