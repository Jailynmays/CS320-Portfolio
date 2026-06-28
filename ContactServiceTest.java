import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Jailyn", "Mays", "4145551234", "123 Main Street");

        service.addContact(contact);

        assertEquals(contact, service.getContact("12345"));
    }

    @Test
    public void testAddDuplicateContactIDThrowsException() {
        ContactService service = new ContactService();
        Contact contactOne = new Contact("12345", "Jailyn", "Mays", "4145551234", "123 Main Street");
        Contact contactTwo = new Contact("12345", "Alex", "Smith", "4145555678", "456 Oak Street");

        service.addContact(contactOne);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contactTwo);
        });
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Jailyn", "Mays", "4145551234", "123 Main Street");

        service.addContact(contact);
        service.deleteContact("12345");

        assertThrows(IllegalArgumentException.class, () -> {
            service.getContact("12345");
        });
    }

    @Test
    public void testDeleteContactThatDoesNotExistThrowsException() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("12345");
        });
    }

    @Test
    public void testUpdateFirstName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Jailyn", "Mays", "4145551234", "123 Main Street");

        service.addContact(contact);
        service.updateFirstName("12345", "Jay");

        assertEquals("Jay", service.getContact("12345").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Jailyn", "Mays", "4145551234", "123 Main Street");

        service.addContact(contact);
        service.updateLastName("12345", "Brown");

        assertEquals("Brown", service.getContact("12345").getLastName());
    }

    @Test
    public void testUpdatePhone() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Jailyn", "Mays", "4145551234", "123 Main Street");

        service.addContact(contact);
        service.updatePhone("12345", "4145559999");

        assertEquals("4145559999", service.getContact("12345").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Jailyn", "Mays", "4145551234", "123 Main Street");

        service.addContact(contact);
        service.updateAddress("12345", "456 Oak Street");

        assertEquals("456 Oak Street", service.getContact("12345").getAddress());
    }

    @Test
    public void testUpdateContactThatDoesNotExistThrowsException() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("12345", "Jay");
        });
    }
}
