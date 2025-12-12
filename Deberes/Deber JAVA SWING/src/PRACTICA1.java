import javax.swing.*;
import net.miginfocom.swing.*;

public class PRACTICA1 extends JPanel {

    public PRACTICA1() {
        initComponents();

        // Eventos de botones
        btnSumar.addActionListener(e -> operar("+"));
        btnRestar.addActionListener(e -> operar("-"));
        btnMultiplicar.addActionListener(e -> operar("*"));
        btnDividir.addActionListener(e -> operar("/"));
    }

    private void operar(String op) {
        try {
            double v1 = Double.parseDouble(txtValor1.getText());
            double v2 = Double.parseDouble(txtValor2.getText());
            double r = 0;

            switch (op) {
                case "+" -> r = v1 + v2;
                case "-" -> r = v1 - v2;
                case "*" -> r = v1 * v2;
                case "/" -> {
                    if (v2 == 0) {
                        txtResultado.setText("Error");
                        return;
                    }
                    r = v1 / v2;
                }
            }

            txtResultado.setText(String.valueOf(r));

        } catch (NumberFormatException ex) {
            txtResultado.setText("Inválido");
        }
    }

    // Método main para ejecutar
    public static void main(String[] args) {
        JFrame frame = new JFrame("Operaciones Matemáticas");
        frame.setContentPane(new PRACTICA1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    // ===============================
    // initComponents ORIGINAL DE JFORMDESIGNER
    // ===============================
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Diego
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        txtValor1 = new JTextField();
        txtValor2 = new JTextField();
        txtResultado = new JTextField();
        btnSumar = new JButton();
        btnRestar = new JButton();
        btnMultiplicar = new JButton();
        btnDividir = new JButton();
        this2 = new JPanel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        txtValor3 = new JTextField();
        txtValor4 = new JTextField();
        txtResultado2 = new JTextField();
        btnSUmar2 = new JButton();
        btnRestar2 = new JButton();
        btnMultiplicar2 = new JButton();
        btnDividir2 = new JButton();

        //======== this ========
        setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]",
                // rows
                "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]"));

        //---- label1 ----
        label1.setText("Valor 1");
        add(label1, "cell 3 2");

        //---- label2 ----
        label2.setText("Valor 2");
        add(label2, "cell 6 2");

        //---- label3 ----
        label3.setText("Resultado");
        add(label3, "cell 9 2");
        add(txtValor1, "cell 3 3");
        add(txtValor2, "cell 6 3");
        add(txtResultado, "cell 9 3");

        //---- btnSumar ----
        btnSumar.setText("Sumar");
        add(btnSumar, "cell 1 5");

        //---- btnRestar ----
        btnRestar.setText("Restar");
        add(btnRestar, "cell 4 5");

        //---- btnMultiplicar ----
        btnMultiplicar.setText("Multiplicar");
        add(btnMultiplicar, "cell 7 5");

        //---- btnDividir ----
        btnDividir.setText("Dividir");
        add(btnDividir, "cell 10 5");

        //======== this2 ========
        {
            this2.setLayout(new MigLayout(
                    "hidemode 3",
                    "[fill][fill][fill][fill][fill][fill][fill][fill][fill][fill][fill][fill][fill][fill][fill]",
                    "[][][][][][][]"));

            //---- label4 ----
            label4.setText("Valor 1");
            this2.add(label4, "cell 3 2");

            //---- label5 ----
            label5.setText("Valor 2");
            this2.add(label5, "cell 6 2");

            //---- label6 ----
            label6.setText("Resultado");
            this2.add(label6, "cell 9 2");
            this2.add(txtValor3, "cell 3 3");
            this2.add(txtValor4, "cell 6 3");
            this2.add(txtResultado2, "cell 9 3");

            //---- btnSUmar2 ----
            btnSUmar2.setText("Sumar");
            this2.add(btnSUmar2, "cell 1 5");

            //---- btnRestar2 ----
            btnRestar2.setText("Restar");
            this2.add(btnRestar2, "cell 4 5");

            //---- btnMultiplicar2 ----
            btnMultiplicar2.setText("Multiplicar");
            this2.add(btnMultiplicar2, "cell 7 5");

            //---- btnDividir2 ----
            btnDividir2.setText("Dividir");
            this2.add(btnDividir2, "cell 10 5");
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // ===============================
    // VARIABLES GENERADAS POR JFORMDESIGNER
    // ===============================
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField txtValor1;
    private JTextField txtValor2;
    private JTextField txtResultado;
    private JButton btnSumar;
    private JButton btnRestar;
    private JButton btnMultiplicar;
    private JButton btnDividir;
    private JPanel this2;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JTextField txtValor3;
    private JTextField txtValor4;
    private JTextField txtResultado2;
    private JButton btnSUmar2;
    private JButton btnRestar2;
    private JButton btnMultiplicar2;
    private JButton btnDividir2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
