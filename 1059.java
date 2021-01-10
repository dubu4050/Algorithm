import java.io.*;
        import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int left=1, right=1;

    static int getIdx(int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]>target)
                return i;
            else if (arr[i]==target)
                return -1;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(input[i]);
        Arrays.sort(arr);

        int target = Integer.parseInt(br.readLine());
        int idx = getIdx(target);
        if(idx==-1)
            System.out.println(0);
        else if(idx>0){
            right = arr[idx];
            left = arr[idx-1];
            int result = (target-left) * (right-target) - 1;
            System.out.println(result);
        }else{
            right = arr[idx];
            int result = (target-left) * (right - target) + (right-target-1);
            System.out.println(result);
        }

    }
}