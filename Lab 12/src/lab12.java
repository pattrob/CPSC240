import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class lab12 implements ActionListener {
    private String text;
    static JTextField textField;

    public lab12(String t) {
        text = t;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String input = textField.getText();
        int num = Integer.parseInt(input);
        long factorial = num;
        for(int i = num; i > 1; i--){
            factorial = factorial * (i - 1);
        }
        JOptionPane.showMessageDialog(null, "The factorial is: " + factorial);
    }


    public static void addButton(String text, JFrame frame) {
        JButton button = new JButton(text);
        button.addActionListener(new lab12(text));
        frame.getContentPane().add(button);
    }

    public static void main (String[]args){
        JFrame frame = new JFrame("Lab 12");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Enter a number in the field below:");
        frame.getContentPane().add(label);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        textField = new JTextField();
        frame.getContentPane().add(textField);
        addButton("Calculate", frame);
        frame.pack();
        frame.setVisible(true);
    }

}