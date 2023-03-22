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

        loginResult.setBounds(125,250,250,35);
        loginResult.setFont(new Font(null, Font.ITALIC, 25));

        idField.setBounds(125,100,200,25);
        passField.setBounds(125,150,200,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        reset.setBounds(225,200,100,25);
        reset.setFocusable(false);
        reset.addActionListener(this);

        frame.add(idLabel);
        frame.add(passLabel);
        frame.add(loginResult);
        frame.add(idField);
        frame.add(passField);
        frame.add(loginButton);
        frame.add(reset);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== reset){
            idField.setText("");
            passField.setText("");
        }

        if(e.getSource() == loginButton){
            // first check if the userId is within the HashMap
            String userId = idField.getText();
            String userPass = String.valueOf(passField.getPassword());
            if(loginInfo.containsKey(userId)){
                if(loginInfo.get(userId).equals(userPass)){
                    loginResult.setForeground(Color.green);
                    loginResult.setText("Login Successful");
                    WelcomePage welcomePage = new WelcomePage();
                }
                else {
                    loginResult.setForeground(Color.red);
                    loginResult.setText("Login Failed");
                }
            }
            else {
                loginResult.setForeground(Color.red);
                loginResult.setText("Login Failed");
            }

            // if it is correct return the index of it for later saving

            // then send the password into a hash function for security purpose


            // check if the hash produces the same as the password in the database

        }

    }
}
