import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class gamePlay extends JPanel implements KeyListener, ActionListener {
    private boolean isPlaying = false;
    private int score = 0;
    private int totalBricks = 21;
    private Timer time;

    //not sure what these values represent
    private int delay = 8;
    private int playerX = 310;

    private int ballPosX = 120;
    private int ballPosY = 350;
    private int ballXDir = -1;
    private int ballYDir = -2;
    private mapGenerator map;

    public gamePlay(){
        map = new mapGenerator(3, 7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        Timer time = new Timer(delay, this);
        time.start();
    }

    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);
        map.draw((Graphics2D) g);
        // no idea what any of these values represent
        // this tutorial is not good at explaining anything
        g.setColor(Color.yellow);
        g.fillRect(0,0,3,592);
        g.fillRect(0,0,692, 3);
        g.fillRect(691,0,3, 592);

        // setting font size color and location for score
        g.setColor(Color.white);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("" + score, 590, 30);

        g.setColor(Color.yellow);
        g.fillRect(playerX, 550,100,8);

        g.setColor(Color.green);
        g.fillOval(ballPosX, ballPosY, 20, 20);

        if(ballPosY > 570){
            // this is the ball is below the player slider hence the game is over
            isPlaying= false;
            ballXDir = 0;
            ballYDir = 0;
            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("GAME OVER... Score: " + score,190, 300);

            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Press Enter to Restart ",190, 340);
        }

        if(totalBricks == 0){

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported action.");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported action.");
    }

    public void moveRight(){
        isPlaying = true;
        playerX += 20;
    }

    public void moveLeft(){
        isPlaying = true;
        playerX -= 20;
    }


}
