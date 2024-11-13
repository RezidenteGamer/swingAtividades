import javax.swing.*;

public class calculadoraIMC {
    private JTextField campoAltura;
    private JTextField campoPeso;
    private JButton calcularIMCButton;
    private JLabel resultado;
    private JPanel tela;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de IMC");
        frame.setContentPane(new calculadoraIMC().tela);
        frame.setVisible(true);
        frame.setSize(900,700);
    }
}
