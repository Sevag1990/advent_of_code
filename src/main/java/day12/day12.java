package day12;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class day12 {

    public static void main(String[] args) {
        Point end = new Point();
        Point currentPoint = new Point();
        Map<Point, String> possibleMove;

        String[] order = "abcdefghijklmnopqrstuvwxyz".split("");
        var counter = 0;
        boolean found = false;
        Set<Point> visited = new HashSet<>();

        List<String> inputs = getStringList();
        Map<Point, String> heightmap = new HashMap<>();
        parseInput(currentPoint, end, inputs, heightmap);


        while (!found) {
            possibleMove = new HashMap<>();
            var up = new Point(currentPoint.x, currentPoint.y - 1);
            var down = new Point(currentPoint.x, currentPoint.y + 1);
            var left = new Point(currentPoint.x - 1, currentPoint.y);
            var right = new Point(currentPoint.x + 1, currentPoint.y);

            if (order[counter].equals("z")) {
                found = true;
                continue;
            }
            if (heightmap.get(up) != null) {
                possibleMove.put(new Point(up), heightmap.get(up));
            }


            if (heightmap.get(down) != null) {
                possibleMove.put(new Point(down), heightmap.get(down));
            }
            if (heightmap.get(left) != null) {
                possibleMove.put(new Point(left), heightmap.get(left));
            }
            if (heightmap.get(right) != null) {

                possibleMove.put(new Point(right), heightmap.get(right));
            }


            for (Map.Entry<Point, String> t : possibleMove.entrySet()) {
                if (!visited.contains(t.getKey())) {

                    if (order[counter].compareTo(t.getValue()) == 0) {
                        visited.add(new Point(t.getKey()));
                        currentPoint = new Point(t.getKey());
                        break;
                    }
                }
            }
            counter++;
        }

        System.out.println(visited.size());

    }


    private static void parseInput(Point start, Point end, List<String> inputs, Map<Point, String> map) {
        int x;
        int y = 0;

        for (String input : inputs) {
            x = 0;
            for (String word : input.split("")) {
                if (word.equals("S")) {
                    start.setLocation(new Point(x, y));
                }
                if (word.equals("E")) {
                    end.setLocation(new Point(x, y));
                }

                map.put(new Point(x, y), word);
                x++;
            }
            y++;
        }
    }


    private static List<String> getStringList() {
        try (Stream<String> stream = Files
                .readAllLines(Paths.get("inputs", "day12.txt"))
                .stream()) {
            return stream.toList();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }

}

