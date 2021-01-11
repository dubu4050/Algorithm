import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int min = 0;
    static int max = 0;

    public static void check(int n1, int n2){
        int tmp=1;
        int pivot = n1;
        if(n2<n1) pivot=n2;
        while(true) {
            int cnt =0;
            for (int i = 2; i < pivot+1; i++) {
                if (n1 % i == 0 && n2 % i == 0) {
                    tmp *= i;
                    n1 /= i;
                    n2 /= i;
                    cnt ++;
                }
            }
            if(cnt ==0)
                break;
        }
        min = tmp;
        max = tmp*n1*n2;
    }

    public static void main(String[] args) throws IOException {
        String tmp[] = br.readLine().split(" ");

        check(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
        System.out.print(min+"\n"+max);
    }
}
