import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, S;
    static StringBuilder stringBuilder = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws Exception{
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        S = Integer.parseInt(stringTokenizer.nextToken());
        arr = new int[N];

        stringTokenizer = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());

        Arrays.sort(arr);
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
        for(int i=0;i<N;i++){
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.addAll(list);
            if(tmp.contains(arr[i]))
                continue;
            tmp.add(arr[i]);
            getResult(tmp);
        }
    }

    static void print(List list){
        list.stream().forEach(s -> stringBuilder.append(s).append(" "));
        stringBuilder.append("\n");
    }

}
