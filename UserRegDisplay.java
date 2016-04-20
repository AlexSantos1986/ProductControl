import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ModelClasses.RegisterUsers;
import loginQueries.LoginQueries;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class UserRegDisplay extends JFrame {

	private RegisterUsers regUser;
	private List<RegisterUsers> regUserList;
	private LoginQueries loginQueries;
	

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldusername;
	private JPasswordField passwordTextField;
	private JPasswordField confirmPasswordTextField;
	private JTextField textFieldEmail;
	private JTextField textFieldMobilePhone;
	private JButton SaveButton;
	private JPanel panel;
	private JLabel nameLabel;
	private JLabel PasswordLabel;
	private JLabel UsernameLable;
	private JLabel ConfirmpasswordLabel;
	private JButton backToWelcomePageButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegDisplay frame = new UserRegDisplay();

					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UserRegDisplay() {
		super("Registration Form");
		loginQueries = new LoginQueries();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 647, 553);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(64, 64, 64), new Color(128, 128, 128),
				new Color(192, 192, 192), new Color(128, 128, 128)));
		panel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel.setBounds(16, 47, 606, 464);
		contentPane.add(panel);
		panel.setLayout(null);

		nameLabel = new JLabel("Name:");
		nameLabel.setToolTipText("");
		nameLabel.setBounds(41, 39, 61, 16);
		panel.add(nameLabel);

		PasswordLabel = new JLabel("Password:");
		PasswordLabel.setBounds(41, 290, 108, 16);
		panel.add(PasswordLabel);

		UsernameLable = new JLabel("UserName:");
		UsernameLable.setBounds(41, 96, 84, 16);
		panel.add(UsernameLable);

		ConfirmpasswordLabel = new JLabel("Confirm password:");
		ConfirmpasswordLabel.setBounds(41, 356, 125, 16);
		panel.add(ConfirmpasswordLabel);

		textFieldName = new JTextField();
		textFieldName.setToolTipText("enter your name");
		textFieldName.setBounds(37, 58, 230, 26);
		panel.add(textFieldName);
		textFieldName.setColumns(10);

		textFieldusername = new JTextField();
		textFieldusername.setToolTipText("enter your user name");
		textFieldusername.setBounds(41, 124, 230, 26);
		panel.add(textFieldusername);
		textFieldusername.setColumns(10);

		passwordTextField = new JPasswordField();
		passwordTextField.setToolTipText("enter your password");
		passwordTextField.setBounds(41, 318, 230, 26);
		panel.add(passwordTextField);

		confirmPasswordTextField = new JPasswordField();
		confirmPasswordTextField.setToolTipText("confirm your password");
		confirmPasswordTextField.setBounds(41, 384, 231, 26);
		panel.add(confirmPasswordTextField);

		SaveButton = new JButton("SAVE");
		SaveButton.setToolTipText("click to register");
		SaveButton.setSelected(false);

		SaveButton.setBounds(360, 87, 183, 28);
		panel.add(SaveButton);
		SaveButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int result = 0;

				if (textFieldName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Name must not be empty","Input Error",JOptionPane.WARNING_MESSAGE);
					textFieldName.requestFocus();
				} else if (textFieldusername.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "userName must not be empty","Input Error",JOptionPane.WARNING_MESSAGE);
					textFieldusername.requestFocus();
				} else if (textFieldEmail.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "email must not be empty","Input Error",JOptionPane.WARNING_MESSAGE);
					textFieldEmail.requestFocus();
				} else if (textFieldMobilePhone.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Phone must not be empty","Input Error",JOptionPane.WARNING_MESSAGE);
					textFieldMobilePhone.requestFocus();
				} else if (passwordTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Password must not be empty","Input Error",JOptionPane.WARNING_MESSAGE);
					passwordTextField.requestFocus();
				} else if (confirmPasswordTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Confirm Password must not be empty");
					confirmPasswordTextField.requestFocus();
				} else
					result = loginQueries.addUserLogin(textFieldName.getText(), textFieldusername.getText(),
							textFieldEmail.getText(), textFieldMobilePhone.getText(), passwordTextField.getText(),
							confirmPasswordTextField.getText());

				if (result == 1) {

					JOptionPane.showMessageDialog(null, "Person added successfully!", "Person added!!",
							JOptionPane.PLAIN_MESSAGE);

				} else

					JOptionPane.showMessageDialog(null, "Person not added", "Error!!!", JOptionPane.WARNING_MESSAGE);

			}

		});

		JLabel EmailLabel = new JLabel("Email-address:");
		EmailLabel.setBounds(41, 156, 113, 16);
		panel.add(EmailLabel);

		textFieldEmail = new JTextField();
		textFieldEmail.setToolTipText("enter your email-address");
		textFieldEmail.setBounds(41, 184, 230, 28);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		JLabel mobilePhoneLabel = new JLabel("MobilePhone:");
		mobilePhoneLabel.setBounds(41, 224, 87, 16);
		panel.add(mobilePhoneLabel);

		textFieldMobilePhone = new JTextField();
		textFieldMobilePhone.setToolTipText("enter your mobile Phone");
		textFieldMobilePhone.setBounds(41, 252, 230, 26);
		panel.add(textFieldMobilePhone);
		textFieldMobilePhone.setColumns(10);

		JButton cancelButton = new JButton("CANCEL");
		cancelButton.setToolTipText("click to cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		cancelButton.setBounds(360, 185, 189, 27);
		panel.add(cancelButton);

		backToWelcomePageButton = new JButton("BACK TO WELCOME PAGE");
		backToWelcomePageButton.setToolTipText("click to go back to welcome page");
		backToWelcomePageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomeDisplay wDisplay = new WelcomeDisplay();
				wDisplay.setVisible(true);
				dispose();
			}
		});
		backToWelcomePageButton.setBounds(360, 137, 189, 26);
		panel.add(backToWelcomePageButton);

		JLabel UserRegistrationForm = new JLabel("Self Registration - Enter User Details ");
		UserRegistrationForm.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		UserRegistrationForm.setBounds(61, 6, 481, 27);
		contentPane.add(UserRegistrationForm);
	}

}
