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
                case "+" -> r = v2 + v1;
                case "-" -> r = v2 - v1;
                case "*" -> r = v2 * v1;
                case "/" -> {
                    if (v2 == 0) {
                        txtResultado.setText("Error");
                        return;
                    }
                    r = v2 / v1;
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

    private void initComponents() {
        // JFormDesigner - Component initialization
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

        setLayout(new MigLayout("wrap 3", "[grow,fill][grow,fill][grow,fill]"));

        label1.setText("Valor 1");
        add(label1);
        add(txtValor1);

        label2.setText("Valor 2");
        add(label2);
        add(txtValor2);

        label3.setText("Resultado");
        txtResultado.setEditable(false);
        add(label3);
        add(txtResultado);

        btnSumar.setText("Sumar");
        btnRestar.setText("Restar");
        btnMultiplicar.setText("Multiplicar");
        btnDividir.setText("Dividir");

        add(btnSumar);
        add(btnRestar);
        add(btnMultiplicar);
        add(btnDividir);
    }

    // Variables
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
}
