import java.util.ArrayList;

public class PhoneValidator {

    private ArrayList<ValidationPhoneRule> validationPhoneRules = new ArrayList<>();

    public PhoneValidator(){
        addValidationPhoneRule("LT", "+370", 12);
        addValidationPhoneRule("FR", "+33", 13);
    }
    public String changeThePrefix(String phoneNumber) {
        char[] phoneNumberSequence = phoneNumber.toCharArray();
        char[] phoneNumberWithPrefix;
        char[] prefix = new char[]{'+', '3', '7', '0'};
        if(phoneNumberSequence[0] == '8') {
            phoneNumberWithPrefix = new char[13];
            for(int i=0; i<prefix.length; i++) {
                phoneNumberWithPrefix[i] = prefix[i];
            }
            for(int i=1; i<phoneNumberSequence.length; i++) {
                phoneNumberWithPrefix[3+i] = phoneNumberSequence[i];
            }
        }
        else {
            phoneNumberWithPrefix = phoneNumberSequence;
        }
        return String.valueOf(phoneNumberWithPrefix);
    }

    public boolean checkIfStartsWithCountryCode(String phoneNumber) {
        char[] phoneNumberSequence = phoneNumber.toCharArray();
        if(phoneNumberSequence[0] == '+') {
            return true;
        }
        return false;
    }

    public boolean checkIfCountryIsValid(String countryCode, String phoneNumber) {
        for(ValidationPhoneRule validationPhoneRule : validationPhoneRules) {
            if(countryCode.equals(validationPhoneRule.countryCode)) {
                char[] phoneNumberSequence = phoneNumber.toCharArray();
                char[] prefix = validationPhoneRule.countryPhonePrefix.toCharArray();
                for(int i=0; i<prefix.length; i++) {
                    if(phoneNumberSequence[i]!=prefix[i]) {
                        return false;
                    }
                }
                if (phoneNumberSequence.length == validationPhoneRule.phoneNumberLength) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }
    public void addValidationPhoneRule(String countryCode, String countryPhonePrefix, int phoneNumberLength) {
        validationPhoneRules.add(new ValidationPhoneRule(countryCode, countryPhonePrefix, phoneNumberLength));
    }

    public boolean checkPhoneNotNull(String phoneNumber) {
        return (phoneNumber != null);
    }

    public boolean checkPhoneOnlyNumbers(String phoneNumber) {
        char[] phoneNumberSequence = phoneNumber.toCharArray();
        for(char symbol : phoneNumberSequence) {
            if(symbol < 48 || symbol > 57) {
                return false;
            }
        }
        return true;
    }
}
