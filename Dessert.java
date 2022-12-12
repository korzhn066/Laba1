import java.util.Random;
import java.util.Scanner;

public class Dessert extends Food{

    String param1;
    double param1cal;

    String param2;
    double param2cal;

    public Dessert(String param1, String param2) {
        super("Десерт");

        SetParam1(param1);
        SetParam2(param2);
        System.out.println("Десерт был добавлен в завтрак.");
    }

    public boolean equals(Object argO) {
        if (!(argO instanceof Dessert)) return false;
        if (name == null || ((Dessert) argO).name == null) return false;
        return name.equals(((Dessert) argO).name);
    }

    public void SetParam1(String param) {
        param1 = param;
        param1cal = new Random().nextDouble();
    }

    public void SetParam2(String param) {
        param2 = param;
        param1cal = new Random().nextDouble();
    }

    public String toString() {
        return this.name + " dessert " + param1 + " и " + param2;
    }

    public String GetName() {
        return name;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public double calculateCalories() {
        return param1cal + param2cal;
    }

    public void consume() {
        System.out.println(this + " был cъеден");
    }
    public int getParams() {
        return 2;
    }
}
