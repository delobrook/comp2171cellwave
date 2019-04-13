package CellwavejaUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.border.*;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.FlowLayout;

public class Functionsui extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Functionsui() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_7 = new JPanel();
		add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));
		
		JButton btnNewButton = new JButton("Calculate Taxes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_7.removeAll();
				panel_7.add(new CalculateTaxesUI(),BorderLayout.CENTER);
				revalidate();
			}
		});
		btnNewButton.setBackground(Color.decode("#B3E4F0"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setMaximumSize(new Dimension(250,60));
		panel.add(btnNewButton);
		panel.add(Box.createRigidArea(new Dimension(0,20)));
		
		JButton btnNewButton_1 = new JButton(" Inventory");
		btnNewButton_1.setBackground(Color.decode("#B3E4F0"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_7.removeAll();
				panel_7.add(new InventoryUI(),BorderLayout.CENTER);
				revalidate();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setMaximumSize(new Dimension(250,60));
		panel.add(btnNewButton_1);
		panel.add(Box.createRigidArea(new Dimension(0,20)));
		
		JButton btnNewButton_3 = new JButton("Calculate Profit/loss");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_7.removeAll();
				panel_7.add(new profitLostUI(),BorderLayout.CENTER);
				revalidate();
			}
		});
		btnNewButton_3.setBackground(Color.decode("#B3E4F0"));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3.setMaximumSize(new Dimension(250,60));
		panel.add(btnNewButton_3);
		panel.add(Box.createRigidArea(new Dimension(0,20)));
		
		JButton btnNewButton_4 = new JButton("Transactions");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_7.removeAll();
				panel_7.add(new TransactionInformationUI(),BorderLayout.CENTER);
				revalidate();
			}
		});
		btnNewButton_4.setBackground(Color.decode("#B3E4F0"));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_4.setMaximumSize(new Dimension(250,60));
		panel.add(btnNewButton_4);
		panel.add(Box.createRigidArea(new Dimension(0,20)));
		
		JButton btnNewButton_5 = new JButton("Customer Information");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_7.removeAll();
				panel_7.add(new CustomerInformationUI(),BorderLayout.CENTER);
				revalidate();
			}
		});
		btnNewButton_5.setBackground(Color.decode("#B3E4F0"));
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_5.setMaximumSize(new Dimension(250,60));
		panel.add(btnNewButton_5);
		
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		panel_1.setPreferredSize(new Dimension(456,50));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(130, 76, 179));
		panel_1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.decode("#8CD4F0"));
		panel_1.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		panel_4.setPreferredSize(new Dimension(456,50));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(102, 51, 153));
		panel_4.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.decode("#8CD4F0"));
		panel_4.add(panel_6);
		
		

	}
}
