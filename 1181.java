import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        TreeSet<String> list = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length()<o2.length()?-1:1;
            }
        });

        for(int i=0;i<N;i++)
            list.add(br.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        list.stream().forEach(a-> stringBuilder.append(a).append("\n"));
        System.out.println(stringBuilder.toString().trim());
    }
}