package day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class day7 {
  public static void main(String[] args) throws Exception {
    List<String> input = getStringList();
    List<Directory> allDirectories = new ArrayList<>();
    Directory root = new Directory(null, "root");
    Directory currDir = root;

    for (int i = 1; i < input.size(); i++) {
      String[] raw = input.get(i).split(" ");
      if (raw[1].equals("ls")) {
        continue;
      }
      if (raw[1].equals("cd")) {
        if (raw[2].equals("..")) {
          currDir = currDir.getParent();
          continue;
        }
        if (raw[2].matches("\\w+")) {
          currDir = currDir.getDir(raw[2]);
          continue;
        }
      }
      if (raw[0].equals("dir")) {
        Directory de = new Directory(currDir, raw[1]);
        currDir.addFile(de);
        allDirectories.add(de);
      } else {
        currDir.addFile(new File(raw[1], Long.parseLong(raw[0])));
      }
    }
    int result1 = 0;
    int updateSpace = 30000000;
    long unusedSpace = 70000000 - root.getsize();

    for (Directory d : allDirectories) {
      if (d.getsize() < 100000) {
        result1 += d.getsize();
      }
    }
    System.out.println(result1);

    List<Long> removedDirs = new ArrayList<>();
    for (Directory s : allDirectories) {
      if (updateSpace <= (unusedSpace + s.getsize())) {
        removedDirs.add(s.getsize());
      }
    }
    System.out.println(Collections.min(removedDirs));
  }


  private static List<String> getStringList() {
    try (Stream<String> stream = Files.lines(Paths.get("inputs", "day7.txt"))) {
      return stream.toList();
    } catch (final IOException e) {
      e.printStackTrace();
    }
    return List.of();
  }


  public static class File {
    public String name;
    public Long size;

    public File(String name, Long size) {
      this.name = name;
      this.size = size;
    }

    public String getName() {
      return name;
    }

    public long size() {
      return size;
    }
  }

  public static class Directory extends File {
    private Map<String, File> files = new HashMap();

    private final Directory parent;

    public Directory(Directory parent, String name) {
      super(name, 0L);
      this.parent = parent;
    }

    public long getsize() {
      long count = 0;
      for (File file : files.values()) {
        count += file.size();
      }
      return count;
    }

    public Directory getDir(String s) {
      return (Directory) files.get(s);
    }

    public Directory getParent() {
      return parent;
    }

    public void addFile(File fe) {
      files.put(fe.getName(), fe);
    }

    public long size() {
      long count = 0;
      for (File fe : files.values()) {
        count += fe.size();
      }
      return count;
    }
  }
}

