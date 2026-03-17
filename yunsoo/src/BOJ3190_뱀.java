import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3190_뱀 {

    // 델타배열: 우하좌상
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int time = 0;
    static int dir = 0; // 0 = 오른쪽 (델타배열 기준)
    static int headR = 0;
    static int headC = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 지도 사이즈 입력받기
        int N = Integer.parseInt(br.readLine());

        // 지도를 2차원 배열로 선언
        int[][] map = new int[N][N];

        // 사과 갯수 입력받기
        int K = Integer.parseInt(br.readLine());

        // 사과 위치 좌표 입력 받기
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r-1][c-1] = 1;
        }

        // 변환횟수 입력 받기
        int L = Integer.parseInt(br.readLine());

        HashMap<Integer, String> dirChange = new HashMap<Integer, String>();

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            String d = st.nextToken();

            dirChange.put(num, d);
        }

        // (0,0)에서 뱀 기어다니기 시작, 먼저 오른쪽으로 직진 (0,1)



        // 뱀의 정보 저장
        Queue<int[]> snake = new LinkedList<>();
        snake.add(new int[]{0,0});
        map[0][0] = 2; // 뱀 표시

        while(true) {
            time++;

            // 다음 위치 계산
            int nr = headR + dr[dir];
            int nc = headC + dc[dir];

            // 충돌 체크 (맵 밖 or 몸 충돌)
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) break;
            if (map[nr][nc] == 2) break;

            boolean isApple = (map[nr][nc] == 1);

            // 이동처리
            snake.add(new int[]{nr, nc}); // 머리하나 늘어나고 꼬리는 그대로
            map[nr][nc] = 2;
            headR = nr;
            headC = nc;


            if (!isApple) {
                // 빈칸인 경우 (사과X)
                int[] oldTail = snake.poll();
                map[ oldTail[0] ][ oldTail[1] ] = 0;
            }





            // 방향 전환 체크
            if (dirChange.containsKey(time)) {
                String direction = dirChange.get(time);
                if (direction.equals("D")) {
                    dir = (dir + 1) % 4;
                } else if (direction.equals("L")) {
                    dir = (dir + 3) % 4;
                }
            }


        }

        System.out.println(time);

    }
}
