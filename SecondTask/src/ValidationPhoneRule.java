/**
 * ValidationPhoneRule class that describes country's phone number's rule by describing
 * country code, country's phone prefix, length of number
 */
public class ValidationPhoneRule {
    public String countryCode;
    public String countryPhonePrefix;
    public int phoneNumberLength;

    /**
     * class constructor
     *
     * @param countryCode - text of shortened country code
     * @param countryPhonePrefix - text of phone prefix, starting with sign "+"
     * @param phoneNumberLength - number of allowed characters in phone number
     */
    public ValidationPhoneRule(String countryCode, String countryPhonePrefix, int phoneNumberLength) {
        this.countryCode = countryCode;
        this.countryPhonePrefix = countryPhonePrefix;
        this.phoneNumberLength = phoneNumberLength;
    }
}
