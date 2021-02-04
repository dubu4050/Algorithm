import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int cnt=0;
    static int[] col;

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        col = new int[N];
        int idx = 0;
        for(int row=0;row<N;row++) {
            col[idx]=row;
            queens(idx);
        }
        System.out.println(cnt);
    }

    private static void queens(int idx) {
        if(promising(idx)){
            if(idx==N-1)
                cnt++;
            else {
                for(int j=0;j<N;j++){
                    col[idx+1] = j;
                    queens(idx+1);
                }
            }
        }
    }

    private static boolean promising(int idx) {
        for(int j=0;j<idx;j++){
            if(col[j]==col[idx] || Math.abs(col[j]-col[idx])==idx-j)
                return false;
        }
        return true;
    }
}
