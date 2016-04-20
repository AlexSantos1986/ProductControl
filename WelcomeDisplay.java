import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class WelcomeDisplay extends JFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeDisplay frame = new WelcomeDisplay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public WelcomeDisplay() {
		super("Welcome Page");

		setResizable(false);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(692, 600);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnRegister = new JMenu("Register");
		mnRegister.setToolTipText("register");
		menuBar.add(mnRegister);

		JMenuItem mntmCustomer = new JMenuItem("User Registration");
		mntmCustomer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

			}
		});
		mntmCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserRegDisplay user = new UserRegDisplay();
				user.setVisible(true);
				dispose();
			}
		});
		mnRegister.add(mntmCustomer);

		JMenu mnMenu = new JMenu("Menu");
		mnMenu.setToolTipText("Menu");
		menuBar.add(mnMenu);

		JMenuItem mntmCustomerAccountManager = new JMenuItem("Staff Account Manager");
		mntmCustomerAccountManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffAccountDisplay staffAccount = new StaffAccountDisplay();
				staffAccount.setVisible(true);
				dispose();
			}
		});
		mnMenu.add(mntmCustomerAccountManager);

		JMenu mnLogIn = new JMenu("Login");
		mnLogIn.setToolTipText("login");
		menuBar.add(mnLogIn);

		JMenuItem mntmCustomerLogin_1 = new JMenuItem("Customer login");
		mntmCustomerLogin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		mntmCustomerLogin_1.setToolTipText("Login");

		mnLogIn.add(mntmCustomerLogin_1);

		JMenu mnLogout = new JMenu("Exit");
		mnLogout.setToolTipText("Logout");
		menuBar.add(mnLogout);

		JMenuItem mntmCustomerLogout = new JMenuItem("Exit");
		mntmCustomerLogout.setIcon(new ImageIcon(WelcomeDisplay.class.getResource("/img/cross-button-icon.png")));
		mntmCustomerLogout.setToolTipText("Logout");
		mntmCustomerLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginDisplay log = new LoginDisplay();
				log.setVisible(true);
				dispose();
			}
		});
		mnLogout.add(mntmCustomerLogout);
		getContentPane().setLayout(null);

		JInternalFrame internalFrame = new JInternalFrame("Welcome");
		internalFrame.setResizable(true);
		internalFrame.setToolTipText("Welcome Page");
		internalFrame.setClosable(true);
		internalFrame.setFocusTraversalPolicyProvider(true);
		internalFrame.setFocusCycleRoot(false);
		internalFrame.setBounds(17, 87, 657, 469);
		getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		internalFrame.setVisible(true);

		JButton ButtonRegister = new JButton("");
		ButtonRegister.setToolTipText("Click to register");
		ButtonRegister.setIcon(new ImageIcon(WelcomeDisplay.class.getResource("/img/register-now.jpg")));
		ButtonRegister.setBackground(Color.ORANGE);
		ButtonRegister.setBounds(29, 35, 120, 131);
		internalFrame.getContentPane().add(ButtonRegister);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel
				.setIcon(new ImageIcon(WelcomeDisplay.class.getResource("/img/plain-blue-background-wallpaper-1.jpg")));
		lblNewLabel.setBounds(0, 6, 692, 564);
		getContentPane().add(lblNewLabel);
		ButtonRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				UserRegDisplay reg = new UserRegDisplay();
				reg.setVisible(true);
				dispose();

			}
		});

	}
}
