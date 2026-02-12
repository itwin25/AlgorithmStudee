import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1390_뱀 {

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
            int r = br.read();
            int c = br.read();
            map[r-1][c-1] = 1;
        }


    }
}