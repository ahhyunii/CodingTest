import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            q.addLast(i + 1);
        }

        while(q.size() > 1){
             q.removeFirst();
             q.addLast(q.removeFirst());
        }

        System.out.println(q.getFirst());
    }
}
