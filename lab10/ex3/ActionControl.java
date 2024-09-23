import java.util.*;

@SuppressWarnings("unchecked")
public class ActionControl<T> {
    private Command command;

    public void setControl(Command command){
        this.command = command;
    }

    public boolean execute (T element) {
        return command.execute(element);
    }

    public boolean undo () {
        return command.undo();
    }
}