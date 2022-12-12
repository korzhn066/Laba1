public class Apple extends Food {
  private String size;

  public Apple(String size) {
    super("Яблоко");
    this.size = size;
    System.out.println("Яблоко было добавлено в завтрак.");
  }

  public void consume() {
    System.out.println(this + " съедено");
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public boolean equals(Object arg0) {
    if (super.equals(arg0)) {
      if (!(arg0 instanceof Apple)) return false;
      return size.equals(((Apple) arg0).size);
    } else return false;
  }

  public String toString() {
    return super.toString() + " размера '" + size.toUpperCase() + "'";
  }

  public double calculateCalories() {
    return 50;
  }
  public int getParams() {
    return 1;
  }
}
