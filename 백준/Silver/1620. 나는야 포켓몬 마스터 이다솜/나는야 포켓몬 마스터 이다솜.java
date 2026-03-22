import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> nameBook = new HashMap<>();
        String[] numBook = new String[N];

        // book에 포켓몬 이름 + 번호 저장
        for(int i = 0; i < N; i++){
            String pocketmon = br.readLine();
            nameBook.put(pocketmon, i+1);
            numBook[i] = pocketmon;
        }

        // 문제 맞추기
        for(int i = 0; i < M; i++){
            // 숫자인지 문자인지 확인
            String line = br.readLine();
            if(Character.isDigit(line.charAt(0))) { // 숫자라면 numBook에서 찾기
                System.out.println(numBook[Integer.parseInt(line)-1]);
            }else{ // 문자라면 nameBook에서 찾기
                System.out.println(nameBook.get(line));
            }
        }
        br.close();
    }
}
