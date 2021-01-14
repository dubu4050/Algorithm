import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        int T = Integer.parseInt(br.readLine());
        String[] input;
        int N, M;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<T;i++){
            input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);
            for(int j=0;j<M;j++)
                br.readLine();
            stringBuilder.append(N-1).append("\n");
        }
        System.out.println(stringBuilder.toString().trim());
    }
}
