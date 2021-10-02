import java.util.ArrayList;

/**
 * EmailValidator class check if email is correct
 */
public class EmailValidator {
    private ArrayList<String> validTopLevelDomains = new ArrayList<>();

    /**
     * class constructor that creates a default list of valid top-level-domains:
     *  "ru", "com", "org", "lt", "fr
     */
    public EmailValidator(){
        String[] defaultDomains = new String[]{"lt", "com", "ru", "org", "fr"};
        for(String domain : defaultDomains) {
            validTopLevelDomains.add(domain);
        }
    }

    /**
     * class constructor that creates a list of given valid top-level-domains.
     *
     * @param validTopLevelDomains - list of valid TLD texts
     */
    public EmailValidator(String[] validTopLevelDomains){
        for(String domain : validTopLevelDomains) {
            this.validTopLevelDomains.add(domain);
        }
    }

    /**
     * checks if email is correct according to all rules: not null, has eta sign, doesn't contain
     * invalid signs and TLD is registered and valid
     *
     * @param email - text of email
     * @return true if email is correct to all the rules, false otherwise
     */
    public boolean validateEmail(String email) {
        if(!checkEmailNotNull(email)) {
            return false;
        }
        if(!checkIfEmailHasEta(email)) {
            return false;
        }
        if(!checkIfEmailDoesntContainInvalidSymbols(email)) {
            return false;
        }
        if(!checkIfEmailDomainValid(email)) {
            return false;
        }
        return true;
    }

    /**
     * checks if given email is not null
     *
     * @param email - text of email
     * @return true if email is not null and false if email is null
     */
    public boolean checkEmailNotNull(String email) {
        return (email != null);
    }

    /**
     * checks if given email has only one eta sign
     *
     * @param email - text of email
     * @return true if email has only one eta sign, false if email has no eta signs or more than one
     */
    public boolean checkIfEmailHasEta(String email) {
        char[] emailSequence = email.toCharArray();
        int etaCounter = 0;
        for(char symbol : emailSequence) {
            if(symbol == '@') {
                etaCounter++;
            }
        }
        if(etaCounter == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * checks if email doesn't contain invalid symbols. Valid symbols are latin letters
     * A-Z, a-z, eta sign @, numbers 0-9, and symbols ".", "-", "_".
     *
     * @param email - text of email
     * @return true if email doesn't contain invalid symbols, false otherwise
     */
    public boolean checkIfEmailDoesntContainInvalidSymbols(String email) {
        char[] emailSequence = email.toCharArray();
        char previousSymbol = ' ';
        if(emailSequence[0] == '.' || emailSequence[0] == '@') {
            return false;
        }
        for(char symbol : emailSequence) {
            // 48-57 : numbers, 64-90: @ and A-Z letters,  97-122: a-z letters
            if(!((symbol >= 48 && symbol <= 57) || (symbol >= 60 && symbol <= 90) || (symbol >= 97 && symbol <= 122))) {
                if(symbol != '.' && symbol != '-' && symbol != '_') {
                    return false;
                }
                else if(symbol == previousSymbol) {
                    return false;
                }
            }
            previousSymbol = symbol;

        }
        return true;
    }

    /**
     * checks if domains are valid: doesn't start with symbol ".", a top-level-domain
     * is valid and registered in valid TLD list.
     *
     * @param email - text of email
     * @return true if domains are valid, false otherwise
     */
    public boolean checkIfEmailDomainValid(String email) {
        String domainPart = (email.split("@"))[1];
        if(domainPart.toCharArray()[0] == '.'){
            return false;
        }
        String[] domains = domainPart.split("\\.");
        if(domains.length < 2) {
            return false;
        }

        for(String validDomain : validTopLevelDomains) {
            if (domains[domains.length - 1].equals(validDomain)) {
                return true;
            }
        }
        return false;
    }
}
