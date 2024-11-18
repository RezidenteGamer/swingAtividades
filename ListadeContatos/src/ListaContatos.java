import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ListaContatos { //inicializa os elementos
    private JPanel tela;
    private JTextField campoNome;
    private JTextField campoTelefone;
    private JTextField campoEmail;
    private JButton adiconarContatoBut;
    private JList<String> listaDeContatos;
    private JButton removerContatoBut;
    private DefaultListModel<String> listModel;

    public ListaContatos() {
        listModel = new DefaultListModel<>(); //Define como sera a lista/modelo de lista
        listaDeContatos.setModel(listModel);

        adiconarContatoBut.addActionListener(new ActionListener() { //detecta o clique e tenta pegar as informações passadas pelo usuario
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText();
                String telefone = campoTelefone.getText();
                String email = campoEmail.getText();

                if(nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) { //se algum estiver vazio exibe mensagem de erro!
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
            public void actionPerformed(ActionEvent e) {
                int contatoSelecionado = listaDeContatos.getSelectedIndex();
                if(contatoSelecionado != -1) {
                    listModel.remove(contatoSelecionado);
                } else {
                    JOptionPane.showMessageDialog(tela, "Selecione um contato para remover.", "Erro", JOptionPane.ERROR_MESSAGE);
                    //Aciona uma caixa de texto que mostra ao usuario que ele nao selecionou nada para remover!!

                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Contatos");
        ListaContatos listaContatos = new ListaContatos();
        frame.setContentPane(listaContatos.tela);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Encerra o codigo assim que ajanela é fechada
        frame.pack();
        frame.setVisible(true);
    }
}

