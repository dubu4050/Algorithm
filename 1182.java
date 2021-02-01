import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, S;
    static int[] arr;
    static int cnt=0;

    public static void main(String[] args) throws Exception{
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        S = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i=0;i<N;i++)
            arr[i]=Integer.parseInt(input[i]);
        Arrays.sort(arr);

        getResult(0, 0);

        if(S==0) cnt--;
        System.out.println(cnt);
    }

    static void getResult(int v, int sum){
        if(v==N){
            if(sum==S) cnt++;
            return;
        }
        getResult(v+1, sum+arr[v]);
        getResult(v+1, sum);
    }
}