public class Food implements Consumable, Nutritious, IParams {
  String name = null;

  public Food(String name) {
    this.name = name;
  }

  public boolean equals(Object arg0) {
    if (!(arg0 instanceof Food)) return false; // Шаг 1
    if (name == null || ((Food) arg0).name == null) return false; // Шаг 2
    return name.equals(((Food) arg0).name); // Шаг 3
  }

  public String toString() {
    return "bla bla bla";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void consume() {

  }

  @Override
  public double calculateCalories() {
    return 0;
  }

  @Override
  public int getParams() {
    return 0;
  }
}
