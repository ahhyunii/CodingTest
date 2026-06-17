class Solution {
    static int minCount;
    static int targetN, baseN;
    
    public int solution(int N, int number) {
        minCount = Integer.MAX_VALUE;
        targetN = number;
        baseN = N;
        
        dfs(0, 0);
        
        return minCount > 8 ? -1 : minCount;
    }
    
    void dfs(int cur, int count){
        // 가지치기
        if(count > 8 || count >= minCount) return;
        
        if(cur == targetN) {
            minCount = Math.min(minCount, count);
            return;
        }
        
        int nn = 0;
        for(int i = 1; i < 8; i++){
            
            nn = (10 * nn) + baseN;
            
            dfs(cur + nn, count+i);
            dfs(cur - nn, count+i);
            dfs(cur / nn, count+i);
            dfs(cur * nn, count+i);
        }
        
    }
}