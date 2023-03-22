public class Main {
    public static void main(String[] args) {
        // need to create instances of all classes;
        IdPasswords idPass = new IdPasswords();
        LoginPage log = new LoginPage(idPass.getLoginInfo());
        WelcomePage welc = new WelcomePage();
    }
}