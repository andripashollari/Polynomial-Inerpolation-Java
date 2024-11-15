import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class MyFrame extends JFrame implements ActionListener {


    TextField[] textField1;
    TextField[] textField2;
    TextField[] textFieldX;
    TextField[] textFieldY;
    MyPanel myPanel;
    MyNextButton nextButton;
    private double [] y;
    private double [] x;

    public MyFrame(int n){
        this.setLayout(null);
        this.setSize(new Dimension(460, (n+1)*50+40));
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        //this.getContentPane().setBackground(Color.BLACK);
        this.setLocationRelativeTo(null);

        textField1 = new TextField[3];
        textField2 = new TextField[n];
        textFieldX = new TextField[n];
        textFieldY = new TextField[n];

        for(int i=0; i<3; i++){
            textField1[i] = new TextField();
            textField1[i].setEditable(false);
            textField1[i].setBackground(Color.GRAY);
            textField1[i].setForeground(Color.BLACK);
            textField1[i].setFont(new Font("Bookman Old Style", Font.BOLD, 30));
        }
        textField1[0].setText("i");
        textField1[1].setText("x");
        textField1[2].setText("y");


        for(int i=0; i<n; i++){
            textField2[i] = new TextField();
            textField2[i].setText(String.valueOf(i));
            textField2[i].setEditable(false);
            textField2[i].setBackground(Color.GRAY);
            textField2[i].setForeground(Color.BLACK);
            textField2[i].setFont(new Font("Bookman Old Style", Font.BOLD, 30));
        }
        for(int i=0; i<n; i++){
            textFieldX[i] = new TextField();
            textFieldX[i].setBackground(Color.WHITE);
            textFieldX[i].setForeground(Color.BLACK);
            textFieldX[i].setFont(new Font("Bookman Old Style", Font.BOLD, 30));

            textFieldY[i] = new TextField();
            textFieldY[i].setBackground(Color.WHITE);
            textFieldY[i].setForeground(Color.BLACK);
            textFieldY[i].setFont(new Font("Bookman Old Style", Font.BOLD, 30));
        }

        myPanel = new MyPanel(n);
        for(int i=0; i<3; i++){
            myPanel.add(textField1[i]);
        }
        for(int i=0; i<n; i++){
            myPanel.add(textField2[i]);
            myPanel.add(textFieldX[i]);
            myPanel.add(textFieldY[i]);
        }

        nextButton = new MyNextButton("Next", n);
        nextButton.addActionListener(this);


        this.add(myPanel);
        this.add(nextButton);

        this.setVisible(true);

        x = new double[n]; 
        y = new double[n];

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == nextButton){
            Scanner scanner = new Scanner(System.in);
            for(int i=0; i<textFieldX.length; i++){
                x[i] = Double.parseDouble(textFieldX[i].getText());
                y[i] = Double.parseDouble(textFieldY[i].getText());
            }

            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

            System.out.print("Vendosni x per te marre perafrimin e vleres se y: ");
            double numer = scanner.nextDouble();

            System.out.println("Rezultati: \ny = "+Interpol.solve(numer, x, y));
            System.out.println("Gabimi: "+ Math.abs(Interpol.merrGabimin()));
        }
    }
    public double [] getx(){
        return x;
    }
    public double [] gety(){
        return y;
    }
}
