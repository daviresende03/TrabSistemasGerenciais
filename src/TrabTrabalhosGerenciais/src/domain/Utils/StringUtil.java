package domain.Utils;

public class StringUtil {
    public static final String RemoveMask(String string){
        return string == null ? "" : string.replaceAll("[^0-9]", "");
    }
}
