package ifsc.poo.joe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
    private JPanel principal;
    private JPanel painelLateral;
    private JPanel painelTela;
    private JButton bCriaAldeao;
    private JButton bCriaArqueiro;
    private JButton bCriaCavaleiro;
    private JRadioButton todosRadioButton;
    private JRadioButton aldeaoRadioButton;
    private JRadioButton arqueiroRadioButton;
    private JRadioButton cavaleiroRadioButton;
    private JButton atacarButton;
    private JButton buttonCima;
    private JButton buttonEsquerda;
    private JButton buttonBaixo;
    private JButton buttonDireita;
    private JLabel logo;
    private Random sorteio;


    public Main() {
        this.sorteio = new Random();

        atacarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO preciso ser melhorado

                if (aldeaoRadioButton.isSelected()) {
                    ((Screen) painelTela).atacarAldeao();
                }
            }
        });
        buttonCima.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO preciso ser melhorado

                ((Screen) painelTela).movimentarAldeao(0);
            }
        });
        buttonBaixo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO preciso ser melhorado

                ((Screen) painelTela).movimentarAldeao(1);
            }
        });
        buttonEsquerda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO preciso ser melhorado

                ((Screen) painelTela).movimentarAldeao(2);
            }
        });
        buttonDireita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO preciso ser melhorado

                ((Screen) painelTela).movimentarAldeao(3);
            }
        });

        bCriaAldeao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //obtendo o tamanho do JPanel TELA
                int largura = painelTela.getWidth();
                int altura = painelTela.getHeight();

                // criando o aldeao em um local aleatorio
                int x = sorteio.nextInt(largura - 50);
                int y = sorteio.nextInt(altura - 50);
                if (x < 0) { // garantindo que x não esteja fora do limite do JPanel
                    x = 0;
                }
                if (y < 0) { // garantindo que x não esteja fora do limite do JPanel
                    y = 0;
                }

                // invocando o método criarAldeao da classe Tela.
                // Foi necessário a coerção de tipos pois painelTela é do tipo JPanel.
                // Isso só foi possível pois Tela é uma subclasse de JPanel.
                ((Screen) painelTela).criarAldeao(x, y);
            }
        });

        bCriaArqueiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO preciso ser implementado
                JOptionPane.showMessageDialog(null, "Preciso ser implementado", "Criar Arqueiro", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        bCriaCavaleiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO preciso ser implementado
                JOptionPane.showMessageDialog(null, "Preciso ser implementado", "Criar Cavaleiro", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Java of Empires");
        Main m = new Main();
        frame.setContentPane(m.principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // não será possível redimensionar a janela
        frame.setResizable(false);
        frame.pack();

        // janela deverá ficar centralizada
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        this.painelTela = new Screen();
    }
}
