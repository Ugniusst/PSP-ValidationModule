public class PasswordChecker {

    private char[] specialSymbolsSequence;

    public PasswordChecker() {
        specialSymbolsSequence = ";<>{}[]+=?&,:'`.".toCharArray();
    }
    public PasswordChecker(String validSpecialSymbols) {
        specialSymbolsSequence = validSpecialSymbols.toCharArray();
    }
    public boolean checkPasswordNotNull(String password) {
        return (password != null);
    }

    public boolean passwordLengthCheck(String password, int minimumLength) {
        if(password.length() >= minimumLength) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean passwordCheckForUppercaseLetter(String password) {
        char[] passwordSequence = password.toCharArray();
        for(char symbol : passwordSequence){
            if( symbol >= 65 && symbol <= 90) {
                return true;
            }
        }
        return false;
    }

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
        if(specialSignCounter > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
