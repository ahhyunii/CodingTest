import java.util.*;

class Solution {
    static int n;
    static int[][] map;
    static int[][] memo;
    
    public int solution(int[][] triangle) {
        int maxSum = Integer.MIN_VALUE;
        
        map = triangle;
        n = triangle.length;
        
        // 현재 경로까지 메모제이션
        memo = new int[n][];
        for(int i = 0; i < n; i++){
            memo[i] = new int[i + 1];
            Arrays.fill(memo[i], -1); // 미방문 표시를 위한 -1 초기화
        }
        
        return dfs(0, 0);
    }
    
    int dfs(int r, int c){
        // 방문 가능 여부
        if(r < 0 || r >= n || c < 0 || c > r) return 0;
        if(r == n - 1) return map[r][c];
        
        // 방문했었다면 현재칸 메모제이션 그대로 리턴
        if(memo[r][c] != -1) return memo[r][c];
        
        // 왼쪽 대각선 / 오른쪽 대각선 중 큰 값 선택
        int maxChild = Math.max(dfs(r + 1, c), dfs(r + 1, c + 1));
        
        memo[r][c] = map[r][c] + maxChild;
        
        return memo[r][c];
    }
}