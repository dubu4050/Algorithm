import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        Stack<Character> st = new Stack<>();
        Stack<Character> forCheck = new Stack<>();
        int[] arr = new int[100];
        int result = 0;
        int cnt = 0;
        boolean flag = false;
        for(int i=0;i<input.length();i++){
            char at = input.charAt(i);
            if(at=='('||at=='['){
                st.push(at);
                forCheck.push(at);
                cnt++;
            }else{
                if(at==')'){
                    if(forCheck.size()!=0&&forCheck.peek()=='(')
                        forCheck.pop();
                    else {
                        flag = true;
                        break;
                    }

                    if(st.peek()==')'||st.peek()==']'){
                        arr[cnt]+=(arr[cnt+1]*2);
                        arr[cnt+1]=0;
                    }else if (st.peek()=='(') arr[cnt]+=2;
                }
                else{
                    if(forCheck.size()!=0&&forCheck.peek()=='[')
                        forCheck.pop();
                    else {
                        flag = true;
                        break;
                    }
                    if(st.peek()==')'||st.peek()==']'){
                        arr[cnt]+=(arr[cnt+1]*3);
                        arr[cnt+1]=0;
                    }else if (st.peek()=='[') arr[cnt]+=3;
                }
                cnt--;
                st.push(at);
            }
            if(cnt==0) {
                result += arr[1];
                for(int j=1;j<31;j++)
                    arr[j]=0;
            }
        }
        if(flag||forCheck.size()!=0)
            System.out.println(0);
        else
            System.out.println(result);
    }
}
