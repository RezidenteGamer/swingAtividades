import javax.swing.*;
import java.awt.*;

public class calculadoraIMC {
    private JTextField campoPeso;
    private JTextField campoAltura;
    private JButton calcularIMCButton;
    private JLabel resultado;
    private JPanel tela;

    public void initialize() {
        tela = new JPanel();
        tela.setLayout(new GridLayout(4, 2));

        campoPeso = new JTextField();
        campoAltura = new JTextField();
        calcularIMCButton = new JButton("Calcular IMC");
        resultado = new JLabel("Resultado: ");

        tela.add(new JLabel("Peso (kg):"));
        tela.add(campoPeso);
        tela.add(new JLabel("Altura (m):"));
        tela.add(campoAltura);
        tela.add(calcularIMCButton);
        tela.add(resultado);

        calcularIMCButton.addActionListener(e -> {

            //Mensagem para o professor: *****eu encontrei esse "try" nas minhas pesquisas sobre Java e achei melhor usar ele pois eu acho mais simples
            //emitir uma mensagem de erro ao em vez de uma grande estrutura if/else ou case!!!!
            try {
                double altura = Double.parseDouble(campoAltura.getText());
                double peso = Double.parseDouble(campoPeso.getText());

                if (altura <= 0 || peso <= 0) {
                    resultado.setText("Por favor, insira valores positivos para altura e peso.");
                } else {
                    double imc = peso / (altura * altura);
                    String classificacao;

                    if (imc < 18.5) {
                        classificacao = "Baixo peso";
                    } else if (imc < 24.9) {
                        classificacao = "Normal";
                    } else if (imc < 29.9) {
                        classificacao = "Sobrepeso";
                    } else {
                        classificacao = "Obesidade";
                    }

                    resultado.setText(String.format("IMC: %.2f (%s)", imc, classificacao));
                }
            } catch (NumberFormatException ex) {
                resultado.setText("Por favor, insira valores válidos.");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de IMC");
        calculadoraIMC calculadora = new calculadoraIMC();
        calculadora.initialize();
        frame.setContentPane(calculadora.tela);

        //Usei esse metodo para ao fechar a janela, fechar o programa também!!
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
