import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactCreatedSuccessfully() {
        Contact contact = new Contact("1234567890", "Jailyn", "Mays", "4145551234", "123 Main Street");

        assertEquals("1234567890", contact.getContactID());
        assertEquals("Jailyn", contact.getFirstName());
        assertEquals("Mays", contact.getLastName());
        assertEquals("4145551234", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    public void testContactIDCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Jailyn", "Mays", "4145551234", "123 Main Street");
        });
    }

    @Test
    public void testContactIDCannotBeLongerThanTenCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Jailyn", "Mays", "4145551234", "123 Main Street");
        });
    }

    @Test
    public void testFirstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Mays", "4145551234", "123 Main Street");
        });
    }

    @Test
    public void testFirstNameCannotBeLongerThanTenCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "JailynMayss", "Mays", "4145551234", "123 Main Street");
        });
    }

    @Test
    public void testLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Jailyn", null, "4145551234", "123 Main Street");
        });
    }

    @Test
    public void testLastNameCannotBeLongerThanTenCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Jailyn", "LongLastName", "4145551234", "123 Main Street");
        });
    }

    @Test
    public void testPhoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Jailyn", "Mays", null, "123 Main Street");
        });
    }

    @Test
    public void testPhoneMustBeExactlyTenDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Jailyn", "Mays", "414555123", "123 Main Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Jailyn", "Mays", "41455512345", "123 Main Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Jailyn", "Mays", "41455abcde", "123 Main Street");
        });
    }

    @Test
    public void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Jailyn", "Mays", "4145551234", null);
        });
    }

    @Test
    public void testAddressCannotBeLongerThanThirtyCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Jailyn", "Mays", "4145551234", "123 Main Street Apartment 5000");
        });
    }
}
