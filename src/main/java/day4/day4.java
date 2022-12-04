package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day4 {
  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> pairs;
    int counter;
    int result1 = 0;
    int result2 = 0;

    try {
      BufferedReader br = new BufferedReader(new FileReader("inputs/day4.txt"));
      String line;
      while ((line = br.readLine()) != null) {
        pairs = new ArrayList<>();
        counter = 0;
        if (line.isBlank()) {
          continue;
        }

        List<String[]> outcome = Arrays.stream(line.split(","))
            .map(s -> s.split("-"))
            .toList();

        extracted(pairs, counter, outcome);
        List<Integer> g1 = pairs.get(0);
        List<Integer> g2 = pairs.get(1);

        if (g1.size() > g2.size()) {
          if (!g2.stream().filter(g1::contains).toList().isEmpty()) {
            result2 += 1;
          }
          if (g2.stream().filter(s -> !g1.contains(s)).toList().isEmpty()) {
            result1 += 1;
          }
        } else   {
          if (!g1.stream().filter(g2::contains).toList().isEmpty()) {
            result2 += 1;
          }
          if (g1.stream().filter(s -> !g2.contains(s)).toList().isEmpty()) {
            result1 += 1;
          }
        }
      }
      System.out.println(result1);
      System.out.println(result2);


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
