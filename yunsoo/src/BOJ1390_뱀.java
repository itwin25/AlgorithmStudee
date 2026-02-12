import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1390_뱀 {

    // 델타배열: 우하좌상
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 지도 사이즈 입력받기
        int N = Integer.parseInt(br.readLine());

        // 지도를 2차원 배열로 선언
        int[][] map = new int[N][N];

        // 맵의 모든 좌표를 0으로 표시
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = 0;
            }
        }

        // 사과 갯수 입력받기
        int K = Integer.parseInt(br.readLine());

        // 사과 위치 좌표 입력 받기
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r-1][c-1] = 1;
        }

        // 맵 입력값 확인
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
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

        int time = 0;
        String direction = "";

        while (true) {

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    map[r][c] = 2; // 뱀의 시작점 (0,0)

                    if (dirChange.containsKey(time)) {
                        direction = dirChange.get(time);
                    }

                    if (direction == "D") {

                    } else {

                    }



//                    for (int i = 0; i < 4; i++) {
//                        int nr = r + dr[i];
//                        int nc = c + dc[i];
//
//                        if (map[nr][nc] == 1) {
//                            map[nr][nc] = 2;
//                        } else {
//                            map[]
//
//                        }
//
//                    }



                }
            }



        }





    }
}
