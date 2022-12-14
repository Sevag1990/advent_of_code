package day11;

import java.util.List;

public class Monkey {
  private List<Long> startingItems;
  private String operation;
  private int divisible;
  private String ifTrue;
  private String ifFalse;
  private Long inspectedItems;

  public List<Long> getStartingItems() {
    return startingItems;
  }

  public void setStartingItems(List<Long> startingItems) {
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

  public Long getInspectedItems() {
    return inspectedItems;
  }

  public void setInspectedItems(Long inspectedItems) {
    this.inspectedItems = inspectedItems;
  }
}
