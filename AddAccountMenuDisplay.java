import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddAccountMenuDisplay extends JFrame {

	private JPanel contentPane;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField SocialSNumberTextField;
	private JTextField InitialDepositTextField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAccountMenuDisplay frame = new AddAccountMenuDisplay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddAccountMenuDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setBounds(6, 19, 72, 16);
		contentPane.add(firstNameLabel);

		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(223, 10, 221, 34);
		contentPane.add(firstNameTextField);
		firstNameTextField.setColumns(10);

		JLabel LastNameLabel = new JLabel("Last Name:");
		LastNameLabel.setBounds(6, 65, 83, 16);
		contentPane.add(LastNameLabel);

		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(223, 56, 221, 34);
		contentPane.add(lastNameTextField);
		lastNameTextField.setColumns(10);

		JLabel SocialSNumberLabel = new JLabel("Social Security number:");
		SocialSNumberLabel.setBounds(6, 114, 147, 16);
		contentPane.add(SocialSNumberLabel);

		SocialSNumberTextField = new JTextField();
		SocialSNumberTextField.setBounds(223, 105, 221, 34);
		contentPane.add(SocialSNumberTextField);
		SocialSNumberTextField.setColumns(10);

		JLabel InitialDepositLabel = new JLabel("Initial deposit:");
		InitialDepositLabel.setBounds(6, 160, 115, 16);
		contentPane.add(InitialDepositLabel);

		InitialDepositTextField = new JTextField();
		InitialDepositTextField.setBounds(223, 151, 221, 34);
		contentPane.add(InitialDepositTextField);
		InitialDepositTextField.setColumns(10);

		JLabel AccountTypeLabel = new JLabel("Account Type:");
		AccountTypeLabel.setBounds(6, 201, 115, 16);
		contentPane.add(AccountTypeLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Checking", "Savings" }));
		comboBox.setBounds(223, 188, 221, 44);
		contentPane.add(comboBox);

		JButton okButton = new JButton("Ok");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName="",lastName="",ssn="";
				double deposit=0;
				
				StringBuilder sb = new StringBuilder();
				
				if (firstNameTextField.getText().isEmpty()) {
					sb.append("First Name must not be empty.\n");

				}else{
					firstName= firstNameTextField.getText();
				}
				if (lastNameTextField.getText().isEmpty()) {
					sb.append("Last Name must not be empty.\n");
				}else{
					lastName= lastNameTextField.getText();
				}

				if (!SocialSNumberTextField.getText().matches("(\\d{3}-?){2}\\d{4}")) {
					sb.append("SSN must be 10 digits, xxx-xxx-xxxx.\n");

				}else{
					ssn = SocialSNumberTextField.getText().replace("-", "");
				}
				if(InitialDepositTextField.getText().isEmpty()){
					sb.append("Initial deposit field must be entered");
				}else{
					try{
						deposit = Double.parseDouble(InitialDepositTextField.getText());
					}catch(NumberFormatException ex){
							sb.append("Initial deposit must be a number");
					}	
					
				}
				if (sb.length() > 0) {
					JOptionPane.showMessageDialog(null, sb.toString(), "Input Erro!!!", JOptionPane.WARNING_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null,firstName+ "\n"+lastName+"\n"+ssn+"\n");
				}

			}

		});
		okButton.setBounds(37, 260, 147, 46);
		contentPane.add(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		cancelButton.setBounds(245, 260, 137, 46);
		contentPane.add(cancelButton);
	}
}
