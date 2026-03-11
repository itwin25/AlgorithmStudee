import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_12100_2048Easy {

    static int N;
    static int max = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, board[i][j]);
            }
        }

        dfs(0, board);
        System.out.println(max);
    }

    static void dfs(int depth, int[][] board) {
        if (depth == 5) {
            return; // 5번 이동하면 종료
        }

        for (int i = 0; i < 4; i++) {
            int[][] nextBoard = swipe(i, board);

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    max = Math.max(max, nextBoard[r][c]);
                }
            }

            dfs(depth + 1, nextBoard);
        }
    }

    static int[][] swipe(int dir, int[][] board) {
        int[][] otherBoard = new int[N][N];

    }
}
