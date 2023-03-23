import java.util.Date;

public class UserInformation {
    // this is a user informatin class
    // id like to have information such as
        // name
        // age
        // birthday
    String userName;
    String name;
    int age;
    Date birthDay;

    public String getUserName() {
        return userName;
    }
    public String getName(){
        return name;
    }
    public Date getBirthDay(){
        return birthDay;
    }
    public int getAge(){
        return age;
    }

    UserInformation(String userName){
        this.userName = userName;
    }
}
