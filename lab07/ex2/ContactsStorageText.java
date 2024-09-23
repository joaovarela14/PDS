import java.util.*;
import java.io.*;

public class ContactsStorageText implements ContactsStorageInterface{

    private String fname;

    public ContactsStorageText(String fname){
        this.fname = fname;
    }

    @Override
    public List<Contact> loadContacts() {
        List<Contact> contacts = new ArrayList<>();
        try {
            File file = new File(fname);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\t");
                contacts.add(new Contact(parts[0], Integer.parseInt(parts[1])));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    @Override
    public boolean saveContacts(List<Contact> list) {
        try {
            FileWriter writer = new FileWriter(fname);
            for (Contact contact : list) {
                writer.write(contact.getName() + "\t" + contact.getNumber() + "\n");
            }
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
