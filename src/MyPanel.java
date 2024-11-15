import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel{

    MyPanel(int n){

        this.setLayout(new GridLayout(n+1,3, 5, 5));
        this.setBackground(Color.BLACK);
        this.setBounds(0, 0, 450, n*50);




    }

}
