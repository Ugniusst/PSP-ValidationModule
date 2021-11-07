import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnitTest {
    /*
    @Test
    void testPWLength_true(){
        assertTrue(PasswordChecker.checkLength("password", 3, 10));
    }
    @ParameterizedTest
    @ValueSource(strings = {"","pa", "passwordpassword"})
    void testPWLenght_false(String pw){
        assertFalse(PasswordChecker.checkLength(pw, 3, 10));
    }

    @Test
    void testPWUpperCase_true(){
        assertTrue(PasswordChecker.checkUppercase("Password"));
    }
    @Test
    void testPWUpperCase_false(){
        assertFalse(PasswordChecker.checkUppercase("password"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"PASSWORD!", ">password", "pass word"})
    void testPWSpecialSymbols_true(String pw){
        assertTrue(PasswordChecker.checkSpecialSymbols(pw));
    }
    @ParameterizedTest
    @ValueSource(strings = {"password", "pass€word"})
    void testPWSpecialSymbols_false(String pw){
        assertFalse(PasswordChecker.checkSpecialSymbols(pw));
    }


    @ParameterizedTest
    @ValueSource(strings = {"+37000000000", "800000000"})
    void testPhoneOnlyNumbers_true(String number){
        assertTrue(PhoneValidator.validateNumbers(number));
    }
    @ParameterizedTest
    @ValueSource(strings = {"", "+370000000A0", "+@#$%^^$@#$%"})
    void testPhoneOnlyNumbers_false(String number){
        assertFalse(PhoneValidator.validateNumbers(number));
    }

    @Test
    void testPhonePrefix_true(){
        assertTrue(PhoneValidator.validatePrefix("LT", "800000000"));
    }
    @Test
    void testPhonePrefix_true){
        assertTrue(PhoneValidator.validatePrefix("LT", "+37000000000"));
    }
    @Test
    void testPhonePrefix_false(){
        assertFalse(PhoneValidator.validatePrefix("LT", "900000000"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"+37000000000", "900000000"})
    void testPhonePrefix_true(String number){
        assertTrue(PhoneValidator.validateLength("LT", number));
    }
    @ParameterizedTest
    @ValueSource(strings = {"", "+123", "000000000000000000"})
    void testPhoneLength_false(String number){
        assertFalse(PhoneValidator.validateLength("LT", number));
    }

    @Test
    void testEmailAtSymbol_true(){
        assertTrue(EmailValidator.validateAt("test@email.com"));
    }
    @ParameterizedTest
    @ValueSource(strings = {"", "testemail.com", " "})
    void testEmailAtSymbol_false(String email){
        assertFalse(EmailValidator.validateAt(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"TesT@email.com", "te123st@email.com", "!#$%&'*+-/=?^_`{|}~@email.com"})
    void testEmailSymbols_true(String email){
        assertTrue(EmailValidator.validateSymbols(email));
    }
    @ParameterizedTest
    @ValueSource(strings = {"фффф@email.com", "€@email.com"})
    void testEmailSymbols_false(String email){
        assertFalse(EmailValidator.validateSymbols(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test@email.com", "te.st@email.com"})
    void testEmailDotPlacement_true(String email){
        assertTrue(EmailValidator.validateSymbols(email));
    }
    @ParameterizedTest
    @ValueSource(strings = {".test@email.com", "test.@email.com", "te..st@email.com"})
    void testEmailDotPlacement_false(String email){
        assertFalse(EmailValidator.validateSymbols(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test@email.com", "test@EMAIL.COM", "test@123.info", "test@1.com"})
    void testEmailDomainName_true(){
        assertTrue(EmailValidator.validateServer("test@.com"));
    }
    @ParameterizedTest
    @ValueSource(strings = {"test@","test@#!email.com", "test@eeeeemmmmmaaaaaiiiiilllll.aaa", "test@12.com",
            "test@eeeeemmmmmaaaaaiiiiillllleeeeemmmmmaaaaaiiiiillllleeeeemmmmmaaaaaiiiiilllll.com"})
    void testEmailDomainName_false(){
        assertFalse(EmailValidator.validateServer("test@.com"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test@email.com", "test@e-mail.com"})
    void testDomainHyphenPlacement_true(String email){
        assertTrue(EmailValidator.validateSymbols(email));
    }
    @ParameterizedTest
    @ValueSource(strings = {"test@-email.com", "test@email-.com"})
    void testDomainHyphenPlacement_false(String email){
        assertFalse(EmailValidator.validateSymbols(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test@email.com", "test@email.bosch"})
    void testEmailTLD_true(String email) {
        assertTrue(EmailValidator.validateTLD(email));
    }
    @ParameterizedTest
    @ValueSource(strings = {"test@email.aaaa"})
    void testEmailTLD_false(String email){
        assertFalse(EmailValidator.validateTLD(email));
    }
     */
}
