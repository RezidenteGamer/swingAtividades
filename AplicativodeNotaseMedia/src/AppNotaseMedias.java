import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AppNotaseMedias {
    private JPanel tela;
    private JTextField AdicionarNota;
    private JTextArea lista;
    private JButton botaoAdicionarNota;
    private JButton botaoCalcularMedia;
    private JLabel campoAprovado;
    private JLabel campoMedia;

    private ArrayList<Double> notas;

    public AppNotaseMedias() {
        // Inicialização dos componentes
        tela = new JPanel();
        tela.setLayout(new BorderLayout());

        AdicionarNota = new JTextField(10);
        lista = new JTextArea();
        lista.setEditable(false);
        botaoAdicionarNota = new JButton("Adicionar Nota");
        botaoCalcularMedia = new JButton("Calcular Média");
        campoAprovado = new JLabel("");
        campoMedia = new JLabel("");

        // Painel para entrada de notas
        JPanel painelEntrada = new JPanel();
        painelEntrada.add(new JLabel("Nota:"));
        painelEntrada.add(AdicionarNota);
        painelEntrada.add(botaoAdicionarNota);

        // Painel para exibir resultados
        JPanel painelResultados = new JPanel();
        painelResultados.add(campoMedia);
        painelResultados.add(campoAprovado);

        // Adicionar componentes ao painel principal
        tela.add(painelEntrada, BorderLayout.NORTH);
        tela.add(new JScrollPane(lista), BorderLayout.CENTER);
        tela.add(botaoCalcularMedia, BorderLayout.SOUTH);
        tela.add(painelResultados, BorderLayout.EAST);

        notas = new ArrayList<>();

        botaoAdicionarNota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double nota = Double.parseDouble(AdicionarNota.getText());
                    notas.add(nota);
                    atualizarLista();
                    AdicionarNota.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(tela, "Por favor, insira uma nota válida.");
                }
            }
        });

        botaoCalcularMedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularMedia();
            }
        });
    }

    private void atualizarLista() {
        StringBuilder sb = new StringBuilder();
        for (double nota : notas) {
            sb.append(nota).append("\n");
        }
        lista.setText(sb.toString());
    }

    private void calcularMedia() {
        if (notas.isEmpty()) {
            JOptionPane.showMessageDialog(tela, "Nenhuma nota foi adicionada.");
            return;
        }

        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        double media = soma / notas.size();
        campoMedia.setText(String.format("Média: %.2f", media));
        campoAprovado.setText(media >= 7.0 ? "Aprovado" : "Reprovado");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicativo de Notas");
        frame.setContentPane(new AppNotaseMedias().tela);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setVisible(true);
    }
}
