import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1157_단어공부 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toUpperCase();

        // 알파벳 배열 만들기
        int[] alphabet = new int[26];

        int max = 0;
        int maxIndex = 0;
        int maxCount = 0;

        // 글자수까지 반복문 돌면서 각 문자 차례대로 확인해서 배열에 저장
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            alphabet[ch - 'A']++;
        }


        // 최댓값 찾기 + 최댓값 갯수 세기
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] > max) {
                max = alphabet[i];
                maxIndex = i;
                maxCount = 1; // 새로운 최댓값을 찾을때 카운트 1로 갱신
            } else if (max == alphabet[i]) {
                maxCount++;
            }
        }




        if (maxCount > 1) {
            System.out.println("?");
        } else {
            char ans = (char)('A' + maxIndex);
            System.out.println(ans);
        }


    }

}
