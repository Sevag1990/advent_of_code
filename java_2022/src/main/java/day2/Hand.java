package day2;

public enum Hand {
  A(1),
  B(2),
  C(3),
  X(1),
  Y(2),
  Z(3)
  ;
  public final int label;

  private Hand(int label) {
    this.label = label;
  }
}
