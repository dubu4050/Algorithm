import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String N;
    static int M, cnt=0;
    static char[] stopButton;

    public static void main(String[] args) throws Exception{
        mainInit();
        if(M != 10) { // 숫자버튼이 남아있는 경우
            count(N);
            int comparative = Math.abs(Integer.parseInt(N) - 100);
            System.out.println(cnt >= comparative ? comparative : cnt);
        }
        else // 숫자버튼 전부 고장
            System.out.println(Math.abs(Integer.parseInt(N)-100));
    }

    private static void mainInit() throws Exception{
        N = br.readLine();
        M = Integer.parseInt(br.readLine());
        stopButton = new char[M];
        if(M!=0) {
            String[] inputs = br.readLine().split(" ");
            for (int i = 0; i < M; i++)
                stopButton[i] = inputs[i].charAt(0);
        }
    }

    private static void count(String target) {
        if(!checkButton(target)){
            boolean flag = false;
            while(!flag){
                cnt++;
                int tmp = Integer.parseInt(target);

                if(checkButton(Integer.toString(tmp+cnt))){
                    target = Integer.toString(tmp+cnt);
                    flag = true;
                }
                if(tmp-cnt > 0) {
                    if (checkButton(Integer.toString(tmp - cnt))) {
                        target = Integer.toString(tmp - cnt);
                        flag = true;
                    }
                }else{
                    if(checkButton("0")){
                        target = "0";
                        flag = true;
                    }
                }
            }
        }
        cnt+=target.length();
        return;
    }

    private static boolean checkButton(String target) {
        for(int i=0;i<target.length();i++)
            for(int j=0;j<stopButton.length;j++)
                if(target.charAt(i)==stopButton[j]) return false;
        return true;
    }
}
