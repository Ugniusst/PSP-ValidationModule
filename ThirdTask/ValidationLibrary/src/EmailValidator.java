public class EmailValidator {

    public boolean hasEtaSymbol(String email){
        return  email.contains("@");
    }

    public boolean hasOnlyRightSymbols(String email){
        String localPart = email.substring(0, email.indexOf("@"));

        if (hasIllegalSymbols(localPart, "\"(),:;<>@[\\]".toCharArray())){
            return false;
        }

        if (localPart.contains("..") || localPart.startsWith(".") || localPart.endsWith(".")){
            return false;
        }

        return true;
    }

    public boolean hasRightDomain(String email){
        String domainPart = email.substring(email.indexOf('@')+1, email.length()-1) + email.charAt(email.length()-1);
        String TLD = email.substring(email.lastIndexOf(".") + 1, email.length()-1) + email.charAt(email.length()-1);

        if (hasIllegalSymbols(domainPart, " _!@#$%^&*();:,?/\\=+<>".toCharArray())){
            return false;
        }

        if (domainPart.startsWith("-") || domainPart.endsWith("-") ||
            domainPart.contains("--") || domainPart.contains(".-") || domainPart.contains("-.")){
            return false;
        }

        if (TLD.length() <= 2 || TLD.length() >= 63){
            return false;
        }

        return true;
    }

    private boolean hasIllegalSymbols(String string, char[] illegalSymbols){
        for(char symbol : string.toCharArray()){
            for(char illegalSymbol : illegalSymbols){
                if (symbol == illegalSymbol){
                    return true;
                }
            }
        }
        return false;
    }
}
