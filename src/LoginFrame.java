import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private playerService playerService;

    public LoginFrame() {
        playerService = new playerService();
        setTitle("Game Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel(" Username:"));
        txtUsername = new JTextField();
        add(txtUsername);

        add(new JLabel(" Password:"));
        txtPassword = new JPasswordField();
        add(txtPassword);

        add(new JLabel(""));
        btnLogin = new JButton("Login");
        add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Input tidak boleh kosong!");
                    return;
                }

                Player player = playerService.login(username, password);
                if (player != null) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Login Berhasil!");
                    MainMenuFrame menuFrame = new MainMenuFrame(player);
                    menuFrame.setVisible(true);
                    LoginFrame.this.dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Username atau Password Salah!");
                }
            }
        });
    }
}
