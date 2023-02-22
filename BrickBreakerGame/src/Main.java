import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame obj = new JFrame();
        gamePlay gp = new gamePlay();
        obj.setBounds(10, 10, 700, 600);
        obj.setTitle("Breakin yo Mama's Back SHOOOOOO");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gp);
    }
}