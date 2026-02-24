import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1038_감소하는수 {

    static int[] arr = new int[1024]; // 숫자 저장할 배열

    static int index = 0; // 몇 번째 감소하는 수 인지 체크 할 인덱스

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 제일 큰 감소하는 수 : 9876543210
        // 총 2^10 - 1  = 1023개
        // 이 이상의 수는 감소하는 수가 존재하지 않으므로 무조건 -1

        if (N > 1022) { // 0은 0번째라서 1022번째가 9876543210임
            System.out.println(-1);
            return;
        }

    }
}