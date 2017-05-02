package hw3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;

public class Panel {
    private final JPanel gui = new JPanel(new BorderLayout(2, 2));
    static GridRobot robot; 
    private JButton[][] boardSquares; // each square will be button
    private JPanel board; // board to put buttons
    private JLabel message = new JLabel("Robot " + robot.toString() + ". We are ready to play!"); // status message

    Panel(int width, int height) {
    	boardSquares = new JButton[width][height];
        initializeGui(width, height);
    }
    
    public final void initializeGui(int width, int height) {
        gui.setBorder(new EmptyBorder(10, 10, 10, 10));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        
        // Turn left button
        JButton btn = new JButton("Turn Left");
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                robot.turnLeft();
                Insets buttonMargin = new Insets(0,0,0,0);
                int x = robot.getLocation().getX();
                int y = robot.getLocation().getY();
                boardSquares[x][y].setMargin(buttonMargin);
                ImageIcon icon = new ImageIcon("img/"+robot.getDirection()+".png");
                boardSquares[x][y].setIcon(icon);
                boardSquares[x][y].setBackground(Color.WHITE);
                message.setText("Robot Botinga turned left.");
            }
        });
        tools.add(btn);
        tools.addSeparator();
        
        // Turn right button
        btn = new JButton("Turn Right");
        tools.add(btn);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                robot.turnRight();
                Insets buttonMargin = new Insets(0,0,0,0);
                int x = robot.getLocation().getX();
                int y = robot.getLocation().getY();
                boardSquares[x][y].setMargin(buttonMargin);
                ImageIcon icon = new ImageIcon("img/"+robot.getDirection()+".png");
                boardSquares[x][y].setIcon(icon);
                boardSquares[x][y].setBackground(Color.WHITE);
                message.setText("Robot Botinga turned right.");
            }
        });
        tools.addSeparator();
        
        // Move button
        btn = new JButton("Move");
        tools.add(btn);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Insets buttonMargin = new Insets(0,0,0,0);
                // Old place
                int x = robot.getLocation().getX();
                int y = robot.getLocation().getY();
                ImageIcon icon = new ImageIcon(new BufferedImage(40, 40, BufferedImage.TYPE_INT_ARGB));
                boardSquares[x][y].setIcon(icon);
                boardSquares[x][y].setBackground(Color.WHITE);
                // New place
                String answer = robot.move();
                message.setText(answer);
                x = robot.getLocation().getX();
                y = robot.getLocation().getY();
                boardSquares[x][y].setMargin(buttonMargin);
                icon = new ImageIcon("img/"+robot.getDirection()+".png");
                boardSquares[x][y].setIcon(icon);
                boardSquares[x][y].setBackground(Color.WHITE);
            }
        });
        tools.addSeparator();
        tools.add(message);
        board = new JPanel(new GridLayout(0, width+1));
        board.setBorder(new LineBorder(Color.BLACK));
        gui.add(board);

        Insets buttonMargin = new Insets(0,0,0,0);
        for (int i = 0; i < boardSquares.length; i++) {
            for (int j = 0; j < boardSquares[i].length; j++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                // our  pieces are 40x40 px in size, so we'll
                ImageIcon icon = new ImageIcon(new BufferedImage(40, 40, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                b.setBackground(Color.WHITE);
                boardSquares[j][i] = b;
            }
        }
        //put robot to board
        JButton b = new JButton();
        b.setMargin(buttonMargin);
        ImageIcon icon = new ImageIcon("img/"+robot.getDirection()+".png");
        b.setIcon(icon);
        b.setBackground(Color.WHITE);
        boardSquares[robot.getLocation().getX()][robot.getLocation().getY()] = b;
        
        board.add(new JLabel(""));
        // fill the top row
        for (int i = 0; i < width; i++) {
            board.add(new JLabel("" + i, SwingConstants.CENTER));
        }
        // fill the  non-pawn piece row
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                switch (j) {
                    case 0:
                        board.add(new JLabel("" + i, SwingConstants.CENTER));
                    default:
                        board.add(boardSquares[j][i]);
                }
            }
        }
    }

    public final JComponent getGui() {
        return gui;
    }

    public static void main(String[] args) {
    	robot = new GridRobot("botinga");
        Runnable r = new Runnable() {
            public void run() {
                int width = robot.getWidth();
                int height = robot.getHeight();
                
                Panel cb = new Panel(width, height);

                JFrame f = new JFrame("Botinga");
                f.add(cb.getGui());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.pack();
                f.setVisible(true);
                
            }
        };
        SwingUtilities.invokeLater(r);
    }
}