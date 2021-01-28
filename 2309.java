import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int NUM_OF_WORKER = 9;
    static int pivot = 100;
    static int arr[];
    static int i,j;
    public static void main(String[] args) throws Exception{
        arr = new int[NUM_OF_WORKER];
        int height = 0;
        for(int i=0;i<NUM_OF_WORKER;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            height += arr[i];
        }
        pivot = height - pivot;
        Arrays.sort(arr);
        getResult();

        for(int k=0;k<NUM_OF_WORKER;k++){
            if(k==i || k==j) continue;
            System.out.println(arr[k]);
        }

    }

    static void getResult(){
        i=0;
        j=NUM_OF_WORKER-1;
        int sum=0;
        while(i<=j){
            sum = arr[i] + arr[j];
            if(sum<pivot)
                i++;
            else if (sum > pivot)
                j--;
            else
                break;
        }
    }
}
