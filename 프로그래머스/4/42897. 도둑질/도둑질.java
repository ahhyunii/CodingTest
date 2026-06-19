import java.util.*;

class Solution {

    public int solution(int[] money) {

        int N = money.length;
        int[] dp = new int[N];
        
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);
        
        for(int i = 2; i < N - 1; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }
        
        int answer1 = 0;
        for(int i = 0; i < N; i++){
            answer1 = Math.max(answer1, dp[i]);
        }
        
        dp = new int[N];
        
        dp[1] = money[1];
        dp[2] = Math.max(money[1], money[2]);
        
        for(int i = 2; i < N; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }
        
        int answer2 = 0;
        for(int i = 0; i < N; i++){
            answer2 = Math.max(answer2, dp[i]);
        }
        
        return Math.max(answer1, answer2);
    }
}