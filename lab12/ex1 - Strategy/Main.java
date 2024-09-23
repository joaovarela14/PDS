import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone("Snapdragon 888", "108MP", 999, 128));
        phones.add(new Phone("A14 Bionic", "12MP", 1099, 64));
        phones.add(new Phone("Exynos 2100", "108MP", 899, 256));
        phones.add(new Phone("Kirin 9000", "50MP", 799, 128));

        System.out.println("--------------QuickSort sort by price----------\n");
        PhoneSorter phoneSorter = new PhoneSorter(new QuickSort(new ArrayList<>(phones), Comparator.comparing(Phone::getPrice)));
        long startTime = System.nanoTime();
        phoneSorter.sort();
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Sorted by price (ascending order):");
        phoneSorter.printSorted();
        System.out.println("Duration: " + duration + " nanoseconds\n");

        System.out.println("\n ------------MergeSort sort by storage-------\n");
        phoneSorter.setSortingMethod(new MergeSort(new ArrayList<>(phones), Comparator.comparing(Phone::getStorage)));
        startTime = System.nanoTime();
        phoneSorter.sort();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Sorted by storage (ascending order):");
        phoneSorter.printSorted();
        System.out.println("Duration: " + duration + " nanoseconds\n");
        phoneSorter.orderDescending();
        System.out.println("Sorted by storage (descending order):");
        phoneSorter.printSorted();

        System.out.println("\n----------BubbleSort sort by camera--------\n");
        phoneSorter.setSortingMethod(new BubbleSort(new ArrayList<>(phones), Comparator.comparing(Phone::getCamera)));
        startTime = System.nanoTime();
        phoneSorter.sort();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Sorted by camera (ascending order):");
        phoneSorter.printSorted();
        System.out.println("Duration: " + duration + " nanoseconds\n");
        phoneSorter.orderDescending();
        System.out.println("Sorted by camera (descending order):");
        phoneSorter.printSorted();
    }
}