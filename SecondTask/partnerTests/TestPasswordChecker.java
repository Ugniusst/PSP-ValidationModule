import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPasswordChecker {

    PasswordChecker passwordChecker = new PasswordChecker();

    @Test
    void testPasswordNotNull() {
        //should return true, because password is not null
        assertTrue(passwordChecker.checkPasswordNotNull("AbCdEf.78"));
        //should return false, because password is null
        assertFalse(passwordChecker.checkPasswordNotNull(null));
    }

    @Test
    void testPasswordLength() {
        //should return true, because password length is more than 8
        assertTrue(passwordChecker.passwordLengthCheck("AbCdEf.78", 8));
        //should return false, because password length is less than 8
        assertFalse(passwordChecker.passwordLengthCheck("AbCd78", 8));
    }

    @Test
    void testPasswordForUppercaseLetter() {
        //should return true, because password has an uppercase Letter
        assertTrue(passwordChecker.passwordCheckForUppercaseLetter("AbCdEf.78"));
        //should return false, because password doesn't have an uppercase letter
        assertFalse(passwordChecker.passwordCheckForUppercaseLetter("abcdef78"));
    }

    @Test
    void testPasswordForSpecialSymbol() {
        //should return true, because password has a valid special symbol
        assertTrue(passwordChecker.checkPasswordForSpecialSymbols("AbCdEf.78"));
        //should return false, because password doesn't have a special symbol
        assertFalse(passwordChecker.checkPasswordForSpecialSymbols("AbCdEf78"));
        //should return false, because password has an invalid special symbol
        assertFalse(passwordChecker.checkPasswordForSpecialSymbols("AbCdEf%78"));
    }
}
