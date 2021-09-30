import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestEmailValidator {

    EmailValidator emailValidator = new EmailValidator;

    @Test
    void testEmailNotNull() {
        //should return true, because email is not null
        assertTrue(emailValidator.checkEmailNotNull("abcdefg@abc.lt"));
        //should return false, because email is null
        assertFalse(emailValidator.checkEmailNotNull(null));
    }

    @Test
    void testIfEmailHasEta () {
        //should return true, because email has @
        assertTrue(emailValidator.checkIfEmailHasEta("abcdefg@abc.lt"));
        //should return false, because email doesn't have @
        assertFalse(emailValidator.checkIfEmailHasEta("abcdefg.abc.lt"));
    }

    @Test
    void testIfEmailDoesntContainInvalidSymbols () {
        //should return true, because email doesn't have any invalid symbols
        assertTrue(emailValidator.checkIfEmailDoesntContainInvalidSymbols("abcdefg@abc.lt"));
        //should return false, because email has invalid symbols
        assertFalse(emailValidator.checkIfEmailDoesntContainInvalidSymbols("abc^efg@abc.lt"));
    }

    @Test
    void testIfEmailDomainValid () {
        //should return true, because email domain is valid
        assertTrue(emailValidator.checkIfEmailDomainValid("abcdefg@abc.lt"));
        //should return false, because email domain is invalid
        assertFalse(emailValidator.checkIfEmailDomainValid("abcdefg@abc.ii"));
        //should return false, because email domain is empty
        assertFalse(emailValidator.checkIfEmailDomainValid("abcdefg@abc."));
    }
}
