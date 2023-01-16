package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.w3c.dom.ranges.Range;

public class day4 {
  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> pairs;
    int counter;
    int result1 = 0;
    int result2 = 0;
    Instant start = Instant.now();
    try {
      BufferedReader br = new BufferedReader(new FileReader("inputs/day4.txt"));
      String line;
      while ((line = br.readLine()) != null) {
        pairs = new ArrayList<>();
        counter = 0;
        if (line.isBlank()) {
          continue;
        }

        String[] outcome = line.split(",");

        String[] assign1 = outcome[0].split("-");
        String[] assign2 = outcome[1].split("-");
        IntStream intStream = IntStream.range(Integer.parseInt(assign1[0]), Integer.parseInt(assign1[1]));
        intStream.forEach(System.out::println);


//
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void extracted(ArrayList<ArrayList<Integer>> pairs, int counter, List<String[]> outcome) {
    for (String[] o : outcome) {
      pairs.add(new ArrayList<>());
      for (int i = Integer.parseInt(o[0]); i <= Integer.parseInt(o[1]); i++) {
        pairs.get(counter).add(i);
      }
      counter++;
    }
  }

}
