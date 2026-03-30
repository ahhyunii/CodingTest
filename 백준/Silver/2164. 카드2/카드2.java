import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            q.offer(i + 1); // deque 뒤에 추가
        }

        while(q.size() > 1){
             q.poll(); // 앞에서 삭제
             q.offer(q.poll());
        }

        System.out.println(q.poll());
    }
}
