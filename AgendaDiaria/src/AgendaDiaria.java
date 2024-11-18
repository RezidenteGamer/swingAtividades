import javax.swing.*;
import java.awt.*;

public class AgendaDiaria { //define os elementos que serao usados
    private JTextField campoCompromisso;
    private JSpinner dia;
    private JSpinner minutos;
    private JSpinner mes;
    private JSpinner ano;
    private JSpinner horas;
    private JPanel tela;
    private JButton adicionarCompromissoButton;
    private JTable tabelaCompromissos;
    private JButton removerCompromissoButton;

    String[] cabecalho = {"Compromisso", "Data", "Horas"}; //entre as virgulas esta o nome dos cabeçalhos da tabela.
    String[][] compromissos = {}; //Compromissos = dados que serão dispostos pelo usuario.

    public void inicializacao() { //Inicializa todos os componentes necessarios
        tela = new JPanel();
        tela.setLayout(new BorderLayout());

        campoCompromisso = new JTextField();
        adicionarCompromissoButton = new JButton("Adicionar Compromisso");
        dia = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        mes = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
        ano = new JSpinner(new SpinnerNumberModel(2024, 2024, 2034, 1));
        horas = new JSpinner(new SpinnerNumberModel(0, 0, 23, 1));
        minutos = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
        removerCompromissoButton = new JButton("Remover");

        tabelaCompromissos = new JTable(compromissos, cabecalho);
        JScrollPane scrollPane = new JScrollPane(tabelaCompromissos);


        JPanel entradaPainel = new JPanel(new GridLayout(2, 4)); //Definindo como os elementos ficarao dispostos na tela!
        entradaPainel.add(new JLabel("Compromisso:"));
        entradaPainel.add(campoCompromisso);
        entradaPainel.add(new JLabel("Dia:"));
        entradaPainel.add(dia);
        entradaPainel.add(new JLabel("Mês:"));
        entradaPainel.add(mes);
        entradaPainel.add(new JLabel("Ano:"));
        entradaPainel.add(ano);
        entradaPainel.add(new JLabel("Horas:"));
        entradaPainel.add(horas);
        entradaPainel.add(new JLabel("Minutos:"));
        entradaPainel.add(minutos);
        entradaPainel.add(adicionarCompromissoButton);
        entradaPainel.add(adicionarCompromissoButton);
        entradaPainel.add(removerCompromissoButton);


        tela.add(entradaPainel, BorderLayout.NORTH);
        tela.add(scrollPane, BorderLayout.CENTER);

        removerCompromissoButton.addActionListener(e -> removerCompromisso());

        adicionarCompromissoButton.addActionListener(e -> { //ação que detecta o click do usuario e faz com que o valor vá para determinado local
            String compromisso = campoCompromisso.getText();
            int diaSelecionado = (int) dia.getValue();
            int mesSelecionado = (int) mes.getValue();
            int anoSelecionado = (int) ano.getValue();
            int horasSelecionadas = (int) horas.getValue();
            int minutosSelecionados = (int) minutos.getValue();
            String data = String.format("%02d/%02d/%04d", diaSelecionado, mesSelecionado, anoSelecionado); //define como ficara disposto a String 00/00/0000
            String horario = String.format("%02d:%02d", horasSelecionadas, minutosSelecionados); // 00:00

            String[][] novoCompromissos = new String[compromissos.length + 1][3];
            for (int i = 0; i < compromissos.length; i++) {
                novoCompromissos[i] = compromissos[i];
            }
            novoCompromissos[compromissos.length] = new String[]{compromisso, data, horario};
            compromissos = novoCompromissos;

            tabelaCompromissos.setModel(new javax.swing.table.DefaultTableModel(compromissos, cabecalho));
        });
    }
    private void removerCompromisso(){     //criado um metodo para remover algum item da tabela sempre que solicitado
        int linhaSelecionada = tabelaCompromissos.getSelectedRow();
        if (linhaSelecionada != 1) {
            String[][] novoCompromissos = new String[compromissos.length - 1][3];

            for(int i = 0, j = 0 ; i < compromissos.length; i++){
                if (i != linhaSelecionada){
                    novoCompromissos[j++] = compromissos[i];
                }
            }
            compromissos = novoCompromissos;

            tabelaCompromissos.setModel(new javax.swing.table.DefaultTableModel(compromissos, cabecalho));
        } else {
            JOptionPane.showMessageDialog(tela, "Selecione um compromisso para remover!"); //caso o usuario nao selecione nenhum item
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Agenda Diária");
        AgendaDiaria agenda = new AgendaDiaria();
        agenda.inicializacao();
        frame.setContentPane(agenda.tela);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ao fechar a janela a execução do codigo também se encerra.
        frame.setVisible(true);
        frame.setSize(600, 400);
    }
}
