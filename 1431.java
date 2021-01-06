import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

class CustomComparator implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        if(o1.length()==o2.length()){
            int o1Len=0, o2Len=0;
            int tmp = 0;
            for(int i=0;i<o1.length();i++) {
                tmp = o1.charAt(i);
                if (tmp < 65)
                    o1Len += (tmp - 48);
            }
            for(int i=0;i<o2.length();i++) {
                tmp = o2.charAt(i);
                if (tmp < 65)
                    o2Len += (tmp-48);
            }
            if (o1Len==o2Len)
                return o1.compareTo(o2);
            return o1Len<o2Len?-1:1;
        }
        return o1.length()<o2.length()?-1:1;
    }
}

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        String[] serials = new String[N];
        for(int i=0;i<N;i++)
            serials[i]=br.readLine();

        Arrays.sort(serials, new CustomComparator());
        for(String s:serials){
            stringBuilder.append(s+'\n');
        }
        System.out.println(stringBuilder.toString().trim());
    }
}
