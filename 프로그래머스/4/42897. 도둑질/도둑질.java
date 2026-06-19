import java.util.*;

class Solution {

    public int solution(int[] money) {

        int N = money.length;
        
        // 첫번째 집 포함 탐색
        int[] dp = new int[N];
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);
        
        for(int i = 2; i < N - 1; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }
        
        int answer1 = dp[N-2];
        
        // 첫번째 집 제외 탐색
        dp = new int[N];
        dp[1] = money[1];
        dp[2] = Math.max(money[1], money[2]);
        
        for(int i = 3; i < N; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }
        
        int answer2 = dp[N-1];
        
        return Math.max(answer1, answer2);
    }
}
