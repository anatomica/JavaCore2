package Lesson1.Homework;
import java.util.ArrayList;

public class Box <F extends Fruit> {

    private ArrayList<F> fruits;
    private float totalWeight;

    Box() {
        fruits = new ArrayList<>();
    }

    public Box(ArrayList<F> fruits) {
        this.fruits = fruits;
    }

    float getWeight() {
        if (fruits.size() == 0) {
            totalWeight = 0;
        }
        if (fruits.size() != 0) {
            totalWeight = fruits.size() * fruits.get(0).getWeight();
        }
        return totalWeight;
    }

    boolean compare(Box<?> otherBox) {
        return getWeight() == otherBox.getWeight();
    }

    void replaceFruits(Box<F> otherBox) {
        otherBox.fruits.addAll(fruits);
        fruits.clear();
    }

    void addFruit(F fruitToAdd) {
        fruits.add(fruitToAdd);
    }

}