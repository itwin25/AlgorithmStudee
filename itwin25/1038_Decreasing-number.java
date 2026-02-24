import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int idx;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // N번째
        nums = new int[1000000]; // 감소하는 수 저장 배열

        Arrays.fill(nums, -1); // -1로 초기화
        idx = 0; // 저장할 idx 변수
        boolean isOk = true;

        // 0 ~ 10까지 미리 저장
        for (int i = 0; i <= 10; i++) {
            nums[i] = i;
            idx++;
        }

        // 20부터 999,999까지 감소하는 수 찾아서 저장
        for (int i = 20; i <= 987654; i++) {
            String str = String.valueOf(i);
            isOk = true;

            for (int j = 0; j < str.length() - 1; j++) {
                if (str.charAt(j) <= str.charAt(j + 1)) {
                    isOk = false;
                    break;
                }
            }

            // 감소하는 수이면 저장
            if (isOk) {
                nums[idx] = i;

                if (idx == N) {
                    System.out.println(nums[N]);
                    return;
                }

                idx++;

            }
        }

        System.out.println(nums[N]);
    }
}
