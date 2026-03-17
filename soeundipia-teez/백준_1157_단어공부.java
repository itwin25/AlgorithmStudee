import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1157_단어공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26]; // 알파벳 저장하는 배열 생성
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            // 해당하는 문자의 아스키코드 값에서 65, 97 빼고 해당하는 배열의 칸 증가
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                arr[s.charAt(i) - 'A']++;
            } else {
                arr[s.charAt(i) - 'a']++;
            }
        }

        int max = -1; // 가장 많이 등장한 알파벳의 횟수
        char ch = '?'; // 가장 많이 등장한 알파벳

        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                ch = (char)(i + 65);
            } else if (arr[i] == max) {
                ch = '?';
            }
        }

        System.out.println(ch);
    }
}
