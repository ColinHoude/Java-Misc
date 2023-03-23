import java.security.MessageDigest;
import java.util.HashMap;
public class IdPasswords {
    // hashmap to store key value pairs of username and passwords
    HashMap<String, String> loginSheet = new HashMap<>();
    IdPasswords(){
        loginSheet.put("admin", sha256("admin"));
    }
    IdPasswords(String x, String y){
        loginSheet.put(x, y);
    }
    protected HashMap<String, String> getLoginInfo(){
        return loginSheet;
    }

    public static String sha256(final String base) {
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(base.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }


}
