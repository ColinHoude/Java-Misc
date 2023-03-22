import java.util.HashMap;
public class IdPasswords {
    // hashmap to store key value pairs of username and passwords
    HashMap<String, String> loginSheet = new HashMap<>();
    IdPasswords(){
        loginSheet.put("admin", "admin");
    }
    IdPasswords(String x, String y){
        loginSheet.put(x, y);
    }
    protected HashMap<String, String> getLoginInfo(){
        return loginSheet;
    }

}
