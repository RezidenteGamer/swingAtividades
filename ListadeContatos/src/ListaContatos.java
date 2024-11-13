import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ListaContatos {
    private JPanel tela;
    private JTextField campoNome;
    private JTextField campoTelefone;
    private JTextField campoEmail;
    private JButton adiconarContatoBut;
    private JList<String> listaDeContatos;
    private JButton removerContatoBut;
    private DefaultListModel<String> listModel;

    public ListaContatos() {
        listModel = new DefaultListModel<>();
        listaDeContatos.setModel(listModel);

        adiconarContatoBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText();
                String telefone = campoTelefone.getText();
                String email = campoEmail.getText();

                if(nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(tela, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String contato = "Nome: " + nome + ", Telefone: " + telefone + ", Email: " + email;
                listModel.addElement(contato);
                campoNome.setText("");
                campoTelefone.setText("");
                campoEmail.setText("");
            }
        });

        removerContatoBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listaDeContatos.getSelectedIndex();
                if(selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(tela, "Selecione um contato para remover.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Contatos");
        ListaContatos listaContatos = new ListaContatos();
        frame.setContentPane(listaContatos.tela);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

