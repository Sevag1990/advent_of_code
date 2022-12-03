package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class day1 {
  public static void main(String[] args) {

    String data = """
        1000
        2000
        3000

        4000

        5000
        6000

        7000
        8000
        9000

        10000
            """;
    try {
       BufferedReader br = new BufferedReader(new FileReader("inputs/day1.txt"));
      String line;
      int mostOfCalories = 0;
      List<Integer> listOfCalories = new ArrayList();
      while ((line = br.readLine())!=null) {
     // for (String line : data.split("\n")) {
        if (line.isBlank()) {
          listOfCalories.add(mostOfCalories);
          mostOfCalories = 0;
        } else {
          int i = Integer.parseInt(line);
          mostOfCalories += i;
        }
      }
      listOfCalories.add(mostOfCalories);

      System.out.println(Collections.max(listOfCalories));
      Collections.sort(listOfCalories);
      List<Integer> top3 = new ArrayList<>(listOfCalories.subList(listOfCalories.size() -3, listOfCalories.size()));
      AtomicReference<Integer> sumOfTop3 = new AtomicReference<>(0);
      top3.forEach(s -> sumOfTop3.updateAndGet(v -> v + s));
      System.out.println(sumOfTop3);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
