import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        Stack<Character> st = new Stack<>();
        int tmp = 0;
        for (int i=0;i<input.length();i++){
            if(input.charAt(i)=='(') {
                st.push('(');
            } else {
                st.pop();
                if(input.charAt(i-1)=='(')
                    tmp+=st.size();
                else
                    tmp+=1;
            }
        }
        System.out.println(tmp);
    }
}
