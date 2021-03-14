import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int N;
    static long W;

    static void getVariance(){
        long prev, now,  num;
        for(int i=1; i<N; i++) {
            prev = arr[i-1];
            now = arr[i];
            if(prev<now) {
                num = W/prev;
                W += (now-prev)*num;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Long.parseLong(st.nextToken());
        arr = new int[N];

        for(int i=0; i<N; i++)
            arr[i]=Integer.parseInt(br.readLine());

        getVariance();
        System.out.println(W);

    }
}