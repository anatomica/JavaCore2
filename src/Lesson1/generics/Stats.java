package Lesson1.generics;

public class Stats <E extends Number> {

    private E[] nums;

    public Stats(E[] nums) {
        this.nums = nums;
    }

    public double avg () {
        double sum = 0.0;
        for (int i = 0; i<nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    public boolean isAvgSame (Stats<?> anotherStats) {
        return Math.abs(this.avg() - anotherStats.avg()) < 0.00001;
    }


    public static void main(String[] args) {
        Integer[] ints = {1,2, 3, 4, 7, 9};
        Double[] doubles = {1.0 ,2.0, 3.0, 4.0, 7.0, 9.0};
//        Double[] doubles = {1.2, 2.1, 3.3, 4.5, 7.1, 9.0};

        Stats <Integer> intStats = new Stats<>(ints);
        System.out.println("avg ints is: "+ intStats.avg());

        Stats <Double> doubleStats = new Stats<>(doubles);
        System.out.println("avg doubles is: "+ doubleStats.avg());

        System.out.println("avg is same " + intStats.isAvgSame(doubleStats));
    }
}
