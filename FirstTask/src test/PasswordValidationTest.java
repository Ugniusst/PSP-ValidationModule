import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidationTest {

    PasswordChecker passwordValidator;
    @BeforeEach
    void setup(){
        passwordValidator = new PasswordChecker();
    }

    @Test
    void passwordLengthTest_ValidLengthPassword() {
        assertTrue(passwordValidator.validatePassword("AuksinisKardas123", 8));
    }
    @Test
    void passwordLengthTest_TooShortPassword() {
        assertFalse(passwordValidator.validatePassword("abc123", 8));
    }
    @Test
    void passwordUpperCaseTest_NoUpperCase() {
        assertFalse(passwordValidator.validatePassword("abc123asdaa", 8));
    }
    @Test
    void passwordUpperCaseTest_EnoughUpperCases() {
        assertTrue(passwordValidator.validatePassword("Abc123asDaa", 8));
    }
    @Test
    void passwordSpecialCharsTest_NoSpecialChar(){
        assertFalse(passwordValidator.validatePassword("Abcdfg123",  8));
    }
    @Test
    void passwordSpecialCharsTest_EnoughSpecialChars(){
        assertTrue(passwordValidator.validatePassword("!Abcdfg123?",  8));
    }

    @AfterEach
    void tearDown(){

    }
}
