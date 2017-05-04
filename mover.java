
/**
 * Write a description of class main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.Robot;
import javax.swing.*;
public class mover
{
    public void mover()
    {

    }
    public static KeyListener listen;
    public static int x = 100, y = 100;
    static Robot robot;
    static JDialog dialog;
    public static void main(String args[])
    {
        int exit;
       dialog = new JDialog ();
        try
        {
            robot = new Robot();
        } catch(AWTException ae)
        {
        }
        listen = new KeyListener()
        {

            @Override
            public void keyPressed(KeyEvent e)
            {
                int key = e.getKeyCode();

                if(key == KeyEvent.VK_W)
                {
                    y -= 10;
                    robot.mouseMove(x, y);
                }
                if(key == KeyEvent.VK_S)
                {
                    y += 10;
                    robot.mouseMove(x, y);
                }
                if(key == KeyEvent.VK_A)
                {
                    x -= 10;
                    robot.mouseMove(x, y);
                }
                if(key == KeyEvent.VK_D)
                {
                    x += 10;
                    robot.mouseMove(x, y);
                }
                if(key == KeyEvent.VK_E)
                {
                    x += 10;
                    y -= 10;
                    robot.mouseMove(x, y);
                }
                if(key == KeyEvent.VK_C)
                {
                    x += 10;
                    y += 10;
                    robot.mouseMove(x, y);
                }
                if(key == KeyEvent.VK_Z)
                {
                    x -= 10;
                    y += 10;
                    robot.mouseMove(x, y);
                }
                if(key == KeyEvent.VK_Q)
                {
                    x -= 10;
                    y -= 10;
                    robot.mouseMove(x, y);
                }
                if(key == KeyEvent.VK_ENTER)
                {
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                    dialog.setVisible(false);
                }
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
                int key = e.getKeyCode();

            }

            @Override
            public void keyTyped(KeyEvent e)
            {
                int key = e.getKeyCode();
            }
        };
        dialog.addKeyListener(listen);
        dialog.setFocusable(true);
        dialog.setModal (true);
        dialog.setAlwaysOnTop (true);
        dialog.setModalityType (Dialog.ModalityType.DOCUMENT_MODAL);
        dialog.setVisible(true);
        dialog.isActive();
        while(true)
        {
            if(!dialog.isVisible())
            {
                dialog.setVisible(true);
                
            }
            else if(!dialog.isActive())
            {
                dialog.setVisible(false);
                dialog.setVisible(true);
            }

        }
        
        
    }
}
