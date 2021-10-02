import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPhoneValidator {

    PhoneValidator phoneValidator = new PhoneValidator();

    @Test
    void testPhoneNotNull() {
        //should return true, because phone number is not null
        assertTrue(phoneValidator.checkPhoneNotNull("861234567"));
        //should return false, because phone number is null
        assertFalse(phoneValidator.checkPhoneNotNull(null));
    }

    @Test
    void testPhoneOnlyNumbers() {
        //should return true, because all the chars are numbers
        assertTrue(phoneValidator.checkPhoneOnlyNumbers("861234567"));
        //should return false, because there are other symbols
        assertFalse(phoneValidator.checkPhoneOnlyNumbers("861a34567"));
    }

    @Test
    void testChangeThePrefix() {
        //should return true if prefix is succesfully changed to +370, false if not
        assertTrue(phoneValidator.checkIfStartsWithCountryCode(phoneValidator.changeThePrefix("861234567")));
    }

    @Test
    void testCountryIsValid () {
        //should return true if the input country is valid, false if not
        assertTrue(phoneValidator.checkIfCountryIsValid("FR", "+331234567891"));
    }
}
