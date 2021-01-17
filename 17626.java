import java.io.*;
import java.util.Arrays;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        arr[1] = 1;
        int min;
        for(int i=2;i<=N;i++){
            min = Integer.MAX_VALUE;
            for(int j=1; Math.pow(j,2)<= i;j++){
                min = Math.min(min, arr[i-(int)Math.pow(j,2)]);
            }
            arr[i] = min+1;
        }
        System.out.println(arr[N]);
    }
}
