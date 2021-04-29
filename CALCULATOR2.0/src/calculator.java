import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator implements ActionListener{

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];//numbers 0 to 10
    JButton[] functionButtons = new JButton[9];//functions : +, -, /, *,...
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;

    /*creating a panel object, the panel will contain the numbers buttons and some functions buttons*/
    JPanel panel;

    Font myFont = new Font("Ink Free",Font.BOLD,30);

    double num1=0, num2=0,result=0;
    /*a char variable named operator that will hold the operator, multiply or add etc*/
    char operator;

    calculator(){
        /*Setting up the frame*/
        frame = new JFrame("Java calculator App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);


        /*Setting up the textfield*/
        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);  //setBounds to  set where the textfield goes because I am not using any LayoutManager
        textfield.setFont(myFont);
        textfield.setEditable(false);


        /*Setting up the operators buttons*/
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("clr");
        negButton = new JButton("(-)");


        /*Setting the order of the functions buttons */
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i=0; i<9; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        for (int i=0; i<10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        /*Setting the neg, del, and clr button separately */
        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        /*Setting up the panel: grid design*/
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        /*Setting up the panel: numbers and buttons*/
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton); //"+" button

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);


        /*Making them visible*/
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);//for whole frame
    }
    public static void main(String[] args) {
        calculator calc = new calculator();
    }

    /*TO ADD FUNCTIONALITY TO THE BUTTONS*/
    @Override
    public void actionPerformed(ActionEvent e) {
        /*for the buttons in the panel: numbers + operators + decButton and equButton*/
        for (int i=0; i<10; i++){
            if (e.getSource() == numberButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        /*for functions buttons*/
        if (e.getSource() == decButton){
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == addButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == subButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == mulButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = 'x';
            textfield.setText("");
        }
        if (e.getSource() == divButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '÷';
            textfield.setText("");
        }
        if (e.getSource() == equButton){
            num2 = Double.parseDouble(textfield.getText());
            /*Enhanced Switch statement*/
            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case 'x' -> result = num1 * num2;
                case '÷' -> result = num1 / num2;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
        if (e.getSource() == delButton){
            String string = textfield.getText();
            textfield.setText("");
            for (int i=0; i<string.length()-1;i++){
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }
        if (e.getSource() == negButton){
            double temp = Double.parseDouble(textfield.getText());
            temp *=-1;
            textfield.setText(String.valueOf(temp));
        }
        if (e.getSource() == clrButton){
            textfield.setText("");
        }

    }
}
