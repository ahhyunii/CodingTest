import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> noHeard = new HashSet<>();
        List<String> noHeardAndSaw = new ArrayList<>();

        // 듣도 못한 사람 -> set에 넣기
        for(int i = 0; i < N; i++){
            noHeard.add(br.readLine());
        }

        // 보도 못한 사람
        // set에 있다면 -> list에 넣기
        for(int i = 0; i < M; i++){
            String s = br.readLine();
            if(noHeard.contains(s)){
                noHeardAndSaw.add(s);
            }
        }

        Collections.sort(noHeardAndSaw); // 사전순 정렬
        bw.write(noHeardAndSaw.size() + "\n");

        for(String s: noHeardAndSaw){
            bw.write(s + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
