import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int input = Integer.parseInt(br.readLine());
        while(input!=-1){
            if(input!=0) {
                if (queue.size() < N)
                    queue.add(input);
            }else{
                queue.poll();
            }
            input = Integer.parseInt(br.readLine());
        }

        if(queue.isEmpty())
            System.out.println("empty");
        else {
            while (!queue.isEmpty()) {
                System.out.print(queue.poll() + " ");
            }
        }
    }
}
