import java.util.*;

public class Main {
    static int n, cnt;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] grid;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        List<Integer> answer = new ArrayList();

        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    cnt++;
                    answer.add(dfs(i, j));
                }
            }
        }

        System.out.println(cnt);
        answer.sort(Comparator.naturalOrder());
        for(int a: answer){
            System.out.println(a);
        }

    }
    static int dfs(int x, int y){    
        visited[x][y] = true;
        
        int count = 1;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n){
                if(!visited[nx][ny] && grid[nx][ny] == 1){
                    count+=dfs(nx, ny);
                }
            }
        }

        return count;
    }   
}