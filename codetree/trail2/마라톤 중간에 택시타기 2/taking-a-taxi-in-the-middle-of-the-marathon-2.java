import java.util.*;

public class Main {
    static int minDist = Integer.MAX_VALUE;
    static void bf(int cur, int[][] point) {
        int dist = 0;
        int prev = 0;
        for(int i = 1; i < point.length; i++){
            if(i == cur) continue;
            
            dist += Math.abs(point[prev][0] - point[i][0])
            + Math.abs(point[prev][1] - point[i][1]);
            
            prev = i;
        }
        minDist = Math.min(minDist, dist);
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] point = new int[N][2];

        for(int i = 0; i < N; i++){
            point[i][0] = sc.nextInt();
            point[i][1] = sc.nextInt();
        }

        // 완전 탐색
        for(int i = 1; i < N - 1; i++)
            bf(i, point);

        System.out.println(minDist);
    }
}       