import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static long cut(long pivot, List<Long> list){
        long sum=0;
        for(long i: list){
            if(i>pivot)
                sum += (i-pivot);
        }
        return sum;
    }

    static long getMaxHeight(List<Long> list, int M){
        long min = 0, max = list.get(list.size()-1);
        long pivot=0, sum = 0;
        while(min<=max){
            pivot = (min+max)/2;
            sum = cut(pivot, list);
            if(sum >= M)
                min = pivot+1;
            else if(sum < M)
                max = pivot-1;
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        List<Long> list = new ArrayList<>();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);
        String[] trees = br.readLine().split(" ");

        Arrays.stream(trees).forEach(s -> list.add(Long.parseLong(s)));
        Collections.sort(list);

        System.out.println(getMaxHeight(list, M));
    }
}
