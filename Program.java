import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Program extends JPanel implements KeyListener {
    JFrame frame;
    int width = 300;
    int height = 500;
    static Grid grid;
    long time = System.currentTimeMillis();

    public Program(){
        frame = new JFrame("Tron");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addKeyListener(this);
        this.setPreferredSize(new Dimension(width, height));
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        this.setBackground(new Color(60, 60, 60));
        grid = new Grid();
        grid.setNewGame();
        loop();
    }

    public void loop(){
        while (true) {
            long currTime = System.currentTimeMillis();
            if (currTime - time > 60){
                grid.update();
                repaint();
                time = System.currentTimeMillis();
            }
        }
    }

    public void paint(Graphics g){
        super.paint(g);
        for (int i = 0; i < grid.width(); i++){
            for (int j = 0; j < grid.height(); j++){
                switch(grid.get(i,j)) {
                    case -1:
                        g.setColor(Color.DARK_GRAY);
                        break;
                    case 0:
                        g.setColor(Color.RED);
                        break;
                    case 1:
                        g.setColor(Color.YELLOW);
                        break;
                    case 2:
                        g.setColor(Color.MAGENTA);
                        break;
                    case 3:
                        g.setColor(Color.WHITE);
                        break;
                }
                int x = (int)(((double)getWidth() / grid.width()) * i);
                int y = (int)(((double)getHeight() / grid.height()) * j);
                int w = (int)((double)getWidth() / grid.width());
                int h = (int)((double)getHeight() / grid.height());

                g.fillRect(x, y, w, h);
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(x, y, w, h);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                grid.setPlayerOneDirection(Direction.NORTH);
                break;
            case KeyEvent.VK_D:
                grid.setPlayerOneDirection(Direction.EAST);
                break;
            case KeyEvent.VK_S:
                grid.setPlayerOneDirection(Direction.SOUTH);
                break;
            case KeyEvent.VK_A:
                grid.setPlayerOneDirection(Direction.WEST);
                break;
            case KeyEvent.VK_UP:
                grid.setPlayerTwoDirection(Direction.NORTH);
                break;
            case KeyEvent.VK_RIGHT:
                grid.setPlayerTwoDirection(Direction.EAST);
                break;
            case KeyEvent.VK_DOWN:
                grid.setPlayerTwoDirection(Direction.SOUTH);
                break;
            case KeyEvent.VK_LEFT:
                grid.setPlayerTwoDirection(Direction.WEST);
                break;
            case KeyEvent.VK_SPACE:
                grid.changeMenu();
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] yeet){
        new Program();
    }
}
