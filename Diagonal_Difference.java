import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int result;
        int leftToRightDiagonalSum = 0;
        int rightToLeftDiagonalSum = 0;
        int size = arr.size();
        //left to right diagonal sum
        for(int i = 0; i < size; i++){
              leftToRightDiagonalSum += arr.get(i).get(i);  
        }
        
         //right to left diagonal sum
        for(int i = 0; i < size; i++){
              rightToLeftDiagonalSum += arr.get(i).get(size - 1 - i);
        }
        
        result = leftToRightDiagonalSum - rightToLeftDiagonalSum;
        return Math.abs(result) ;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
