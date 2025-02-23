package challenges.hackerrank.problem;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class DesignerPdfViewer {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter =
                new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> h =
                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

        String word = bufferedReader.readLine();

        int result = Result.designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    static class Result {

        /*
         * Complete the 'designerPdfViewer' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER_ARRAY h
         *  2. STRING word
         */
        private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        private static final Map<Character, Integer> alphabetPositionMap =
                makeAlphabetPositionMap();

        private static Map<Character, Integer> makeAlphabetPositionMap() {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < alphabet.length; i++) {
                map.put(alphabet[i], i);
            }
            return map;
        }

        public static int designerPdfViewer(List<Integer> h, String word) {
            int alphabetMaxHeight = h.stream().max(Integer::compare).get();
            char[] wordInArray = word.toCharArray();
            Object[] heights = h.toArray();
            int resultHeight = -1;
            for (int i = 0; i < wordInArray.length; i++) {
                int position = alphabetPositionMap.get(wordInArray[i]);
                int newHeight = (int) heights[position];
                resultHeight = Math.max(newHeight, resultHeight);
                if (newHeight == alphabetMaxHeight) {
                    break;
                }
            }
            return resultHeight * word.length();
        }
    }
}
