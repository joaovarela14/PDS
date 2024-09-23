import java.util.ArrayList;
import java.util.List;


public class Bridge implements ContactsInterface{
     protected List<Contact> contacts;
     protected ContactsStorageInterface storage;

     public Bridge(){
          this.contacts=new ArrayList<Contact>();
          
     }

     @Override
     public void openAndLoad(ContactsStorageInterface store) {
          this.storage = store;
          this.contacts.addAll(storage.loadContacts());

          System.out.println("Loaded Contacts:");

          for (Contact contact : contacts) {
                System.out.println(contact);
            }
     }

     @Override
     public void saveAndClose() {
          boolean stored = this.storage.saveContacts(this.contacts);

          if (stored == true) {
               System.out.println("Success! Contacts stored!");
          } else {
               System.out.println("Error! Contacts not stored!");
          }
     }

     @Override
     public void saveAndClose(ContactsStorageInterface store) {
          boolean stored = store.saveContacts(this.contacts);

          if (stored == true) {
               System.out.println("Success! Contacts stored!");
          } else {
               System.out.println("Error! Contacts not stored!");
          }
     }

     @Override
     public boolean exist(Contact contact) {
          for (Contact c : this.contacts) {

               if (c.toString().equals(contact.toString())) {
                   return true;
               }

           }
           return false;
     }

     @Override
     public Contact getByName(String name) {
          for (Contact c : this.contacts) {

               if (c.getName().equals(name)) {
                   return c;
               }
           }
           System.out.println("Contact not found!");
           return null;
     }

     @Override
     public boolean add(Contact contact) {
          return this.contacts.add(contact);
     }

     @Override
     public boolean remove(Contact contact) {
          return this.contacts.remove(contact);
     }
     
     
     
}