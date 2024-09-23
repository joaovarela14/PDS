import java.util.*;

class MergeSort extends SortingMethod {

    public MergeSort(List<Phone> phones, Comparator<Phone> comparator) {
        super(phones, comparator);
    }

    @Override
    public void sort() {
        if (phones.size() > 1) {
            List<Phone> left = new ArrayList<>(phones.subList(0, phones.size() / 2));
            List<Phone> right = new ArrayList<>(phones.subList(phones.size() / 2, phones.size()));

            MergeSort leftSorter = new MergeSort(left, comparator);
            MergeSort rightSorter = new MergeSort(right, comparator);
            leftSorter.sort();
            rightSorter.sort();
            merge(left, right);
        }
    }

    private void merge(List<Phone> left, List<Phone> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (comparator.compare(left.get(i), right.get(j)) <= 0) {
                phones.set(k++, left.get(i++));
            } else {
                phones.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) {
            phones.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            phones.set(k++, right.get(j++));
        }
    }
}