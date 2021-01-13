import java.io.*;
        import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int C,N;
    static long getIdx(){
        int left = 1;
        int right = arr[N-1]-arr[0];
        int result = 0;
        int distance = 0;
        while(left<=right){
            int mid = (right+left)/2;
            int start = arr[0];
            int cnt = 1;
            for(int i=1;i<N;i++) {
                distance = arr[i] - start;
                if(distance >= mid){
                    cnt++;
                    start = arr[i];
                }
            }
            if(cnt>=C){
                result=mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        arr = new int[N];

        for(int i=0;i<N;i++)
            arr[i]=Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        System.out.println(getIdx());
    }
}
