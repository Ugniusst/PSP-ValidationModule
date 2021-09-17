import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailValidationTest {

    EmailValidator emailValidator;
    @BeforeEach
    void setup(){
        emailValidator = new EmailValidator();
    }

    @Test
    void emailEtaTest_NoEtaSign() {
        assertFalse(emailValidator.checkEtaSign("vardenis.pavardenisgmail.com"));
    }
    @Test
    void emailEtaTest_MoreEtaSigns() {
        assertFalse(emailValidator.checkEtaSign("vardenis.pav@ardenis@gmail.com"));
    }
    @Test
    void emailEtaTest_ValidEtaSign() {
        assertTrue(emailValidator.checkEtaSign("vardenis.pavardenis@gmail.com"));
    }
    @Test
    void emailCharactersTest_InvalidCharacters() {
        assertFalse(emailValidator.checkCharacters("vardenis!.pavardenis?@gmail.com"));
    }
    @Test
    void emailCharactersTest_ValidCharacters() {
        assertTrue(emailValidator.checkCharacters("vardenis.pavardenis@gmail.com"));
    }
    @Test
    void emailDomainTest_InvalidDomain(){
        assertFalse(emailValidator.checkDomain("vardenis.pavardenis@gggmail.com"));
    }
    @Test
    void emailDomainTest_InvalidTopLevelDomain(){
        assertFalse(emailValidator.checkDomain("vardenis.pavardenis@gmail.commm"));
    }
    @Test
    void emailDomainTest_ValidDomain(){
        assertTrue(emailValidator.checkDomain("vardenis.pavardenis@gmail.com"));
    }

    @AfterEach
    void tearDown(){

    }
}
