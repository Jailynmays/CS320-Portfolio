import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact ID must be unique");
        }
        contacts.put(contact.getContactID(), contact);
    }

    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contacts.remove(contactID);
    }

    public void updateFirstName(String contactID, String firstName) {
        getContact(contactID).setFirstName(firstName);
    }

    public void updateLastName(String contactID, String lastName) {
        getContact(contactID).setLastName(lastName);
    }

    public void updatePhone(String contactID, String phone) {
        getContact(contactID).setPhone(phone);
    }

    public void updateAddress(String contactID, String address) {
        getContact(contactID).setAddress(address);
    }

    public Contact getContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        return contacts.get(contactID);
    }
}
