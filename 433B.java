import java.util.*;
import java.io.*;

public class KuriyamaMiraiStones {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        var n = Integer.parseInt(br.readLine()); // Number of stones
        var v = new long[n]; // Stone costs
        var stoneCosts = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            v[i] = Long.parseLong(stoneCosts[i]);
        }

        // Prefix sums for the original array
        var prefixSumOriginal = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSumOriginal[i] = prefixSumOriginal[i - 1] + v[i - 1];
        }

        // Sort the array and compute prefix sums for the sorted array
        var sortedV = v.clone();
        Arrays.sort(sortedV);
        var prefixSumSorted = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSumSorted[i] = prefixSumSorted[i - 1] + sortedV[i - 1];
        }

        int m = Integer.parseInt(br.readLine()); // Number of queries
        for (int i = 0; i < m; i++) {
            String[] query = br.readLine().split(" ");
            int type = Integer.parseInt(query[0]);
            int l = Integer.parseInt(query[1]);
            int r = Integer.parseInt(query[2]);

            // Type 1: Range sum in the original array
            if (type == 1) {
                out.println(prefixSumOriginal[r] - prefixSumOriginal[l - 1]);
            }
            // Type 2: Range sum in the sorted array
            else if (type == 2) {
                out.println(prefixSumSorted[r] - prefixSumSorted[l - 1]);
            }
        }
        out.flush();
    }
}
