package day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class day8 {
  public static void main(String[] args) {
    int result1 = 0;
    int result2 = 0;
    int scenicScore = 0;

    List<String> input = getStringList();
    int[][] result = new int[input.size()][input.get(0).length()];
    int x = 0;
    int y;

    for (String s : input) {
      y = 0;
      for (Character ch : s.toCharArray()) {
        result[x][y] = Integer.parseInt(ch.toString());
        y++;
      }
      x++;
    }

    for (int i = 1; i < result.length - 1; i++) {
      for (int j = 1; j < result.length - 1; j++) {
        int currentPosition = result[i][j];
        if (checkDown(currentPosition, i, j, result) || checkUp(currentPosition, i, j, result) || checkLeft(currentPosition, i, j,
            result) || checkRight(currentPosition, i, j, result)) {
          result1++;
        }
      }
    }
    for (int i = 1; i < result.length - 1; i++) {
      for (int j = 1; j < result.length - 1; j++) {
        int currentPosition = result[i][j];
        scenicScore = checkDownscenic(currentPosition, i, j, result) * checkUpscenic(currentPosition, i, j, result) * checkLeftscenic(
            currentPosition, i, j, result) * checkRightscenic(currentPosition, i, j, result);
        if (scenicScore > result2) {
          result2 = scenicScore;
        }


      }
    }
    int edges = (input.size() * 2) + (input.get(0).length() * 2) - 4;
    System.out.println(result2);
    System.out.println("result1: " + (result1 + edges));
  }

  private static boolean checkUp(int currentPosition, int x, int y, int[][] result) {
    int i = x;

    while (i != 0) {
      i--;
      if (currentPosition <= result[i][y]) {
        return false;
      }
    }

    return true;
  }

  private static boolean checkDown(int currentPosition, int x, int y, int[][] result) {
    int i = x;
    while (i < result.length - 1) {
      i++;
      if (currentPosition <= result[i][y]) {
        return false;
      }
    }
    return true;
  }

  private static boolean checkLeft(int currentPosition, int x, int y, int[][] result) {
    int i = y;

    while (i != 0) {
      i--;
      if (currentPosition <= result[x][i]) {

        return false;
      }
    }

    return true;
  }

  private static boolean checkRight(int currentPosition, int x, int y, int[][] result) {
    int i = y;
    while (i < result.length - 1) {
      i++;
      if (currentPosition <= result[x][i]) {

        return false;
      }
    }

    return true;
  }


  private static int checkUpscenic(int currentPosition, int x, int y, int[][] result) {
    int i = x;
    int counter = 0;
    while (i != 0) {
      i--;
      counter++;
      if (currentPosition <= result[i][y]) {
        return counter;

      }
    }
    return counter;
  }

  private static int checkDownscenic(int currentPosition, int x, int y, int[][] result) {
    int i = x;
    int counter = 0;
    while (i < result.length - 1) {
      i++;
      counter++;
      if (currentPosition <= result[i][y]) {
        return counter;

      }
    }
    return counter;
  }

  private static int checkLeftscenic(int currentPosition, int x, int y, int[][] result) {
    int i = y;
    int counter = 0;

    while (i != 0) {
      i--;
      counter++;
      if (currentPosition <= result[x][i]) {
        return counter;

      }
    }
    return counter;

  }

  private static int checkRightscenic(int currentPosition, int x, int y, int[][] result) {
    int i = y;
    int counter = 0;
    while (i < result.length - 1) {
      i++;
      counter++;
      if (currentPosition <= result[x][i]) {
        return counter;

      }
    }
    return counter;
  }


  private static List<String> getStringList() {
    try (Stream<String> stream = Files.readAllLines(Paths.get("inputs", "day8.txt")).stream()) {
      return stream.toList();
    } catch (final IOException e) {
      e.printStackTrace();
    }
    return List.of();
  }

}

