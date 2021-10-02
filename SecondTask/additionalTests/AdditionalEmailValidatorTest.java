import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdditionalEmailValidatorTest {
    EmailValidator emailValidator;

    @BeforeEach
    void setup() {
        emailValidator = new EmailValidator();
    }

    @Test
    void emailEtaTest_emailStartsWithTest() {
        assertFalse(emailValidator.validateEmail("@gmail.com"));
    }
    @Test
    void emailEtaTest_fewEtasInTest() {
        assertFalse(emailValidator.validateEmail("vardenis@pavardenis@gmail.com"));
    }
    @Test
    void emailInvalidSymbolsTest_startsWithSymbol() {
        assertFalse(emailValidator.validateEmail(".vardenispavardenis@gmail.com"));
    }
    @Test
    void emailInvalidSymbolsTest_doubleSymbolInTest() {
        assertFalse(emailValidator.validateEmail("vardenis..pavardenis@gmail.com"));
    }
    @Test
    void emailDomainTest_noDomainsInTest() {
        assertFalse(emailValidator.validateEmail("vardenispavardenis@com"));
    }
    @Test
    void emailDomainTest_emailDomainStartsWithDot() {
        assertFalse(emailValidator.validateEmail("vardenis@.gmail.com"));
    }
    @Test
    void emailDomainTest_emailHasDomainWithSubdomains() {
        assertTrue(emailValidator.validateEmail("vardenis@mif.stud.lt"));
    }


    @AfterEach
    void tearDown() {

    }
}