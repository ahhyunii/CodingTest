package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 14503
 * 로봇청소
 * Gold 5
 * 알고리즘: 구현, 시뮬레이션
 */
class G14503 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 방 크기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cleanN = 0;

        // 로봇 청소기 최초 칸
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        // 방 배열 초기화
        int[][] room = new int[N][M];
        boolean[][] isCleaned = new boolean[N][M];
        // 북 동 남 서
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        // 입력 저장(0: 청소 안된 빈칸, 1: 벽-갈수 없음)
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            // 1. 현재 칸 청소
            if (!isCleaned[r][c] && room[r][c] != 1) {
                isCleaned[r][c] = true;
                cleanN++;
            }
            boolean moved = false; // 이동 여부 체크
            // 4방향을 전부 회전하며 전진 여부 체크
            for (int a = 0; a < 4; a++) {
                d = (d + 3) % 4; // d 왼쪽 회전
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 3. 주변 청소 가능
                // 현재 바라보는 앞 칸이 청소가 가능하다면 전진하고 회전 멈춤
                if (!isCleaned[nx][ny] && room[nx][ny] != 1) {
                    r = nx;
                    c = ny;
                    moved = true;
                    break;
                }
            }

            // 회전하면서 빈칸이 있어 그 칸을 청소하고 다음 반복으로 넘어감
            if(moved == true) continue;

            // 2. 주변 청소 불가
            int back = (d + 2) % 4;
            int nx = r + dx[back];
            int ny = c + dy[back];

            // 2-a: 후진이 가능하다면 후진 후 다음 반복으로
            if ((nx >= 0 && nx < N) && (ny >= 0 && ny < M) && room[nx][ny] != 1) {
                r = nx;
                c = ny;
                moved = true;
                continue;
            }else{ // 2-b: 후진 불가하다면 작동 멈춤
                break;
            }
        }

        System.out.println(cleanN);
    }
}