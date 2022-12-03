package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class day3 {
  public static void main(String[] args) {
    String firstCompartment;
    String secondCompartment;
    int result1 = 0;
    int result2 = 0;
    List<String> group = new ArrayList<>();
    List<Character> alphabet = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
        't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
        'T', 'U', 'V', 'W', 'X', 'U', 'Z');
    try {
      BufferedReader br = new BufferedReader(new FileReader("inputs/day3.txt"));
      String line;
      while ((line = br.readLine()) != null) {
//        // Part2
//      98
//        }
//
//        Set<Character> commonChars = convertStringToSetOfChars(group.get(0));
//        group.stream().skip(1).forEach(s -> commonChars.retainAll(convertStringToSetOfChars(s)));
//
//        result2 += alphabet.indexOf(commonChars.iterator().next()) + 1;
//        group = new ArrayList<>();

        firstCompartment = line.substring(0, line.length() / 2);
        secondCompartment = line.substring(line.length() / 2);
        Character result = findCommonLetter(firstCompartment, secondCompartment);
//
//        //System.out.println(alphabet.indexOf(result)+1);
       result1 += alphabet.indexOf(result) + 1;


      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("Part 1 = " + result1);
    System.out.println("Part 2= " + result2);

  }

  static Character findCommonLetter(String firstCompartment, String secondCompartment) {
    for (char ch : firstCompartment.toCharArray()) {
      int index = secondCompartment.indexOf(ch);
      if (index != -1) {
        return (secondCompartment.charAt(index));
      }
    }
    return null;
  }
  private static Set<Character> convertStringToSetOfChars(String string) {
    if (string == null || string.isEmpty()) {
      return Collections.emptySet();
    }

    Set<Character> set = new HashSet<>(string.length() + 10);
    for (char c : string.toCharArray()) {
      set.add(c);
    }

    return set;
  }
}
