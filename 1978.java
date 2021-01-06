import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int cnt=0;

    static void check(int n){
        for(int i=2;i<n;i++){
            if(n%i==0)
                return;
        }
        cnt++;
    }

    public static void main(String[] args) throws IOException {
        br.readLine();
        String[] arr = br.readLine().split(" ");

        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("1"))
                continue;
            check(Integer.parseInt(arr[i]));
        }
        System.out.println(cnt);
    }
}
