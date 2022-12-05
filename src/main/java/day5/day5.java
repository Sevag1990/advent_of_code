package day5;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Stream;

public class day5 {

  public static void main(String[] args) {
    final List<Deque<Character>> stacks = new ArrayList<>();
    StringBuilder result1 = new StringBuilder();
    List<String> input = getStringList();
    int numberOfStacks = 9;

    for (int i = 0; i < numberOfStacks; i++) {
      stacks.add(new ArrayDeque<>());
    }
    for (String line : input) {
      if (line.contains("[")) {
        for (int i = 1, stackCounter = 0; i < line.length(); i += 4, stackCounter++) {
          final char crate = line.charAt(i);
          if (!Character.isSpaceChar(crate)) {
            stacks.get(stackCounter).add(crate);

          }
        }
      }
    }
    for (final String line : input) {
      if (!line.contains("[") && line.startsWith("move")) {
        List<String> t = Arrays.stream(line
                .trim()
                .split("\\s+"))
            .filter(s -> s.matches("(\\d+)"))
            .toList();

        int howMany = Integer.parseInt(t.get(0));
        int from = Integer.parseInt(t.get(1)) - 1;
        int to = Integer.parseInt(t.get(2)) - 1;
        Deque<Character> createsMove = new ArrayDeque<>();

        if (howMany > 1) {
          for (int i = 0; i < howMany; i++) {
            createsMove.push(stacks.get(from).pop());
          }
          createsMove.forEach(c -> stacks.get(to).push(c));
        } else {
          for (int i = 0; i < howMany; i++) {
            stacks.get(to).push(stacks.get(from).pop());
          }
        }
      }
    }
    stacks.forEach(s -> result1.append(s.pop()));
    System.out.println(result1);
  }

  private static List<String> getStringList() {
    try (Stream<String> stream = Files.lines(Paths.get("inputs", "day5.txt"))) {
      return stream.toList();
    } catch (final IOException e) {
      e.printStackTrace();
    }
    return new ArrayList<>();
  }

}
