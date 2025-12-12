package forms;

import javax.swing.*;

public class LoginForm extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtClave;
    private JButton btnIngresar;

    public LoginForm() {
        setTitle("Inicio de Sesión");
        setSize(320, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponents();
    }

    private void initComponents() {
        JLabel lblU = new JLabel("Usuario:");
        JLabel lblC = new JLabel("Contraseña:");

        txtUsuario = new JTextField(15);
        txtClave = new JPasswordField(15);
        btnIngresar = new JButton("Ingresar");

        btnIngresar.addActionListener(e -> validarLogin());

        JPanel panel = new JPanel();
        panel.add(lblU);
        panel.add(txtUsuario);
        panel.add(lblC);
        panel.add(txtClave);
        panel.add(btnIngresar);

        add(panel);
    }

    private void validarLogin() {
        String user = txtUsuario.getText();
        String pass = new String(txtClave.getPassword());

        if (user.equals("cliente123") && pass.equals("clave456")) {

            JOptionPane.showMessageDialog(this, "Bienvenido " + user);

            // mandamos SOLO el nombre del usuario
            new BancoForm(user).setVisible(true);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas.");
        }
    }
}
