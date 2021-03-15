import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder = new StringBuilder();
    static String input;
    static Stack<Character> stack;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException{
        input = br.readLine();
        stack = new Stack<>();
    }

    private static void solve() {
        for(int i = 0 ; i < input.length(); i++){
            char tmp = input.charAt(i);
            if(tmp < 91 && tmp > 64)
                stringBuilder.append(tmp);
            else { // operator
                if(tmp == ')') { // until close
                    while(!stack.isEmpty()){
                        if(stack.peek()=='(') {
                            stack.pop();
                            break;
                        }
                        stringBuilder.append(stack.pop());
                    }
                }
                else{ // operator
                    while(!stack.isEmpty()){
                        if(isp(stack.peek()) > icp(tmp))
                            break;
                        stringBuilder.append(stack.pop());
                    }
                    stack.push(tmp);
                }
            }
        }
        while(!stack.isEmpty())
            stringBuilder.append(stack.pop());
        System.out.println(stringBuilder.toString().trim());
    }

    private static int isp(char operator){
        switch(operator){
            case '(':
                return 8;
            case '+':
            case '-':
                return 3;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    private static int icp(char operator){
        switch(operator){
            case '(':
                return 0;
            case '+':
            case '-':
                return 3;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }
}