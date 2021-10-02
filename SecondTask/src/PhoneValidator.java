import java.util.ArrayList;

/**
 *  PhoneValidator class checks if phone number is correct
 */
public class PhoneValidator {

    private ArrayList<ValidationPhoneRule> validationPhoneRules = new ArrayList<>();

    /**
     * Class constructor that adds default countries for validation rules:
     * LT (+370), LV (+371), EST (+372), FR (+33)
     */
    public PhoneValidator(){
        addValidationPhoneRule("LT", "+370", 12);
        addValidationPhoneRule("LV", "+371", 12);
        addValidationPhoneRule("EST", "+372", 12);
        addValidationPhoneRule("FR", "+33", 13);
    }

    /**
     * checks if local (lithuanian) phone number is correct.
     * Check numbers, length, prefix (if number is local, adds the prefix "+370")
     *
     * @param phoneNumber  - the text of local (lithuanian) phone number
     */
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
    /**
     * checks if  phone number is correct.
     * Check numbers, length, prefix, country code and if the country is registered as valid rule
     *
     * @param phoneNumber  - the text of phone number with country's prefix
     * @param countryCode - short code of registered country as valid rule
     */
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

    /**
     * returns a phone number with lithuanian prefix. If the number is already with
     * prefix, returns the given phone number
     *
     * @param phoneNumber - the text of lithuanian phone number, local or with prefix
     * @return phone number with prefix
     */
    public String changeThePrefix(String phoneNumber) {
        char[] phoneNumberSequence = phoneNumber.toCharArray();
        String prefix = "+370";
        if(phoneNumberSequence[0] == '8') {
            phoneNumber = phoneNumber.substring(1);
            phoneNumber = prefix + phoneNumber;
        }
        return phoneNumber;
    }

    /**
     * checks if the given phone number starts with country prefix (has a + sign)
     *
     * @param phoneNumber - the text of phone number
     * @return true if phone number starts with +, otherwise false
     */
    public boolean checkIfStartsWithCountryCode(String phoneNumber) {
        char[] phoneNumberSequence = phoneNumber.toCharArray();
        if(phoneNumberSequence[0] == '+') {
            return true;
        }
        return false;
    }

    /**
     * checks if given country code is registered as valid validation rule and if the number
     * is correct for that country's rule
     *
     * @param countryCode - text of shortened country code
     * @param phoneNumber - text of phone number
     * @return true if country code and phone number are correct for registered rule
     */
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

    /**
     * adds a validation rule that can be used to validate a new phone number with
     * different phone prefix and length
     *
     * @param countryCode - text of shortened country code
     * @param countryPhonePrefix - text of country's phone prefix that starts with +
     * @param phoneNumberLength - integer of phone number's length
     */
    public void addValidationPhoneRule(String countryCode, String countryPhonePrefix, int phoneNumberLength) {
        validationPhoneRules.add(new ValidationPhoneRule(countryCode, countryPhonePrefix, phoneNumberLength));
    }

    /**
     * checks if given phone number is not null
     *
     * @param phoneNumber - text of given phone number
     * @return true if phone number is not null and false if phone number is null
     */
    public boolean checkPhoneNotNull(String phoneNumber) {
        return (phoneNumber != null);
    }

    /**
     * checks if phone number is made from only numbers and possible '+' sign in front
     *
     * @param phoneNumber - text of phone number
     * @return true if phone number is only from numbers and possible + in front, false if there are illegal signs
     */
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
