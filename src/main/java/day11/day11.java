package day11;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class day11 {

  public static void main(String[] args) {
    Pattern startingItemsPattern = Pattern.compile("[-]{0,1}[\\d]*[.]{0,1}[\\d]+");//. represents single character
    Pattern operationPattern = Pattern.compile("(?<=:\\snew\\s=\\s).*");//. represents single character
    int round = 0;
    int inspectsCounter;
    List<String> inputs = getStringList();
    List<Monkey> monkeyList = new ArrayList<>();
    List<Integer> startingItems = new ArrayList<>();
    Monkey monkey = new Monkey();

    parseInputToMonkey(startingItemsPattern, operationPattern, inputs, monkeyList, startingItems, monkey);

    while (round < 20 ) {
      for (Monkey m : monkeyList) {
        inspectsCounter = m.getInspectedItems() != null ? m.getInspectedItems() : 0;
        if (m.getStartingItems().isEmpty()) {
          continue;
        }
        Iterator<Integer> i = m.getStartingItems().iterator();
        while (i.hasNext()) {
          inspectsCounter++;
          String[] worryLevels = m.getOperation().trim().replace("old", i.next().toString()).replace("\\s", "").split(
              "\\D+");

          if (m.getOperation().contains("*")) {
            int worryLevel = (Integer.parseInt(worryLevels[0].trim()) * Integer.parseInt(worryLevels[1].trim())) / 3 ;
            if (worryLevel % m.getDivisible() == 0) {
              monkeyList.get(Integer.parseInt(m.getIfTrue())).getStartingItems().add(worryLevel);

            } else {
              monkeyList.get(Integer.parseInt(m.getIfFalse())).getStartingItems().add(worryLevel);
            }
          }
          if (m.getOperation().contains("+")) {
            int worryLevel = (Integer.parseInt(worryLevels[0].trim()) + Integer.parseInt(worryLevels[1].trim())) / 3 ;
            if (worryLevel % m.getDivisible() == 0) {
              monkeyList.get(Integer.parseInt(m.getIfTrue())).getStartingItems().add(worryLevel);
            } else {
              monkeyList.get(Integer.parseInt(m.getIfFalse())).getStartingItems().add(worryLevel);
            }

          }
          if (m.getOperation().contains("/")) {
            int worryLevel = (Integer.parseInt(worryLevels[0].trim()) / Integer.parseInt(worryLevels[1].trim())) / 3;
            if (worryLevel % m.getDivisible() == 0) {
              monkeyList.get(Integer.parseInt(m.getIfTrue())).getStartingItems().add(worryLevel);
            } else {
              monkeyList.get(Integer.parseInt(m.getIfFalse())).getStartingItems().add(worryLevel);
            }
          }
          if (m.getOperation().contains("-")) {
            int worryLevel = (Integer.parseInt(worryLevels[0].trim()) - Integer.parseInt(worryLevels[1].trim())) / 3;
            if (worryLevel % m.getDivisible() == 0) {
              monkeyList.get(Integer.parseInt(m.getIfTrue())).getStartingItems().add(worryLevel);
            } else {
              monkeyList.get(Integer.parseInt(m.getIfFalse())).getStartingItems().add(worryLevel);
            }
          }
          i.remove();

        }
        m.setInspectedItems(inspectsCounter);
      }
      round++;
    }
    var result1 = monkeyList
        .stream()
        .map(Monkey::getInspectedItems)
        .sorted(Comparator.reverseOrder())
        .map(BigDecimal::new)
        .limit(2).toList();

    System.out.println(result1.get(0).multiply(result1.get(1)));
  }

  private static void parseInputToMonkey(Pattern startingItemsPattern, Pattern operationPattern, List<String> inputs, List<Monkey> monkeyList, List<Integer> startingItems, Monkey monkey) {
    for (String input : inputs) {
      if (input.isBlank()) {
        continue;
      }
      if (input.contains("Monkey")) {
        if (!input.contains("0")) {
          monkeyList.add(monkey);
        }
        monkey = new Monkey();
        startingItems = new ArrayList<>();
        continue;
      }
      if (input.contains("Starting items: ")) {
        Matcher m = startingItemsPattern.matcher(input);
        while (m.find()) {
          startingItems.add(Integer.valueOf(m.group()));
        }
        monkey.setStartingItems(startingItems);
      }

      if (input.contains("Operation: ")) {
        Matcher m = operationPattern.matcher(input);
        while (m.find()) {
          monkey.setOperation(m.group());
        }
      }
      if (input.contains("Test: divisible by ")) {
        Matcher m = startingItemsPattern.matcher(input);
        while (m.find()) {
          monkey.setDivisible(Integer.parseInt(m.group()));
        }
      }
      if (input.contains("If true: ")) {
        Matcher m = startingItemsPattern.matcher(input);
        while (m.find()) {
          monkey.setIfTrue(m.group());
        }
      }
      if (input.contains("If false:")) {
        Matcher m = startingItemsPattern.matcher(input);
        while (m.find()) {
          monkey.setIfFalse(m.group());
        }
      }
    }
    monkeyList.add(monkey);
  }


  private static List<String> getStringList() {
    try (Stream<String> stream = Files.readAllLines(Paths.get("inputs", "day11.txt")).stream()) {
      return stream.toList();
    } catch (final IOException e) {
      e.printStackTrace();
    }
    return List.of();
  }

}

