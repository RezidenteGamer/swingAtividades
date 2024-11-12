import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculadoraTop {
    private JPanel tela;
    private JTextField visor;
    private JButton botao9;
    private JButton botao6;
    private JButton botao3;
    private JButton botao2;
    private JButton botao8;
    private JButton botao5;
    private JButton botao7;
    private JButton botao4;
    private JButton botao1;
    private JButton botao0;
    private JButton botaoAdicao;
    private JButton botaoSubtr;
    private JButton botaoMultiplica;
    private JButton botaoDividir;
    private JButton clean;
    private JButton botaoIgual;

    private String operador;
    private double num1, num2, resultado;

    public calculadoraTop() {
        tela = new JPanel();
        visor = new JTextField(10);
        visor.setEditable(false);
        tela.setLayout(new BorderLayout());
        tela.add(visor, BorderLayout.NORTH);

        JPanel botoes = new JPanel();
        botoes.setLayout(new GridLayout(4, 4));

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

        tela.add(botoes, BorderLayout.CENTER);
    }

    private void adicionarBotao(JPanel painel, String texto) {
        JButton botao = new JButton(texto);
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String comando = e.getActionCommand();

                if (comando.chars().allMatch(Character::isDigit)) {
                    visor.setText(visor.getText() + comando);
                } else if (comando.equals("C")) {
                    visor.setText("");
                } else if (comando.equals("=")) {
                    num2 = Double.parseDouble(visor.getText());
                    switch (operador) {
                        case "+":
                            resultado = num1 + num2;
                            break;
                        case "-":
                            resultado = num1 - num2;
                            break;
                        case "*":
                            resultado = num1 * num2;
                            break;
                        case "/":
                            if (num2 != 0) {
                                resultado = num1 / num2;
                            } else {
                                visor.setText("Erro");
                                return;
                            }
                            break;
                    }
                    visor.setText(String.valueOf(resultado));
                } else {
                    operador = comando;
                    num1 = Double.parseDouble(visor.getText());
                    visor.setText("");
                }
            }
        });
        painel.add(botao);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setContentPane(new calculadoraTop().tela);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
