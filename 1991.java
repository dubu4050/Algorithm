import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<Character, Node> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Tree t = new Tree();
        int N = Integer.parseInt(br.readLine());
        String[] input;
        for(int i = 0 ; i < N ; i++){
            input = br.readLine().split(" ");

            Node center = getNode(input[0].charAt(0));
            center.left = getNode(input[1].charAt(0));
            center.right = getNode(input[2].charAt(0));
        }
        t.root = map.get('A');
        t.preOrder(t.root);
        System.out.println();
        t.inOrder(t.root);
        System.out.println();
        t.postOrder(t.root);
    }

    static private Node getNode(char key){
        if(key=='.') return null;
        if(map.get(key)==null) {
            Node tmp = new Node(key);
            map.put(key, tmp);
            return tmp;
        }
        return map.get(key);
    }

}

class Node {
    char data;
    Node left;
    Node right;

    public Node(char data) {
        this.data = data;
    }

}

class Tree {
    public Node root;

    public void inOrder(Node node) {
        if(node != null) {
            inOrder(node.left);
            System.out.print(node.data);
            inOrder(node.right);
        }
    }

    public void preOrder(Node node) {
        if(node != null) {
            System.out.print(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if(node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data);
        }
    }
}