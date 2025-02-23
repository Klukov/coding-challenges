package challenges.hackerrank.problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ElectronicsShop {

    /*
     * Complete the getMoneySpent function below.
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int minKeyboardPrice = Arrays.stream(keyboards).min().getAsInt();
        int minDrivePrice = Arrays.stream(drives).min().getAsInt();

        int maxPossibleKeyboardPrice = b - minDrivePrice;
        int maxPossibleDrivePrice = b - minKeyboardPrice;

        var keyboardsSorted =
                Arrays.stream(keyboards)
                        .filter(keyboard -> keyboard <= maxPossibleKeyboardPrice)
                        .boxed()
                        .collect(Collectors.toCollection(TreeSet::new));

        var drivesSorted =
                Arrays.stream(drives)
                        .filter(drive -> drive <= maxPossibleDrivePrice)
                        .boxed()
                        .collect(Collectors.toCollection(TreeSet::new));

        var max = new AtomicInteger(-1);
        var iterator = keyboardsSorted.iterator();
        for (int i = 0; i < keyboardsSorted.size(); i++) {
            var keyboard = iterator.next();
            var spare = b - keyboard;
            var mostExpensiveDrive = drivesSorted.floor(spare);
            if (mostExpensiveDrive == null) continue;
            var newPossibleMax = mostExpensiveDrive + keyboard;
            var currentMax = max.updateAndGet(current -> Math.max(newPossibleMax, current));
            if (currentMax == b) {
                break;
            }
        }
        return max.get();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter =
                new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] bnm = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int b = Integer.parseInt(bnm[0]);

        int n = Integer.parseInt(bnm[1]);

        int m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];

        String[] keyboardsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
            keyboards[keyboardsItr] = keyboardsItem;
        }

        int[] drives = new int[m];

        String[] drivesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
            drives[drivesItr] = drivesItem;
        }

        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */

        int moneySpent = getMoneySpent(keyboards, drives, b);

        bufferedWriter.write(String.valueOf(moneySpent));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
