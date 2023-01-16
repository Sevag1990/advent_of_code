package day2;

import java.io.BufferedReader;
import java.io.FileReader;

public class day2 {
  public static void main(String[] args) {
    String myElf;
    String opponent;
    int sum = 0;
    int result1 = 0;
    int result2 = 0;

    try {
      BufferedReader br = new BufferedReader(new FileReader("inputs/day2.txt"));
      String line;
      while ((line = br.readLine()) != null) {
        if (line.isBlank()) {
          continue;
        }
        String round = line.replace(" ", "");
        String[] splitString = line.split(" ");
        opponent = splitString[0];
        myElf = splitString[1];
        result1 += roundOutcome(round, opponent, myElf, sum);

        String newHand = chooseMyelfHand(opponent, myElf);
        String newRound = opponent + newHand;
        result2 += roundOutcome(newRound, opponent, newHand, sum);


      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println(result1);
    System.out.println(result2);

  }

  private static String chooseMyelfHand(String opponent, String myElf) {
    //lose
    if (myElf.equals("X")) {
      if (opponent.equals("A")) {
        return "Z";
      }
      if (opponent.equals("B")) {
        return "X";
      }
      if (opponent.equals("C")) {
        return "Y";
      }
    }
    //draw
    if (myElf.equals("Y")) {
      if (opponent.equals("A")) {
        return "X";
      }
      if (opponent.equals("B")) {
        return "Y";
      }
      if (opponent.equals("C")) {
        return "Z";
      }
    }
    //win
    if (myElf.equals("Z")) {
      if (opponent.equals("A")) {
        return "Y";
      }
      if (opponent.equals("B")) {
        return "Z";
      }
      if (opponent.equals("C")) {
        return "X";
      }
    }

    return "";
  }


  private static int roundOutcome(String round, String opponent, String myElf, int sum) {
    if (round.equals("AX") || round.equals("BY") || round.equals("CZ")) {
      sum += Hand.valueOf(opponent).label + 3;
      return sum;
    }
    if (round.equals("AY")) {
      sum += Hand.valueOf(myElf).label + 6;
      return sum;
    }
    if (round.equals("BZ")) {
      sum += Hand.valueOf(myElf).label + 6;
      return sum;
    }
    if (round.equals("CX")) {
      sum += Hand.valueOf(myElf).label + 6;
      return sum;
    }
    return sum + Hand.valueOf(myElf).label;
  }
}