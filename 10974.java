import java.io.*;
import java.util.ArrayList;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    static void print(ArrayList<Integer> arrayList){
        StringBuilder stringBuilder = new StringBuilder();
        arrayList.stream().forEach(s -> {
            stringBuilder.append(s).append(" ");
        });
        System.out.println(stringBuilder.toString().trim());
    }

    static void getResult(ArrayList<Integer> arrayList){
        ArrayList<Integer> visited = new ArrayList<>();
        visited.addAll(arrayList);
        if(arrayList.size()==N){
            print(arrayList);
            return;
        } else {
            for(int i=1;i<=N;i++){
                if(visited.contains(i)) continue;
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.addAll(arrayList);
                tmp.add(i);
                getResult(tmp);
            }
        }
    }
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        getResult(arrayList);
    }
}