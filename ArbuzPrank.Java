import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ArbuzPrank {
    private static boolean cheatActivated = false;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Сюрприз 🍉");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setUndecorated(true); 
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 

        try {
            String imagePath = "Arbuz.png";
            ImageIcon icon = new ImageIcon(imagePath);
            JLabel label = new JLabel(icon);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);

            frame.getContentPane().add(label);
            frame.setVisible(true);

            frame.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.isControlDown() && e.isAltDown() && e.getKeyCode() == KeyEvent.VK_A) {
                        cheatActivated = true;
                        frame.dispose(); 
                    }
                }
            });

            int waited = 0;
            int delay = 200; 
            while (waited < 5 * 60 * 1000 && !cheatActivated) {
                Thread.sleep(delay);
                waited += delay;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ошибка: " + e.getMessage());
        } finally {
            frame.dispose();
        }
    }
}
