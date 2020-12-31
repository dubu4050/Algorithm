import java.io.*;
import java.util.Stack;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack<>();
        String input = br.readLine();
        while (!(input.length() == 1 && input.charAt(0) == '.')) {
            for (int i = 0; i < input.length(); i++) {
                char tmp = input.charAt(i);
                if (tmp == '(' || tmp == '[') {
                    stack.push(tmp);
                } else if (tmp == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                    else {
                        stack.push(tmp);
                        break;
                    }
                } else if (tmp == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
                    else {
                        stack.push(tmp);
                        break;
                    }
                }
            }
            if (stack.isEmpty())
                System.out.println("yes");
            else
                System.out.println("no");
            input = br.readLine();
            stack.clear();
        }
    }
}
