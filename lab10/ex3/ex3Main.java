import java.util.*;

@SuppressWarnings("unchecked")
public class ex3Main {
    public static void main(String[] args){

        ActionControl action = new ActionControl();
        Collection collection = new ArrayList<>();

        Command add = new AddCommand(collection);
        Command remove = new RemoveCommand(collection);

        action.setControl(add);
        action.execute("Carolina");
        action.execute("Joao");
        action.execute("PDS");
        System.out.println(collection);

        action.undo();
        System.out.println(collection);


        action.setControl(remove);
        action.execute("Joao");
        System.out.println(collection);

        action.undo();
        System.out.println(collection);

        action.setControl(add);
        action.execute("computador");
        action.execute("telemovel");

        System.out.println(collection);

    }
}