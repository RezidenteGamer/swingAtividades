import javax.swing.*;

public class AgendaDiaria {
    private JTextField campoCompromisso;
    private JSpinner dia;
    private JSpinner minutos;
    private JSpinner mes;
    private JSpinner ano;
    private JSpinner horas;
    private JPanel tela;
    private JButton adicionarCompromissoButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Agenda Diaria");
        frame.setContentPane(new AgendaDiaria().tela);
        frame.setVisible(true);
        frame.setSize(1200,1000);
    }
}
