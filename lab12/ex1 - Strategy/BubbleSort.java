import java.util.*;

class BubbleSort extends SortingMethod {

    public BubbleSort(List<Phone> phones, Comparator<Phone> comparator) {
        super(phones, comparator);
    }

    @Override
    public void sort() {
        int n = phones.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(phones.get(j), phones.get(j + 1)) > 0) {
                    Phone temp = phones.get(j);
                    phones.set(j, phones.get(j + 1));
                    phones.set(j + 1, temp);
                }
            }
        }
    }
}