public class ValidationPhoneRule {
    public String countryCode;
    public String countryPhonePrefix;
    public int phoneNumberLength;

    public ValidationPhoneRule(String countryCode, String countryPhonePrefix, int phoneNumberLength) {
        this.countryCode = countryCode;
        this.countryPhonePrefix = countryPhonePrefix;
        this.phoneNumberLength = phoneNumberLength;
    }
}
