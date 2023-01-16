package day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


public class day10 {

  public static void main(String[] args) {
    int register = 1;
    int result1 = 0;
    int counter = 0;
    int excectuionIdx = 0;
    int cycle = 0;
    List<String> inputs = getStringList();

    while (counter < inputs.size()) {
      String[] split = inputs.get(counter).split(" ");
      String command = split[0];
      cycle++;
      draw(cycle, register);
      if (cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220) {
        result1 += (register * cycle);
      }

      if (command.equals("noop")) {
        counter++;
        continue;
      }
      String value = split[1];

      if (command.contains("addx")) {
        if (excectuionIdx == 0) {
          excectuionIdx = 1;
        } else {
          register += Integer.parseInt(value);
          excectuionIdx = 0;
          counter++;
        }
      }
    }
    System.out.println(result1);
  }

  private static void draw(int cycle, int register) {
    int currentPos = (cycle % 40) + 1;
    if (currentPos < register + 1 || currentPos > register + 3) {
      System.out.print(" ");
    } else {
      System.out.print("#");
    }
    if (currentPos == 1) {
      System.out.println();
    }

  }


  private static List<String> getStringList() {
    try (Stream<String> stream = Files.readAllLines(Paths.get("inputs", "day10.txt")).stream()) {
      return stream.toList();
    } catch (final IOException e) {
      e.printStackTrace();
    }
    return List.of();
  }

}

