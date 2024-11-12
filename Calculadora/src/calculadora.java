import javax.swing.*;

public class calculadora {
    private JButton um;
    private JButton quatro;
    private JButton sete;
    private JButton dois;
    private JButton cinco;
    private JButton oito;
    private JButton tres;
    private JButton seis;
    private JButton a9Button;
    private JButton a0Button;
    private JButton button1;
    private JButton button2;
    private JButton xButton;
    private JButton button4;
    private JButton cButton;
    private JPanel calculadoraTop;
    private JTextPane numeros;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setContentPane(new calculadora().calculadoraTop);
        frame.setVisible(true);
    }
}
