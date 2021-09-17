import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidationTest {

    PasswordValidator passwordValidator;
    @BeforeEach
    void setup(){
        passwordValidator = new PasswordValidator();
    }

    @Test
    void passwordLengthTest_ValidLengthPassword() {
        assertTrue(passwordValidator.checkLength("AuksinisKardas123", 8));
    }
    @Test
    void passwordLengthTest_TooShortPassword() {
        assertFalse(passwordValidator.checkLength("abc123", 8));
    }
    @Test
    void passwordUpperCaseTest_NoUpperCase() {
        assertFalse(passwordValidator.checkUpperCases("abc123asdaa", 1));
    }
    @Test
    void passwordUpperCaseTest_LessThanMinimumUpperCases() {
        assertFalse(passwordValidator.checkUpperCases("Abc123asdaa", 2));
    }
    @Test
    void passwordUpperCaseTest_EnoughUpperCases() {
        assertTrue(passwordValidator.checkUpperCases("Abc123asDaa", 2));
    }
    @Test
    void passwordSpecialCharsTest_NoSpecialChar(){
        assertFalse(passwordValidator.checkSpecialChars("Abcdfg123",  1));
    }
    @Test
    void passwordSpecialCharsTest_LessThanMinimumSpecialChars(){
        assertFalse(passwordValidator.checkSpecialChars("Abcdfg123!",  2));
    }
    @Test
    void passwordSpecialCharsTest_EnoughSpecialChars(){
        assertTrue(passwordValidator.checkSpecialChars("!Abcdfg123?",  2));
    }

    @AfterEach
    void tearDown(){

    }
}
