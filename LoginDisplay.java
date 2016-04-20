import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ModelClasses.RegisterUsers;
import loginQueries.LoginQueries;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class LoginDisplay extends JFrame {

	private JFrame frame;
	private RegisterUsers regUser;
	private List<RegisterUsers> regUserList;
	private LoginQueries loginQueries;

	private JPanel contentPane;
	private JTextField userNametextField;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDisplay loginDisplay = new LoginDisplay();
					loginDisplay.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginDisplay() {

		super("Login Page");
		frame = new JFrame();
		loginQueries = new LoginQueries();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 563, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		userNametextField = new JTextField();
		userNametextField.setBounds(299, 203, 155, 36);
		contentPane.add(userNametextField);
		userNametextField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(299, 251, 155, 36);
		contentPane.add(passwordField);

		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setBounds(210, 213, 68, 16);
		contentPane.add(lblUsername);

		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setBounds(210, 261, 77, 16);
		contentPane.add(lblNewLabel);

		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				regUserList = loginQueries.loginUsers(userNametextField.getText(), passwordField.getText());
				int result = regUserList.size();

				if (result != 0) {

					WelcomeDisplay welcomeDisplay = new WelcomeDisplay();
					welcomeDisplay.setVisible(true);
					dispose();
				} else
					JOptionPane.showMessageDialog(null, "User Name or Password incorrect");

			}

		});

		loginButton.setBounds(210, 321, 108, 29);
		contentPane.add(loginButton);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnLogout.setBounds(352, 321, 108, 29);
		contentPane.add(btnLogout);
	}
}
