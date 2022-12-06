package day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class day6 {
  public static void main(String[] args) {
    List<String> input = getStringList();
    int counter = 0;
    int marker1 = 4;
    int marker2 = 14;

    StringBuilder builder = new StringBuilder();
    for (Character t : input.get(0).toCharArray()) {
      String stringRange = input.get(0).substring(counter, marker1++);
      if (!isMarker(stringRange) ) {
        builder.append(stringRange);
        System.out.println("result1: " + builder.length());
        break;
      }
      counter++;
      builder.append(t);
    }
     builder = new StringBuilder();
     counter = 0;
    for (Character t : input.get(0).toCharArray()) {
      String stringRange2 = input.get(0).substring(counter, marker2++);
      if (!isMarker(stringRange2)) {
        builder.append(stringRange2);
        System.out.println("result2: " + builder.length());
        break;
      }
      counter++;
      builder.append(t);
    }
  }

  private static boolean isMarker(String marker) {
    for (int i = 0; i < marker.length(); i++) {
      for (int j = i + 1; j < marker.length(); j++) {
        if (marker.charAt(i) == marker.charAt(j)) {
          return true;
        }
      }
    }
    return false;
  }

  private static List<String> getStringList() {
    try (Stream<String> stream = Files.lines(Paths.get("inputs", "day6.txt"))) {
      return stream.toList();
    } catch (final IOException e) {
      e.printStackTrace();
    }
    return List.of();
  }

}
