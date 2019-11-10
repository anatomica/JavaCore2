package Lesson1.Homework;

public class MainClass {

    public static void main(String[] args) {

        System.out.println("Задание 1");
        GenericClass<Integer> numArray = new GenericClass<>(new Integer[]{1, 2, 6, 4, 5, 3, 7});

        numArray.display();
        numArray.exchange(2,5);
        System.out.println("Массив после замены:");
        numArray.display();

        System.out.println("Массив в ArrayList:");
        numArray.createArrayList();

        System.out.println("\nЗадание 2");

        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        System.out.println("Общий вес яблок в коробке: " + appleBox.getWeight());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        System.out.println("Общий вес апельсинов в коробке: " + orangeBox.getWeight());

        System.out.println("Результат сравнения веса коробок: " + appleBox.compare(orangeBox) + "\n");

        Box<Apple> secondAppleBox = new Box<>();
        appleBox.replaceFruits(secondAppleBox);
        System.out.println("Пересыпали яблоки в другую коробку!");
        System.out.println("Вес яблок в 1 коробке: " + appleBox.getWeight());
        System.out.println("Вес яблок во 2 коробке: " + secondAppleBox.getWeight());

        secondAppleBox.addFruit(new Apple());
        secondAppleBox.addFruit(new Apple());
        System.out.println("Вес 2 коробки после добавления 2 яблок: " + secondAppleBox.getWeight());
        System.out.println("Результат сравнения веса разных коробок: " + secondAppleBox.compare(orangeBox));

    }
}
