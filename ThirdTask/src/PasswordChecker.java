public class PasswordChecker {

    public boolean passwordLenght(String password, int minLength){
        return (password.length() >= minLength);
    }

    public boolean hasUppercase(String password){
        for(int i=0;i < password.length();i++) {
            if (Character.isUpperCase(password.charAt(i))){
                    return true;
                }
        }
        return false;
    }

    public boolean hasSpecialSymbols(String password){
        String specialSymbols = " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        for(int i=0;i < password.length();i++){
            for(int j=0;j < password.length();j++){
                if (password.charAt(i) == specialSymbols.charAt(j)){
                    return true;
                }
            }
        }
        return false;
    }
}
