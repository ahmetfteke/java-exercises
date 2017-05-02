package pg;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;


public class GUI {
	private final JPanel gui = new JPanel(new BorderLayout(2, 2));
	static GridRobot pelinBot;
    private JLabel[][] locations;
    private JPanel panelToPut;
    private JLabel message = new JLabel(pelinBot.toString());

    public final int  WIDTH = 20;
    public final int  HEIGHT = 20;
    GUI(){
    	locations = new JLabel[WIDTH][HEIGHT];
    	guiSetup();
    }
    public final void guiSetup(){
    	gui.setBorder(new EmptyBorder(9,9,9,9));

        JButton btn = new JButton("Turn Left");
        JButton btn2 = new JButton("Turn Right");
        JButton btn3 = new JButton("Move");
        
    	JToolBar buttons = new JToolBar();
    	buttons.setFloatable(false);
    	buttons.add(btn);
    	buttons.add(btn2);
    	buttons.add(btn3);
    	buttons.add(message);
        gui.add(buttons, BorderLayout.SOUTH);
        
    	panelToPut = new JPanel(new GridLayout(0, WIDTH));
        panelToPut.setBorder(new LineBorder(Color.BLACK));
        gui.add(panelToPut);
        
        Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                JLabel l = new JLabel();
                ImageIcon icon = new ImageIcon(new BufferedImage(40, 40, BufferedImage.TYPE_INT_ARGB));
                l.setIcon(icon);
                l.setBorder(border);
                l.setHorizontalTextPosition(JLabel.CENTER);
                locations[j][i] = l;
            }
        }
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
            	panelToPut.add(locations[j][i]);
            }
        }
        
        // robot initialize
        int x = pelinBot.getLocation().getPoint()[0];
        int y = pelinBot.getLocation().getPoint()[1];
        locations[x][y].setText(pelinBot.getDirection());;
        
        btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				pelinBot.turnLeft();
				int loc[] = pelinBot.getLocation().getPoint();
				locations[loc[0]][loc[1]].setText(pelinBot.getDirection());
				message.setText(pelinBot.getMessage()); 
			}
        });
        btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				pelinBot.turnRight();
				int loc[] = pelinBot.getLocation().getPoint();
				locations[loc[0]][loc[1]].setText(pelinBot.getDirection());
				message.setText(pelinBot.getMessage()); 
			}
        });
        
        btn3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
	        	int loc[] = pelinBot.getLocation().getPoint();
				locations[loc[0]][loc[1]].setText("");
				pelinBot.move();
	        	loc = pelinBot.getLocation().getPoint();
				locations[loc[0]][loc[1]].setText(pelinBot.getDirection());
				message.setText(pelinBot.getMessage()); 
			}
        });
        
        
    }
    public final JComponent getGui() {
        return gui;
    }

    public static void main(String[] args) {
    	pelinBot = new GridRobot("Mr. Robot");
        Runnable r = new Runnable() {
            public void run() {
                GUI mygui = new GUI();
                JFrame frame = new JFrame("Mr. Robot");
                frame.add(mygui.getGui());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationByPlatform(true);
                frame.pack();
                frame.setMinimumSize(frame.getSize());
                frame.setVisible(true);
                
            }
        };
        SwingUtilities.invokeLater(r);
    }
    
}
