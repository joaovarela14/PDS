import java.util.*;

class QuickSort extends SortingMethod {

    public QuickSort(List<Phone> phones, Comparator<Phone> comparator) {
        super(phones, comparator);
    }

    @Override
    public void sort() {
        quickSort(0, phones.size() - 1);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        Phone pivot = phones.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (comparator.compare(phones.get(j), pivot) < 0) {
                i++;
                Phone temp = phones.get(i);
                phones.set(i, phones.get(j));
                phones.set(j, temp);
            }
        }
        Phone temp = phones.get(i + 1);
        phones.set(i + 1, phones.get(high));
        phones.set(high, temp);
        return i + 1;
    }
}