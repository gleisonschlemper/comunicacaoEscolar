package imagem;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

import Model.Aluno;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class AlunoForm extends JFrame {
    private JTextField matriculaField;
    private JTextField cpfField;
    private JTextField nomeField;
    private JTextField sobrenomeField;
    private JTextField emailField;
    private JTextField senhaField;
    private JTextField idadeField;
    private JTextField dataNascimentoField;
    private JTextField dataMatriculaField;
    private JButton cadastrarButton;

    public AlunoForm() {
        setTitle("Cadastro de Aluno");
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define a cor de fundo
        Color backgroundColor = Color.decode("#081D45");
        // Import ImageIcon     
        ImageIcon iconLogo = new ImageIcon("imagem/telaLogin");

        matriculaField = new JTextField(10);
        cpfField = new JTextField(10);
        nomeField = new JTextField(10);
        sobrenomeField = new JTextField(10);
        emailField = new JTextField(10);
        senhaField = new JTextField(10);
        idadeField = new JTextField(10);
        dataNascimentoField = new JTextField(10);
        dataMatriculaField = new JTextField(10);

        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBackground(new Color(0, 128, 0)); // Verde escuro
        cadastrarButton.setForeground(Color.WHITE); // Texto em branco

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        // Define a cor de fundo do painel
        

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        c.gridx = 0;
        c.gridy = 0;
        JLabel matriculaLabel = new JLabel("Matrícula:");
        matriculaLabel.setForeground(Color.WHITE); // Define a cor do texto como preto
        panel.add(matriculaLabel, c);
        c.gridx = 1;
        panel.add(matriculaField, c);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(new JLabel("CPF:"), c);
        c.gridx = 1;
        panel.add(cpfField, c);

        c.gridx = 0;
        c.gridy = 2;
        panel.add(new JLabel("Nome:"), c);
        c.gridx = 1;
        panel.add(nomeField, c);

        c.gridx = 0;
        c.gridy = 3;
        panel.add(new JLabel("Sobrenome:"), c);
        c.gridx = 1;
        panel.add(sobrenomeField, c);

        c.gridx = 0;
        c.gridy = 4;
        panel.add(new JLabel("Email:"), c);
        c.gridx = 1;
        panel.add(emailField, c);

        c.gridx = 0;
        c.gridy = 5;
        panel.add(new JLabel("Senha:"), c);
        c.gridx = 1;
        panel.add(senhaField, c);

        c.gridx = 0;
        c.gridy = 6;
        panel.add(new JLabel("Idade:"), c);
        c.gridx = 1;
        panel.add(idadeField, c);

        c.gridx = 0;
        c.gridy = 7;
        panel.add(new JLabel("Data de Nascimento (yyyy-MM-dd):"), c);
        c.gridx = 1;
        panel.add(dataNascimentoField, c);

        c.gridx = 0;
        c.gridy = 8;
        panel.add(new JLabel("Data de Matrícula (yyyy-MM-dd):"), c);
        c.gridx = 1;
        panel.add(dataMatriculaField, c);

        c.gridx = 0;
        c.gridy = 9;
        c.gridwidth = 2;
        panel.add(cadastrarButton, c);

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("clocio");
            }
        });

        // Defina o Look and Feel para Nimbus, se estiver disponível
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // Use o Look and Feel padrão se Nimbus não estiver disponível
        }

        add(panel);
        setLocationRelativeTo(null); // Centralize o JFrame na tela
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AlunoForm alunoForm = new AlunoForm();
                alunoForm.setVisible(true);
            }
        });
    }
}