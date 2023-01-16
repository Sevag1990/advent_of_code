package day9;

import java.awt.Point;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;


public class day9 {

  public static void main(String[] args) {

    Point head = new Point(0, 4);
    Point tail = new Point(0, 4);

    Set<Point> tailPositions = new HashSet<>();
    List<String> inputs = getStringList();

    tailPositions.add(tail);

    for (String input : inputs) {
      String direction;
      int steps;
      String[] split = input.split(" ");


      direction = split[0];
      steps = Integer.parseInt(split[1]);

      switch (direction) {
        case "U" -> up(head, steps, tail, tailPositions);
        case "D" -> down(head, steps, tail, tailPositions);
        case "R" -> right(head, steps, tail, tailPositions);
        case "L" -> left(head, steps, tail, tailPositions);
        default -> throw new IllegalArgumentException("Should not come here");
      }
    }
    System.out.println(tailPositions.size());
  }


  private static void left(Point head, int steps, Point tail, Set<Point> tailPositions) {
    for (int i = 0; i < steps; i++) {
      head.setLocation(head.x - 1, head.y);
      if (Math.abs(head.x - tail.x) > 1) {
        tail.setLocation(tail.x - 1, head.y);
        tailPositions.add(new Point(tail.x,tail.y));
      }
    }
  }

  private static void right(Point head, int steps, Point tail, Set<Point> tailPositions ) {
    for (int i = 0; i < steps; i++) {
      head.setLocation(head.x + 1, head.y);
      if (Math.abs(head.x - tail.x) > 1) {
        tail.setLocation(tail.x + 1, head.y);
        tailPositions.add(new Point(tail.x,tail.y));
      }
    }
  }

  private static void down(Point head, int steps, Point tail, Set<Point> tailPositions) {
    for (int i = 0; i < steps; i++) {
      head.setLocation(head.x, head.y + 1);
      if (Math.abs(head.y - tail.y) > 1) {
        tail.setLocation(head.x, tail.y + 1);
        tailPositions.add(new Point(tail.x,tail.y));
      }
    }
  }

  private static void up(Point head, int steps, Point tail, Set<Point> tailPositions) {
    for (int i = 0; i < steps; i++) {
      head.setLocation(head.x, head.y - 1);
      if (Math.abs(head.y - tail.y) > 1) {
        tail.setLocation(head.x, tail.y - 1);
        tailPositions.add(new Point(tail.x,tail.y));
      }
    }
  }


  private static List<String> getStringList() {
    try (Stream<String> stream = Files.readAllLines(Paths.get("inputs", "day9.txt")).stream()) {
      return stream.toList();
    } catch (final IOException e) {
      e.printStackTrace();
    }
    return List.of();
  }

}

