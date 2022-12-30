package day12;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.*;


public class day12 {

    public static void main(String[] args) {
        final Point end = new Point();
        final Point start = new Point();
        final List<Point> startList = new ArrayList<>();
        final List<Integer> paths = new ArrayList<>();

        List<Point> que;
        Map<Point, Integer> pathCost;


        final List<String> inputs = getStringList();
        final Map<Point, Integer> heightmap = new HashMap<>();
        parseInput(start, end, inputs, heightmap, startList, false);


        for (Point startPoint : startList) {
            que = new ArrayList<>();
            pathCost = new HashMap<>();

            que.add(startPoint);
            pathCost.put(startPoint, 0);

            while (que.size() > 0) {
                final Point p = que.remove(0);
                final Map<Point, Integer> possibleMove = new HashMap<>();
                var up = new Point(p.x, p.y - 1);
                var down = new Point(p.x, p.y + 1);
                var left = new Point(p.x - 1, p.y);
                var right = new Point(p.x + 1, p.y);

                if (heightmap.get(up) != null && check(p, heightmap, up)) {
                    possibleMove.put(new Point(up), heightmap.get(up));
                }
                if (heightmap.get(down) != null && check(p, heightmap, down)) {
                    possibleMove.put(new Point(down), heightmap.get(down));
                }
                if (heightmap.get(left) != null && check(p, heightmap, left)) {
                    possibleMove.put(new Point(left), heightmap.get(left));
                }
                if (heightmap.get(right) != null && check(p, heightmap, right)) {
                    possibleMove.put(new Point(right), heightmap.get(right));
                }
                for (Map.Entry<Point, Integer> t : possibleMove.entrySet()) {
                    if (p.equals(end)) {
                        paths.add(pathCost.get(p));
                        break;
                    }
                    if (!pathCost.containsKey(t.getKey())) {
                        pathCost.put(t.getKey(), pathCost.getOrDefault(p, 0) + 1);
                        que.add(t.getKey());
                    }
                }
            }
        }

        System.out.println("Result: " + min(paths));
    }

    private static boolean check(Point currentPoint, Map<Point, Integer> heightmap, Point point) {
        return heightmap.get(point) <= heightmap.get(currentPoint) ||
                heightmap.get(point) == heightmap.get(currentPoint) + 1;
    }

    private static void parseInput(Point start, Point end, List<String> inputs, Map<Point, Integer> map, List<Point> startList, boolean part1) {
        int x;
        int y = 0;

        for (String input : inputs) {
            x = 0;
            for (String word : input.split("")) {
                if (word.equals("S")) {
                    start.setLocation(new Point(x, y));
                    map.put(new Point(x, y), 0);
                    startList.add(new Point(x, y));
                    x++;
                    continue;
                }
                if (!part1) {
                    if (word.equals("a")) {
                        map.put(new Point(x, y), 0);
                        startList.add(new Point(x, y));
                        x++;
                        continue;
                    }
                }
                if (word.equals("E")) {
                    end.setLocation(new Point(x, y));
                    map.put(new Point(x, y), 'z' - 'a');
                    x++;
                    continue;
                }

                map.put(new Point(x, y), word.toLowerCase(Locale.ROOT).charAt(0) - 'a');
                x++;
            }
            y++;
        }
    }


    private static List<String> getStringList() {
        try (Stream<String> stream = Files.readAllLines(Paths.get("inputs", "day12.txt")).stream()) {
            return stream.toList();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }

}

