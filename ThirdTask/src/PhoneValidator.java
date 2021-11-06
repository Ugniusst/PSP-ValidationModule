import java.util.HashMap;
import java.util.Map;

public class PhoneValidator {

    Map<String, String> prefixRules  = new HashMap<String, String>() {{
        //put("lt", "8");
        //put("lv", "8");
        //put("lvInternational","+371")
    }};

    public boolean hasOnlyNumbers(String number){
        boolean isPlus = false;
        if (number.charAt(0) == '+'){
            isPlus = true;
        }
        for(int i=0;i < number.length();i++) {
            if(!(i == 0 && isPlus)) {
                if (!Character.isDigit(number.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public String changeToLithuanianPrefix(String number){
        return number.replace("8", "+370");
    }

    public void addNewPhoneRules(String prefix, String country){
        prefixRules.put(country.toLowerCase(), prefix);
    }

    public boolean checkPrefixWithCountry(String number, String country){
        return number.startsWith(prefixRules.get(country));
    }
}
