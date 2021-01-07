import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long summation(long pivot, List<Long> list){
        long sum=0;
        for(long i: list){
            if(i>pivot)
                sum += pivot;
            else
                sum += i;
        }
        return sum;
    }

    static long getMax(List<Long> list, long M){
        if(list.size()==1)
            return list.get(0) >= M ? M :list.get(0);

        long min = 1, max = list.get(list.size()-1);
        long pivot=1, sum = 0;
        long result = 1;
        long max_pivot = 1;
        while(min<=max){
            pivot = (min+max)/2;
            sum = summation(pivot, list);
            if(sum > M)
                max = pivot - 1;
            else if(sum <= M) {
                min = pivot + 1;
                if(sum > result) {
                    result = sum;
                    max_pivot=pivot;
                }
            }
            else
                break;
        }
        return max_pivot;
    }

    public static void main(String[] args) throws IOException {
        List<Long> list = new ArrayList<>();
        br.readLine(); // N
        String[] input = br.readLine().split(" ");
        long M = Long.parseLong(br.readLine());
        Arrays.stream(input).forEach(s -> list.add(Long.parseLong(s)));

        Collections.sort(list);
        System.out.println(getMax(list, M));
    }
}
