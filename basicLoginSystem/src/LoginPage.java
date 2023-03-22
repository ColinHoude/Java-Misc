import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {
    // create a copy to set globally for all loginpage methods
    HashMap<String, String> loginInfo = new HashMap<>();
    // create JFrame
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton reset = new JButton("Reset");
    JButton createUser = new JButton("Create User");

    // need a user Id field to input text
    JTextField idField = new JTextField();
    JPasswordField passField = new JPasswordField();

    // Labels for the field
    JLabel idLabel = new JLabel("Username");
    JLabel passLabel = new JLabel("Password");

    // message label to show login was successful or a failure
    JLabel loginResult = new JLabel();
    LoginPage(HashMap<String, String> x){
        loginInfo = x;

        idLabel.setBounds(50,100,75,25);
        passLabel.setBounds(50,150,75,25);

        loginResult.setBounds(162,300,250,35);
        loginResult.setFont(new Font(null, Font.ITALIC, 25));

        idField.setBounds(125,100,200,25);
        passField.setBounds(125,150,200,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        reset.setBounds(225,200,100,25);
        reset.setFocusable(false);
        reset.addActionListener(this);

        createUser.setBounds(162,250,125,25);
        createUser.setFocusable(false);
        createUser.addActionListener(this);

        frame.add(idLabel);
        frame.add(passLabel);
        frame.add(loginResult);
        frame.add(idField);
        frame.add(passField);
        frame.add(loginButton);
        frame.add(reset);
        frame.add(createUser);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == createUser){
            if(loginInfo.containsKey(idField.getText())){
                // the username is already taken
                loginResult.setForeground(Color.yellow);
                loginResult.setText("Username already taken");
            }
            else {
                // add the new user
                String userId = idField.getText();
                String userPass = String.valueOf(passField.getPassword());
                // encrypt the password
                userPass = IdPasswords.sha256(userPass);
                loginInfo.put(userId, userPass);
                loginResult.setForeground(Color.green);
                loginResult.setText("User Created!");
            }
        }


        if(e.getSource()== reset){
            idField.setText("");
            passField.setText("");
            loginResult.setText("");
        }

        if(e.getSource() == loginButton){
            // first check if the userId is within the HashMap
            String userId = idField.getText();
            String userPass = String.valueOf(passField.getPassword());
            // encrypt it
            userPass = IdPasswords.sha256(userPass);
            if(loginInfo.containsKey(userId)){
                if(loginInfo.get(userId).equals(userPass)){
                    loginResult.setForeground(Color.green);
                    loginResult.setText("Login Successful");
                    WelcomePage welcomePage = new WelcomePage();
                }
                else {
                    loginResult.setForeground(Color.red);
                    loginResult.setText("Incorrect Password");
                }
            }
            else {
                loginResult.setForeground(Color.red);
                loginResult.setText("User not found");
            }

            // if it is correct return the index of it for later saving

            // then send the password into a hash function for security purpose


            // check if the hash produces the same as the password in the database

        }

    }
}
