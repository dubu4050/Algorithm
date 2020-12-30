import java.io.*;
import java.util.*;

class QueueItem{
    int priority;
    int order;

    public QueueItem(int priority, int order) {
        this.priority = priority;
        this.order = order;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int getIdx(int n, int targetIdx, String priority){
        Queue<QueueItem> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        String[] token = priority.split(" ");
        for(int i=0;i<n;i++){
            int item = Integer.parseInt(token[i]);
            list.add(item);
            queue.add(new QueueItem(item, i));
        }
        Collections.sort(list, Comparator.reverseOrder());
        int cnt=1;
        int listIdx = 0;
        while(!queue.isEmpty()){
            if (queue.peek().priority == list.get(listIdx)) {
                QueueItem tmp = queue.poll();
                if(tmp.order==targetIdx)
                    break;
                listIdx++;
                cnt++;
            }
            else
                queue.add(queue.poll());
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String[] tmp = br.readLine().split(" ");
            int n = Integer.parseInt(tmp[0]), targetIdx = Integer.parseInt(tmp[1]);
            System.out.println(getIdx(n, targetIdx, br.readLine()));
        }
    }
}
