import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] board;
    static int time;
    static int dir;
    static Queue<int[]> snake;
    static Queue<char[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // NxN
        board =  new int[N][N]; // 보드
        int K = Integer.parseInt(br.readLine()); // 사과 개수

        for(int i = 0; i < K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x][y] = 1; // 사과 위치
        }

        // 방향 변환 정보
        int L = Integer.parseInt(br.readLine()); // 방향 변환 횟수
        q = new LinkedList<>();

        for(int i = 0; i < L; i++){
            char a = br.readLine().charAt(0);
            char b =  br.readLine().charAt(2);

            q.offer(new char[]{a,b});
        }

        snake = new LinkedList<>(); // 뱀 이동 정보

        dir = 0; // 0: 동, 1: 남, 2: 서, 3: 북

        snake.offer(new int[]{0, 0}); // 처음 시작

        move(snake, 0);

    }

    static int move(Queue<int[]> snake, int time) {
        // 방향 전환 해야하면
        if (!q.isEmpty() && time == Character.getNumericValue(q.peek()[0])) {
            if (snake.peek()[1] == 'D') {
                snake.poll();
                dir = (dir + 1) % 4;
            } else {
                snake.poll();
                dir = (dir - 1 + 4) % 4;
            }
        }

        int[] now = snake.peek(); // 현재 위치

        // 다음 위치
        int row = now[0];
        int col = now[1];

        // 이동
        if (dir == 0) {
            col++;
        } else if (dir == 1) {
            row++;
        } else if (dir == 2) {
            col--;
        } else if (dir == 3) {
            row--;
        }

        time++;

        // 벽에 닿으면
        if (row < 0 || row >= N || col < 0 || col >= N) {
            return time;
        }

        // 꼬리에 닿으면
        if (board[row][col] == -1) {
            return time;
        }
    }
}