import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int x = Integer.highestOneBit(N);

        // N == 2의 거듭제곱
        if(N == x) System.out.println(N);
        // 대입식: 2 x ( N - N보다 작은 & 가장 큰 2의 제곱)
        else System.out.println(2 * (N - x));
    }
}
