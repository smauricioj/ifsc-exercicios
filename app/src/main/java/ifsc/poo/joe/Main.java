package ifsc.poo.joe;

import ifsc.poo.joe.enums.Direcao;

import javax.swing.*;
import java.util.Random;

public class Main {
    private JPanel painelTela;
    private JPanel principal;
    private JPanel painelLateral;
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
    private final Random sorteio;

    public Main() {
        this.sorteio = new Random();

        atacarButton.addActionListener(e -> {
            //TODO preciso ser melhorado

            if (aldeaoRadioButton.isSelected()) {
                ((Screen) painelTela).atacarAldeao();
            }
        });

        buttonCima.addActionListener(e -> {
            //TODO preciso ser melhorado

            ((Screen) painelTela).movimentarAldeao(Direcao.CIMA);
        });

        buttonBaixo.addActionListener(e -> {
            //TODO preciso ser melhorado

            ((Screen) painelTela).movimentarAldeao(Direcao.BAIXO);
        });

        buttonEsquerda.addActionListener(e -> {
            //TODO preciso ser melhorado

            ((Screen) painelTela).movimentarAldeao(Direcao.ESQUERDA);
        });

        buttonDireita.addActionListener(e -> {
            //TODO preciso ser melhorado

            ((Screen) painelTela).movimentarAldeao(Direcao.DIREITA);
        });

        bCriaAldeao.addActionListener(e -> {
            // criando o aldeao em um local aleatorio
            final int PADDING = 50;
            int posX = sorteio.nextInt(painelTela.getWidth() - 2 * PADDING) + PADDING;
            int posY = sorteio.nextInt(painelTela.getHeight() - 2 * PADDING) + PADDING;

            // invocando o método criarAldeao da classe Tela.
            ((Screen) painelTela).criarAldeao(posX, posY);
        });

        bCriaArqueiro.addActionListener(e -> {
            //TODO preciso ser implementado
            JOptionPane.showMessageDialog(null, "Preciso ser implementado", "Criar Arqueiro", JOptionPane.INFORMATION_MESSAGE);
        });

        bCriaCavaleiro.addActionListener(e -> {
            //TODO preciso ser implementado
            JOptionPane.showMessageDialog(null, "Preciso ser implementado", "Criar Cavaleiro", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Java of Empires");
        frame.setContentPane((new Main()).principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // não será possível redimensionar a janela
        frame.setResizable(false);
        frame.pack();

        // janela deverá ficar centralizada
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    private void createUIComponents() {
        this.painelTela = new Screen();
    }
}
