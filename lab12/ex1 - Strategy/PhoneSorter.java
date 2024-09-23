public class PhoneSorter {
    private SortingMethod sortingMethod;

    public PhoneSorter(SortingMethod sortingMethod) {
        this.sortingMethod = sortingMethod;
    }

    public void sort() {
        sortingMethod.sort();
    }

    public void printSorted() {
        sortingMethod.printSorted();
    }

    public void orderAscending() {
        sortingMethod.orderAscending();
    }

    public void orderDescending() {
        sortingMethod.orderDescending();
    }

    public void setSortingMethod(SortingMethod sortingMethod) {
        this.sortingMethod = sortingMethod;
    }


    
}
