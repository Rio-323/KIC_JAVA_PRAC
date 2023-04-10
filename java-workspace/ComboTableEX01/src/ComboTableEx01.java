import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import model.CustomComboBoxModel;
import model.EmpTableModel;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;

public class ComboTableEx01 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox;
	private String jobName;
	private String ename;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboTableEx01 frame = new ComboTableEx01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ComboTableEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\uC9C1\uCC45\uBCC4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(14, 7, 630, 51);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("직책");
		lblNewLabel.setBounds(6, 22, 32, 16);
		panel.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					jobName = (String)comboBox.getSelectedItem();
					ename = jobName.toLowerCase();
					
					table.setModel(new EmpTableModel(ename));
					table.getColumnModel().getColumn(0).setResizable(false);
					table.getColumnModel().getColumn(1).setResizable(false);
					table.getColumnModel().getColumn(2).setResizable(false);
					table.getColumnModel().getColumn(3).setResizable(false);
					table.getColumnModel().getColumn(4).setResizable(false);
					table.getColumnModel().getColumn(5).setResizable(false);
					table.getColumnModel().getColumn(6).setResizable(false);
				}
			}
		});
		comboBox.setModel(new CustomComboBoxModel());
		comboBox.setBounds(50, 18, 574, 27);
		panel.add(comboBox);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 100, 630, 346);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
	}
}
