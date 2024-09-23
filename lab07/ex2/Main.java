import java.io.*;

public class Main {

    public static void main(String[] args) {

        try {
            File file = new File("friendList.txt"); // Changed file name
            file.createNewFile();
            FileWriter myWriter = new FileWriter(file.toString());
            myWriter.write("Alice\t944556677\n");  // New contact name and number
            myWriter.write("Bob\t922334411\n");    // New contact name and number
            myWriter.write("Charlie\t977788899\n");// New contact name and number
            myWriter.write("Diana\t988776655\n");  // New contact name and number
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        ContactsStorageText contacts = new ContactsStorageText("friendList.txt"); // Changed reference to the new file name

        Bridge contactList = new Bridge();

        contactList.openAndLoad(contacts);

        Contact c1 = new Contact("Ethan", 933339999);
        contactList.add(c1);
        contactList.add(new Contact("Fiona", 944448888));

        contactList.remove(c1);
        contactList.remove(contactList.getByName("Charlie")); // Updated contact name

        System.out.println("Is Bob in Contacts?   " + contactList.exist(contactList.getByName("Bob"))); // Updated contact name
        System.out.println("Is Fiona in Contacts?   " + contactList.exist(c1));

        contactList.saveAndClose();

        try {
            File file2 = new File("newFriendList.txt"); // Changed file name
            file2.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        ContactStorageBinary contacts2 = new ContactStorageBinary("newFriendList.txt"); // Changed reference to the new file name

        contactList.saveAndClose(contacts2);


        Bridge contactApi2 = new Bridge();


        contactApi2.openAndLoad(contacts2);

        StorageCSV contacts3 = new StorageCSV("friendList.csv"); // Changed reference to the new file name

        contactApi2.saveAndClose(contacts3);

        contactApi2.openAndLoad(contacts3);



        


    }
}
