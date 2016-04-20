import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.DropMode;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaffAccountDisplay extends JFrame {
	JTable table;
	String [] headers = {"First Name","Last Name","Account Number","Balance"}; 
	private JTable table_1;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffAccountDisplay frame = new StaffAccountDisplay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public StaffAccountDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 447);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JButton removeAccontButton = new JButton("Remove Account");
		removeAccontButton.setBounds(165, 21, 149, 29);
		getContentPane().add(removeAccontButton);
		
		JButton addAccountButton = new JButton("Add Account");
		addAccountButton.setBounds(30, 21, 117, 29);
		addAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAccountMenuDisplay addAccount = new AddAccountMenuDisplay();
				addAccount.setVisible(true);
				
			}
			
		});
		getContentPane().add(addAccountButton);
		
		JButton depositButton = new JButton("Deposit");
		depositButton.setBounds(326, 21, 93, 29);
		getContentPane().add(depositButton);
		
		JButton withDrawButton_3 = new JButton("Withdraw");
		withDrawButton_3.setBounds(431, 21, 102, 29);
		getContentPane().add(withDrawButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 97, 458, 253);
		scrollPane.setViewportBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		scrollPane.setName("\n");
		getContentPane().add(scrollPane);
		
		DefaultTableModel t = new DefaultTableModel(new String [][] {
			{"dsd","dsd"},{"ds","dsd"} }, new String [] {"sds","dsd"});
		
		table_1 = new JTable(t);
		table_1.setBorder(new TitledBorder(null, "etee", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table_1);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenuBar = new JMenu("File");
		menuBar.add(fileMenuBar);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		fileMenuBar.add(mntmExit);
		
		JMenu editMenuBar = new JMenu("Edit");
		menuBar.add(editMenuBar);
		
		table = new JTable();
		
	}
}
