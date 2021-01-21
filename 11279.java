import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder = new StringBuilder();
    static MaxHeap minHeap = new MaxHeap();

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            int input = Integer.parseInt(br.readLine());
            control(input);
        }
        System.out.println(stringBuilder.toString().trim());
    }

    static void control(int input){
        if(input==0)
            stringBuilder.append(minHeap.delete()).append("\n");
        else
            minHeap.insert(input);
    }
}

class MaxHeap{
    private static final int MAX_CAPACITY = 100002;
    private int[] heap;
    private int size;

    public MaxHeap() {
        this.heap = new int[MAX_CAPACITY];
        this.size = 0;
    }

    private int parent(int pos) {
        return pos / 2;
    }
    private int leftChild(int pos) {
        return (2 * pos);
    }
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    public void swap(int a, int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    private void heapifyUp(int idx){
        while (heap[idx] > heap[parent(idx)] && parent(idx)!=0) {
            swap(idx, parent(idx));
            idx = parent(idx);
        }
    }

    private void heapifyDown(int idx){
        int idxTarget = idx;
        int idxLeft = leftChild(idxTarget);
        int idxRight = rightChild(idxTarget);

        if (idxLeft <= size && heap[idxLeft] > heap[idxTarget])
            idxTarget = idxLeft;
        if (idxRight <= size && heap[idxRight] > heap[idxTarget])
            idxTarget = idxRight;

        if (idx != idxTarget) {
            swap(idx, idxTarget);
            heapifyDown(idxTarget);
        }
    }

    private boolean isEmpty(){
        if(size==0)
            return true;
        return false;
    }

    public void insert(int input) {
        heap[++size] = input;
        heapifyUp(size);
    }

    public int delete(){
        if(isEmpty())
            return 0;

        int max = heap[1];
        swap(1, size);
        this.size--;
        heapifyDown(1);

        return max;
    }
}
