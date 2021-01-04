import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static double getCount(long distance){
        if(distance==1)
            return 1;
        double sqrt = Math.sqrt(distance);
        double pivot = Math.round(sqrt);
        if(distance <= Math.pow(pivot, 2)){
            return pivot*2-1;
        }
        else{
            return pivot*2;
        }
    }
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<T;i++){
            String[] input = br.readLine().split(" ");
            int result = (int)getCount(Integer.parseInt(input[1])-Integer.parseInt(input[0]));
            stringBuilder.append(result).append('\n');
        }
        System.out.println(stringBuilder.toString().trim());
    }
}
