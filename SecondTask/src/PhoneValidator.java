import java.util.ArrayList;

public class PhoneValidator {

    private ArrayList<ValidationPhoneRule> validationPhoneRules = new ArrayList<>();

    public PhoneValidator(){
        addValidationPhoneRule("LT", "+370", 12);
        addValidationPhoneRule("LV", "+371", 12);
        addValidationPhoneRule("EST", "+372", 12);
        addValidationPhoneRule("FR", "+33", 13);
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        if(!checkPhoneNotNull(phoneNumber)) {
            return false;
        }
        if(!checkPhoneOnlyNumbers(phoneNumber)) {
            return false;
        }
        changeThePrefix(phoneNumber);
        if(!checkIfStartsWithCountryCode(phoneNumber)) {
            return false;
        }
        if(!checkIfCountryIsValid("LT", phoneNumber)) {
            return false;
        }
        return true;
    }
    public boolean validatePhoneNumber(String phoneNumber, String countryCode) {
        if(!checkPhoneNotNull(phoneNumber)) {
            return false;
        }
        if(!checkPhoneOnlyNumbers(phoneNumber)) {
            return false;
        }
        if(!checkIfStartsWithCountryCode(phoneNumber)) {
            return false;
        }
        if(!checkIfCountryIsValid(countryCode, phoneNumber)) {
            return false;
        }
        return true;
    }

    public String changeThePrefix(String phoneNumber) {
        char[] phoneNumberSequence = phoneNumber.toCharArray();
        String prefix = "+370";
        if(phoneNumberSequence[0] == '8') {
            phoneNumber = phoneNumber.substring(1);
            phoneNumber = prefix + phoneNumber;
        }
        return phoneNumber;
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
        if(phoneNumberSequence[0] == '+') {
            phoneNumberSequence[0] = '0';
        }
        for(char symbol : phoneNumberSequence) {
            if(symbol < 48 || symbol > 57) {
                return false;
            }
        }
        return true;
    }
}
