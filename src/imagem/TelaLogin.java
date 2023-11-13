package imagem;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;

public class TelaLogin extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaLogin frame = new TelaLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public TelaLogin() {
        setResizable(false); // Impede o redimensionamento
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setPreferredSize(new Dimension(800, 700)); // Define o tamanho personalizado para o contentPane
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel();
        lblNewLabel.setLayout(null); // Define um layout absoluto

        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\gleison.schlemper\\OneDrive\\Área de Trabalho\\comunicacaoEscolar\\src\\imagem\\Leonardo_Diffusion_XL_Estou_em_busca_de_um_design_com_cores_es_0 (1).jpg"));

        JLabel labelTexte = new JLabel("Olá mundo");
        labelTexte.setFont(new Font("Tahoma", Font.PLAIN, 20)); // Define a fonte e o tamanho do texto
        labelTexte.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza o texto horizontalmente
        labelTexte.setBounds(0, 500, 800, 100); // Define as coordenadas e o tamanho do texto
        labelTexte.setBackground(new Color(0, 128, 0)); // Verde escuro
        lblNewLabel.add(labelTexte);
        contentPane.add(lblNewLabel);

        pack(); // Redimensiona o JFrame para caber seus componentes
        setLocationRelativeTo(null); // Centraliza o JFrame na tela
    }
}
