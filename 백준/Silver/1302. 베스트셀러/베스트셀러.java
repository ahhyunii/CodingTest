import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> selling = new HashMap<>();
        int maxSellCount = -1; // 가장 많이 팔린 책 개수

        // 판매된 책 기록 & 최댓값 기록
        for(int i = 0; i < N; i++){
            String book = br.readLine();
            int count = selling.getOrDefault(book, 0) + 1;

            selling.put(book, count); // 기록
            maxSellCount = Integer.max(maxSellCount, count); // 최댓값 갱신
        }

        // max 개수의 책 찾기
        List<String> maxSaleBook = new ArrayList<>();
        for(Map.Entry<String, Integer> sell: selling.entrySet()){
            if(sell.getValue() == maxSellCount)
                maxSaleBook.add(sell.getKey());
        }

        // 사전순 첫번째값 출력
        Collections.sort(maxSaleBook);
        System.out.println(maxSaleBook.get(0));
    }
}
