import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;


/**
 * @author: Kaushican Uthayakumaran
 * @version: 1.0
 * @date: 13.11.2020
 */

public class TicGUI extends JFrame {

    String spieler = "X";
    JButton[] buttons = new JButton[9];
    JPanel pnlButtons = new JPanel();
    JPanel pnlMain = new JPanel();
    int count = 0;

    int scoreX = 0;
    int scoreO = 0;
    JLabel lblX = new JLabel();
    JLabel lblO = new JLabel();
    JLabel lblCurrentPlayer = new JLabel();
    JPanel pnlScore = new JPanel();

    public TicGUI() {
        setTitle("TicTacToe");
        setSize(500, 500);
        setLocationRelativeTo(null);
        grid();
        lblX.setText("Punkte X:     "+scoreX);
        lblO.setText("Punkte O:     "+scoreO);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public TicGUI(int punkteX, int punkte0) {
        scoreO = punkte0;
        scoreX = punkteX;
        setTitle("TicTacToe");
        setSize(500, 500);
        setLocationRelativeTo(null);
        lblX.setText("Punkte X:     "+scoreX);
        lblO.setText("Punkte O:     "+scoreO);
        grid();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void grid() {

        Border whiteLine = BorderFactory.createLineBorder(Color.white);

        pnlButtons.setLayout(new GridLayout(3, 3, 0, 0));
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setBackground(Color.lightGray);
            buttons[i].setBorder(whiteLine);

            pnlButtons.add(buttons[i]);
        }

        setActionListeners();


        lblCurrentPlayer.setText("Spieler: "+spieler);

        pnlScore.setLayout(new GridLayout(0,3));
        lblX.setHorizontalAlignment(JLabel.LEFT);
        lblCurrentPlayer.setHorizontalAlignment(JLabel.CENTER);
        lblO.setHorizontalAlignment(JLabel.RIGHT);
        pnlScore.add(lblX);
        pnlScore.add(lblCurrentPlayer);
        pnlScore.add(lblO);
        pnlScore.setBorder(new EmptyBorder(20,5,20,20));

        pnlMain.setLayout(new BorderLayout(20, 20));
        pnlMain.add(pnlButtons, BorderLayout.CENTER);

        getContentPane().add(pnlScore,BorderLayout.NORTH);
        getContentPane().add(pnlMain, BorderLayout.CENTER);
    }

    public void setButtonText(JButton button) {
        if (button.getText().equals("")) {
            button.setText(spieler);
            count++;
            if (count == 9){
                JOptionPane.showMessageDialog(null, "Unentschieden", "Kein Gewinner", JOptionPane.OK_OPTION);
                new TicGUI(scoreX,scoreO);
                this.dispose();
            }
            checkWinner();
            playerChange();
        }
    }

    public void setActionListeners() {
        buttons[0].addActionListener(actionEvent -> setButtonText(buttons[0]));
        buttons[1].addActionListener(actionEvent -> setButtonText(buttons[1]));
        buttons[2].addActionListener(actionEvent -> setButtonText(buttons[2]));
        buttons[3].addActionListener(actionEvent -> setButtonText(buttons[3]));
        buttons[4].addActionListener(actionEvent -> setButtonText(buttons[4]));
        buttons[5].addActionListener(actionEvent -> setButtonText(buttons[5]));
        buttons[6].addActionListener(actionEvent -> setButtonText(buttons[6]));
        buttons[7].addActionListener(actionEvent -> setButtonText(buttons[7]));
        buttons[8].addActionListener(actionEvent -> setButtonText(buttons[8]));
    }

    public void playerChange() {
        if (spieler == "X") {
            spieler = "O";
            lblCurrentPlayer.setText("Spieler: "+spieler);
        } else if (spieler == "O") {
            spieler = "X";
            lblCurrentPlayer.setText("Spieler: "+spieler);
        }
    }

    public void checkWinner() {
        if (buttons[0].getText().equals(spieler)&& buttons[0].getText().equals(buttons[1].getText()) && buttons[0].getText().equals(buttons[2].getText()))
            winnerStatus();
        else if (buttons[0].getText().equals(spieler)&&buttons[0].getText().equals(buttons[3].getText()) && buttons[0].getText().equals(buttons[6].getText()))
            winnerStatus();
        else if (buttons[0].getText().equals(spieler)&&buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText()))
            winnerStatus();
        else if (buttons[3].getText().equals(spieler)&&buttons[3].getText().equals(buttons[4].getText()) && buttons[3].getText().equals(buttons[5].getText()))
            winnerStatus();
        else if (buttons[6].getText().equals(spieler)&&buttons[6].getText().equals(buttons[7].getText()) && buttons[6].getText().equals(buttons[8].getText()))
            winnerStatus();
        else if (buttons[1].getText().equals(spieler)&&buttons[1].getText().equals(buttons[4].getText()) && buttons[1].getText().equals(buttons[7].getText()))
            winnerStatus();
        else if (buttons[2].getText().equals(spieler)&&buttons[2].getText().equals(buttons[5].getText()) && buttons[2].getText().equals(buttons[8].getText()))
            winnerStatus();
        else if (buttons[2].getText().equals(spieler)&&buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText()))
            winnerStatus();
    }

    public void winnerStatus() {
        JOptionPane.showMessageDialog(null, "Spieler " + spieler + " hat gewonnen", "Gewinner", JOptionPane.OK_OPTION);
        if(spieler.equals("X")){
            scoreX++;
        }else if(spieler.equals("O")){
            scoreO++;
        }
        new TicGUI(scoreX,scoreO);
        this.dispose();
    }

    public static void main(String[] args) {
        TicGUI ticGUI = new TicGUI();
    }

}
