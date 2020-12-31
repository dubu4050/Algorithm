import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1;i<N+1;i++)
            queue.add(i);

        System.out.print("<");

        while(!queue.isEmpty()){
            for(int i=0;i<K-1;i++){
                queue.add(queue.poll());
            }
            System.out.print(queue.poll());
            if(!queue.isEmpty())
                System.out.print(", ");
        }
        System.out.print(">");
    }
}