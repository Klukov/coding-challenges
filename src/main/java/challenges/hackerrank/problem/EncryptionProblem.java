package challenges.hackerrank.problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class EncryptionProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter =
                new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    static class Result {

        /*
         * Complete the 'encryption' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts STRING s as parameter.
         */

        public static String encryption(String s) {
            char[] input = s.trim().replace("\s", "").toCharArray();
            int size = input.length;
            int rows = calculateRows(size);
            int columns = calculateColumns(size, rows);
            StringBuilder result = new StringBuilder();
            for (int column = 0; column < columns; column++) {
                for (int row = 0; row < rows; row++) {
                    int charIndex = row * columns + column;
                    if (charIndex >= size) continue;
                    result.append(input[charIndex]);
                }
                if (column == columns - 1) continue;
                result.append(' ');
            }
            return result.toString();
        }

        private static int calculateColumns(int size, int rows) {
            return size / rows + (size % rows == 0 ? 0 : 1);
        }

        private static int calculateRows(int size) {
            double root = Math.sqrt(size);
            int floor = (int) Math.floor(root);
            int ceil = (int) Math.ceil(root);
            if (floor == ceil) {
                return (int) root;
            }
            double division = ((double) size) / floor;
            return division > ceil ? ceil : floor;
        }
    }
}
