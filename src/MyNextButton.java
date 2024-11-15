import javax.swing.*;
import java.awt.*;

public class MyNextButton extends JButton {
    public MyNextButton(String text, int n){
        this.setText(text);
        this.setFocusable(false);
        this.setBackground(Color.GRAY);
        this.setFont(new Font(null, Font.BOLD, 25));
        this.setForeground(Color.BLACK);
        this.setBounds(0, n*50 +2, 450, 50);

    }
}
