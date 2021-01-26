import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        int arr[] = new int[1001];
        arr[0]=1;
        arr[1]=1;
        int k;
        for (int i=2;i<1001;i++){
            int value = 1;
            while (true){
                arr[i] = value;
                for(k=1;i-2*k>=0;k++)
                    if (arr[i] - arr[i-k] == arr[i-k] - arr[i-2*k])
                        break;

                if (i-2*k<0) break;
                else value++;
            }
        }

        System.out.println(arr[N]);
    }
}
