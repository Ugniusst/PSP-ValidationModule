/**
 * PasswordChecker class checks if password is correct
 */
public class PasswordChecker {

    private char[] specialSymbolsSequence;

    /**
     * class constructor, that creates default valid special symbols: ;<>{}[]+=?&,:'`.
     */
    public PasswordChecker() {
        specialSymbolsSequence = ";<>{}[]+=?&,:'`.".toCharArray();
    }

    /**
     * class constructor, that creates valid special symbols according to given list
     *
     * @param validSpecialSymbols - a text of valid special symbols, usable in password
     */
    public PasswordChecker(String validSpecialSymbols) {
        specialSymbolsSequence = validSpecialSymbols.toCharArray();
    }

    /**
     * checks if password is correct according to all rules: password is not null
     * password is not too short, has an uppercase letter and valid special symbol
     *
     * @param password - text of password that is checked
     * @param minimumLength - number of minimum symbols in password
     * @return true if password is valid with all rules.4, false if not
     */
    public boolean validatePassword(String password, int minimumLength) {
        if(!checkPasswordNotNull(password)) {
            return false;
        }
        if(!passwordLengthCheck(password, minimumLength)) {
            return false;
        }
        if(!passwordCheckForUppercaseLetter(password)) {
            return false;
        }
        if(!checkPasswordForSpecialSymbols(password)) {
            return false;
        }
        return true;
    }

    /**
     * checks if given password is not null
     * @param password - text of password
     * @return true if password is not null, false if password is null
     */
    public boolean checkPasswordNotNull(String password) {
        return (password != null);
    }

    /**
     * checks if password is at least minimum length or more
     *
     * @param password - text of password
     * @param minimumLength - number of minimum number of characters in password
     * @return true if there is at least minimum number of characters or more, false otherwise
     */
    public boolean passwordLengthCheck(String password, int minimumLength) {
        if(password.length() >= minimumLength) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * checks if password has at least one uppercase letter
     *
     * @param password - text of password
     * @return true if there is at least one upper case letter A-Z
     */
    public boolean passwordCheckForUppercaseLetter(String password) {
        char[] passwordSequence = password.toCharArray();
        for(char symbol : passwordSequence){
            if( symbol >= 65 && symbol <= 90) {
                return true;
            }
        }
        return false;
    }

    /**
     * checks if password has at least one special symbols and if symbols are valid
     *
     * @param password - text of password
     * @return true if there is at least one valid special symbols and no invalid symbols, otherwise false
     */
    public boolean checkPasswordForSpecialSymbols(String password) {
        char[] passwordSequence = password.toCharArray();
        int specialSignCounter = 0;
        for(char symbol : passwordSequence) {
            boolean validSpecialSign = false;
            for(char specialSign : specialSymbolsSequence) {
                if(symbol == specialSign) {
                    validSpecialSign = true;
                    specialSignCounter++;
                    break;
                }
            }
            if(!validSpecialSign) {
                //48-57 - numbers, 65-90 - capital latin letters, 97-122 - non capital latin letters
                if(!((symbol >= 48 && symbol <= 57) || (symbol >= 65 && symbol <= 90) || (symbol >= 97 && symbol <= 122))) {
                    return false;
                }
            }
        }
        return (specialSignCounter > 0);
    }
}
