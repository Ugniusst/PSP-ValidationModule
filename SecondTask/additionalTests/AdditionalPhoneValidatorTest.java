import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdditionalPhoneValidatorTest {
    PhoneValidator phoneValidator;

    @BeforeEach
    void setup() {
        phoneValidator = new PhoneValidator();
    }

    @Test
    void phoneNumberCheck_OnlyNumbersWithCountryPrefix() {
        assertTrue(phoneValidator.validatePhoneNumber("+37060044456"));
    }
    @Test
    void phoneNumberPrefixChangeCheck_LocalWithoutPrefix() {
        assertEquals("+37060044456",phoneValidator.changeThePrefix("860044456"));
    }
    @Test
    void phoneNumberPrefixChangeCheck_LocalWithPrefix() {
        assertEquals("+37060044456",phoneValidator.changeThePrefix("+37060044456"));
    }
    @Test
    void countryPhoneCheck_UnregisteredCountry() {
        assertFalse(phoneValidator.validatePhoneNumber("EN", "+441234567891"));
    }
    @Test
    void countryPhoneCheck_RegisteredCountryWithShortNumber() {
        assertFalse(phoneValidator.checkIfCountryIsValid("FR", "+33167891"));
    }
    @Test
    void localPhoneCheck_LocalNumberTooShort() {
        assertFalse(phoneValidator.validatePhoneNumber("86004"));
    }


    @AfterEach
    void tearDown() {

    }
}
