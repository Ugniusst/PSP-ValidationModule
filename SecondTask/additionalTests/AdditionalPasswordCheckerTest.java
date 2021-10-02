import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdditionalPasswordCheckerTest {
    PasswordChecker passwordChecker;

    @BeforeEach
    void setup() {
        passwordChecker = new PasswordChecker();
    }

    @Test
    void passwordLengthCheck_PasswordLengthIsMinimum() {
        assertTrue(passwordChecker.validatePassword("A.345678",8));
    }
    @Test
    void passwordSpecialSymbolCheck_PasswordHasValidAndInvalidSymbols() {
        assertFalse(passwordChecker.validatePassword("A.34567%9",8));
    }


    @AfterEach
    void tearDown() {

    }
}
