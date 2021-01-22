import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N+1];

        arr[0]=1;
        arr[1]=2;
        for(int i=2;i<N;i++)
            arr[i]=(arr[i-1]+arr[i-2])%10007;

        System.out.println(arr[N-1]);

    }
}
