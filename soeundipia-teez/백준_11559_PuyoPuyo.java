import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_11559_PuyoPuyo {

    static char[][] board = new char[12][6];

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    // 좌표정보
    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            String line = br.readLine();
            for (int j = 0; j < 6; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int chain = 0; // 연쇄 횟수

        while (true) {
            boolean isPopped = false; // 이전턴에 터졌는지 여부
            boolean[][] visited = new boolean[12][6];

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (board[i][j] != '.' && !visited[i][j]) {
                        // 4개 이상 연결되었다면 터짐
                        if () {
                            isPopped = true;
                        }
                    }
                }
            }

            // 한 번도 터지지 않으면 더 이상 연쇄가 불가능 -> 종료
            if (!isPopped) {
                break;
            }

            chain++; // 한 번 이상 터졌다면 연쇄 횟수 증가
            // 중력 적용
        }

        System.out.println(chain); // 출력
    }
}
