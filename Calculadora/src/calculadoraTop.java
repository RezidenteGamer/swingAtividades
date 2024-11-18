import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculadoraTop {
    private JPanel tela;
    private JTextField visor;
    private String operador;
    private double num1, num2, resultado;

    public calculadoraTop() {
        tela = new JPanel();
        visor = new JTextField(10);
        visor.setEditable(false);
        visor.setFont(new Font("Arial", Font.BOLD, 24)); // Estilo do visor
        tela.setLayout(new BorderLayout());
        tela.add(visor, BorderLayout.NORTH);

        JPanel botoes = new JPanel();
        botoes.setLayout(new GridLayout(5, 4)); // Adicionei uma linha extra para novos botões

        // Adicionando botões numéricos e operacionais
        adicionarBotao(botoes, "7");
        adicionarBotao(botoes, "8");
        adicionarBotao(botoes, "9");
        adicionarBotao(botoes, "/");

        adicionarBotao(botoes, "4");
        adicionarBotao(botoes, "5");
        adicionarBotao(botoes, "6");
        adicionarBotao(botoes, "*");

        adicionarBotao(botoes, "1");
        adicionarBotao(botoes, "2");
        adicionarBotao(botoes, "3");
        adicionarBotao(botoes, "-");

        adicionarBotao(botoes, "0");
        adicionarBotao(botoes, "C");
        adicionarBotao(botoes, "=");
        adicionarBotao(botoes, "+");

        adicionarBotao(botoes, "←"); // Botão de backspace

        tela.add(botoes, BorderLayout.CENTER);
    }

    private void adicionarBotao(JPanel painel, String texto) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.BOLD, 20)); // Estilo dos botões
        botao.setPreferredSize(new Dimension(60, 60)); // Tamanho dos botões

        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String comando = e.getActionCommand();

                if (comando.chars().allMatch(Character::isDigit)) { // Entrada de números
                    visor.setText(visor.getText() + comando);
                } else if (comando.equals("C")) { // Limpa o visor
                    visor.setText("");
                } else if (comando.equals("←")) { // Apaga o último caractere
                    String textoAtual = visor.getText();
                    if (!textoAtual.isEmpty()) {
                        visor.setText(textoAtual.substring(0, textoAtual.length() - 1));
                    }
                } else if (comando.equals("=")) { // Calcula o resultado
                    if (visor.getText().isEmpty()) {
                        visor.setText("0");
                        return;
                    }
                    num2 = Double.parseDouble(visor.getText());
                    switch (operador) { // Operações matemáticas
                        case "+" -> resultado = num1 + num2;
                        case "-" -> resultado = num1 - num2;
                        case "*" -> resultado = num1 * num2;
                        case "/" -> resultado = (num2 != 0) ? num1 / num2 : Double.NaN;
                    }
                    if (Double.isNaN(resultado)) {
                        visor.setText("Erro");
                    } else {
                        visor.setText(String.valueOf(resultado));
                    }
                } else { // Define o operador e guarda o primeiro número
                    if (!visor.getText().isEmpty()) {
                        operador = comando;
                        num1 = Double.parseDouble(visor.getText());
                        visor.setText("");
                    }
                }
            }
        });
        painel.add(botao);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setContentPane(new calculadoraTop().tela);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); // Ajusta o tamanho da janela automaticamente
        frame.setResizable(false); // Impede redimensionamento
        frame.setVisible(true);
    }
}
