import java.awt.*;

public class mapGenerator {
    public int map[][];
    int brickWidth, brickHeight;

    public mapGenerator(int row, int column){
        map = new int[row][column];
        for(int []map1 : map){
            for(int i = 0; i < map[0].length; i++){
                map1[i] = 1;
            }
        }

        brickHeight = 540/row;
        brickWidth = 540/column;
    }

    public void draw(Graphics2D g){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] > 0){
                    // setting the color of the bricks
                    g.setColor(Color.red);
                    // filling the brick with that color
                    g.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);

                }
            }
        }
    }

    public void setBrickValue(int value, int row, int col){
        map[row][col] = value;
    }
}
