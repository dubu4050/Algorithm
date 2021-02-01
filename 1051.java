import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, length;
    static int[][] arr;
    static int maxSize=1;

    public static void main(String[] args) throws Exception{
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        length = Math.min(N,M);

        arr= new int[N][M];

        String input;
        for(int i=0;i<N;i++){
            input = br.readLine();
            for(int j=0;j<M;j++)
                arr[i][j] = (int)input.charAt(j) - '0';
        }
        getResult();
        System.out.println(maxSize);
    }

    static void getResult(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                int t = 1;
                while(t<length){
                    if(i+t<N && j+t<M){
                        if(check(i, j, t))
                            maxSize = Math.max((t+1)*(t+1), maxSize);
                    }
                    t++;
                }
            }
        }
    }

    static boolean check(int i, int j, int t){
        int target = arr[i][j];

        if(arr[i][j+t] != target) return false;
        if(arr[i+t][j] != target) return false;
        if(arr[i+t][j+t] != target) return false;
        return true;
    }

}