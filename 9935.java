import java.io.*;
import java.util.Stack;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] forCheck = new char[1000001];

    public static void main(String[] args) throws IOException {
        String sentence = br.readLine();
        String bomb = br.readLine();
        int bombLength = bomb.length();
        boolean flag = false;
        StringBuilder result = new StringBuilder();

        char tmp = ' ';
        int i, forArr;
        for(i=0, forArr = 0;i<sentence.length();i++, forArr++){
            tmp = sentence.charAt(i);
            if(bomb.indexOf(tmp)==(bombLength-1) && forArr>=(bombLength-1)) {
                flag=false;
                for(int j=0;j<bombLength-1;j++){
                    if(forCheck[forArr-bombLength+1+j] != bomb.charAt(j)) {
                        flag = true;
                        break;
                    }
                }
                if(!flag)
                    forArr -= bombLength;
                else
                    forCheck[forArr]=tmp;
            } else
                forCheck[forArr]=tmp;
        }
        if(forArr==0)
            System.out.println("FRULA");
        else {
            for (int j = 0; j < forArr; j++)
                result.append(forCheck[j]);
            System.out.println(result.toString());
        }
    }
}
