import java.io.*;
        import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] arr;
    static int N;
    static void get(){
        int left = 0;
        int right = N-1;
        long result = Long.MAX_VALUE;
        long sum = 0;
        int x=0, y=0;
        while(left<right){
            sum = arr[left]+arr[right];
            if(Math.abs(sum) < result) {
                result = Math.abs(sum);
                x = left;
                y = right;
            }
            if(sum<0)
                left++;
            else
                right--;
        }
        System.out.println(arr[x]+" "+arr[y]);
    }

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        String[] input = br.readLine().split(" ");
        for(int i=0;i<N;i++)
            arr[i]=Integer.parseInt(input[i]);
        Arrays.sort(arr);
        get();
    }
}
