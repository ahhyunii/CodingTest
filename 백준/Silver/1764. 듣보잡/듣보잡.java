import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String,Boolean> noHeardAndSaw = new HashMap<>();

        // 듣도 못한 사람
        // 초기값 false로 넣기 -> 듣기만 한 사람
        for(int i = 0; i < N; i++){
            noHeardAndSaw.put(br.readLine(), Boolean.FALSE);
        }

        // 보도 못한 사람
        // 듣고 봤으면 true로 넣기, 아니면 false
        for(int i = 0; i < M; i++){
            String s = br.readLine();
            if(noHeardAndSaw.containsKey(s)){
                noHeardAndSaw.put(s, Boolean.TRUE);
            }else{
                noHeardAndSaw.put(s, Boolean.FALSE);
            }
        }

        // true인 사람들만 list에 추가
        List<String> trueList = new ArrayList<>();
        for(Map.Entry<String, Boolean> entry: noHeardAndSaw.entrySet()){
            if(entry.getValue()){
                trueList.add(entry.getKey());
            }
        }

        Collections.sort(trueList); // 사전순 정렬
        System.out.println(trueList.size());
        for(String s: trueList){
            System.out.println(s);
        }

    }
}
