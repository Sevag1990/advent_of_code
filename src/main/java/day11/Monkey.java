package day11;

import java.util.List;

public class Monkey {
  private List<Integer> startingItems;
  private String operation;
  private int divisible;
  private String ifTrue;
  private String ifFalse;
  private Integer inspectedItems;

  public List<Integer> getStartingItems() {
    return startingItems;
  }

  public void setStartingItems(List<Integer> startingItems) {
    this.startingItems = startingItems;
  }


  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public int getDivisible() {
    return divisible;
  }

  public void setDivisible(int divisible) {
    this.divisible = divisible;
  }

  public String getIfTrue() {
    return ifTrue;
  }

  public void setIfTrue(String ifTrue) {
    this.ifTrue = ifTrue;
  }

  public String getIfFalse() {
    return ifFalse;
  }

  public void setIfFalse(String ifFalse) {
    this.ifFalse = ifFalse;
  }

  public Integer getInspectedItems() {
    return inspectedItems;
  }

  public void setInspectedItems(Integer inspectedItems) {
    this.inspectedItems = inspectedItems;
  }
}
