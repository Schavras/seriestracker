package buttons;

import java.awt.Color;
import javax.swing.JButton;

public class BlueButton extends JButton {

    private static final long serialVersionUID = 1L;

    public BlueButton(String label) {
        super(label);
        setBackground(new Color(59, 89, 182));
        setForeground(Color.WHITE);
    }

  
    
}