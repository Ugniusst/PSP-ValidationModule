import java.util.ArrayList;

public class EmailValidator {
    private ArrayList<String> validTopLevelDomains = new ArrayList<>();

    public EmailValidator(){
        String[] defaultDomains = new String[]{"lt", "com", "ru", "org", "fr"};
        for(String domain : defaultDomains) {
            validTopLevelDomains.add(domain);
        }
    }
    public EmailValidator(String[] validTopLevelDomains){
        for(String domain : validTopLevelDomains) {
            this.validTopLevelDomains.add(domain);
        }
    }

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

    public boolean checkEmailNotNull(String email) {
        return (email != null);
    }

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
