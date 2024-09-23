import java.util.*;

abstract class SortingMethod {
    protected List<Phone> phones;
    protected Comparator<Phone> comparator;

    public SortingMethod(List<Phone> phones, Comparator<Phone> comparator){
        this.phones = phones;
        this.comparator = comparator;
    }

    public void printSorted(){
        for(Phone phone : phones){
            System.out.println(phone);
        }
    }


    public abstract void sort();


    public void orderAscending(){
        phones.sort(comparator);
    }

    public void orderDescending(){
        phones.sort(comparator.reversed());

    }

   
}