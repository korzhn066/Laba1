import java.lang.invoke.WrongMethodTypeException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import  java.lang.reflect.*;
import java.util.Vector;

public class Main {

  public static void main(String[] args) throws ClassNotFoundException {
    Vector<Food> _breakfast;
    _breakfast = new Vector<Food>();

    int appleAmount = 0;
    int cheeseAmount = 0;
    int dessertAmount = 0;

    for (String arg : args) {
      String[] parts = arg.split("/");
      if (parts[0].equals("Cheese")) {
        _breakfast.add(new Cheese());
        cheeseAmount++;
      }
      else if (parts[0].equals("Apple")) {
        _breakfast.add(new Apple(parts[1]));
        appleAmount++;
      }
      else if (parts[0].equals("Dessert")) {
        _breakfast.add(new Dessert(parts[1], parts[2]));
        dessertAmount++;
      }else {
        throw new ClassNotFoundException();
      }
    }

    System.out.println(
      "Количество яблок = " +
      appleAmount +
      ", количество сыра = " +
      cheeseAmount +
      ", количество десертов = " +
              dessertAmount
    );

    Scanner in = new Scanner(System.in);

    while (true) {
      System.out.println(
        "Введите действие (-exit - завершить программу, -calories, -sort): "
      );
      String input = in.nextLine();

      if (input.trim().equals("-exit")) {;
        break;
      }

      if (input.trim().equals("-sort")) {
        Comparator<Food> comparator = Comparator.comparing(
          Food::getParams
        );

        _breakfast.sort(comparator.reversed());

        for (Food food : _breakfast) {
          System.out.println(food + " " + food.getParams());
        }
      } else if (input.trim().equals("-calories")) {
        double result = 0.0;
        for (Food food : _breakfast) {
          result += food.calculateCalories();
        }
        System.out.println("Калории = " + result);
      } else {
        throw new WrongMethodTypeException(input);
      }
    }

    for (Food food : _breakfast) {
      food.consume();
    }

    in.close();
  }
}
