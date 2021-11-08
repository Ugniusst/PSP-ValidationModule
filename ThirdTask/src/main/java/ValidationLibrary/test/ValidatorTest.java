import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {

    // Password requirements testing
    @Test
    public void TestPasswordLengthIsBiggerThanX(){
        PasswordChecker passwordChecker = new PasswordChecker();
        assertTrue(passwordChecker.passwordLenght("password", 7));
    }

    @Test
    public void TestPasswordHasUppercase(){
        PasswordChecker passwordChecker = new PasswordChecker();
        assertTrue(passwordChecker.hasUppercase("Password"));
    }

    @Test
    public void TestPasswordHasSpecialSymbol(){
        PasswordChecker passwordChecker= new PasswordChecker();
        assertTrue(passwordChecker.hasSpecialSymbols("P@ssword?!123$#*"));
    }

    @Test
    public void TestPhoneHasOnlyNumbers(){
        PhoneValidator phoneValidator = new PhoneValidator();
        assertTrue(phoneValidator.hasOnlyNumbers("861234567"));
    }

    @Test
    public void TestPhoneChangeToLithuanianPrefix(){
        PhoneValidator phoneValidator = new PhoneValidator();
        assertEquals("+3706123456",phoneValidator.changeToLithuanianPrefix("86123456"));
    }

    @Test
    public void TestPhoneAddNewPhoneCodesRules(){
        PhoneValidator phoneValidator = new PhoneValidator();
        phoneValidator.addNewPhoneRules("8", "lv");
        assertTrue(phoneValidator.checkPrefixWithCountry("87123456", "lv"));
    }

    // Email test requirements
    @Test
    public void TestEmailHasEtaSymbol(){
        EmailValidator emailValidator = new EmailValidator();
        assertTrue(emailValidator.hasEtaSymbol("P@ssword"));
    }

    @Test
    public void TestEmailHasOnlyRightSymbols(){
        EmailValidator emailValidator = new EmailValidator();
        assertTrue(emailValidator.hasOnlyRightSymbols("email@gmail.com"));
    }

    @Test
    public void TestEmailHasRightDomain(){
        EmailValidator emailValidator = new EmailValidator();
        assertTrue(emailValidator.hasRightDomain("email@gmail.com"));
    }
}