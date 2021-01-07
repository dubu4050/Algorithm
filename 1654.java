import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static long cut(long pivot, List<Long> list){
        long sum=0;
        for(long i: list){
            sum += i/pivot;
        }
        return sum;
    }

    static long getMaxLength(List<Long> list, int M){
        long min = 1, max = list.get(list.size()-1);
        long pivot=1, sum = 0;
        long result = 1;
        while(min<=max){
            pivot = (min+max)/2;
            sum = cut(pivot, list);
            if(sum >= M) {
                min = pivot + 1;
                if(pivot > result)
                    result = pivot;
            } else
                max = pivot-1;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        List<Long> list = new ArrayList<>();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);

        for(int i=0;i<N;i++)
            list.add(Long.parseLong(br.readLine()));

        Collections.sort(list);
        System.out.println(getMaxLength(list, M));
    }
}