import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import model.CustomComboBoxDong;
import model.CustomComboBoxGugun;
import model.CustomComboBoxSido;
import model.ZipcodeTableModel;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ZipcodeComboEx01 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox1;
	private JComboBox comboBox2;
	private JComboBox comboBox3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZipcodeComboEx01 frame = new ZipcodeComboEx01();
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
	public ZipcodeComboEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\uC6B0\uD3B8\uBC88\uD638 \uAC80\uC0C9", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(36, 20, 489, 51);
		contentPane.add(panel);
		panel.setLayout(null);
		
		comboBox1 = new JComboBox();
		comboBox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					String sido = (String)comboBox1.getSelectedItem();
					comboBox2.setModel(new CustomComboBoxGugun(sido));
				}
			}
		});
		comboBox1.setModel(new CustomComboBoxSido());
		comboBox1.setBounds(6, 18, 151, 27);
		panel.add(comboBox1);
		
		comboBox2 = new JComboBox();
		comboBox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					String gugun = (String)comboBox2.getSelectedItem();
					comboBox3.setModel(new CustomComboBoxDong(gugun));
				}
			}
		});
		
		comboBox2.setBounds(169, 18, 151, 27);
		panel.add(comboBox2);
		
		comboBox3 = new JComboBox();
		comboBox3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					String sido = (String)comboBox1.getSelectedItem();
					String gugun = (String)comboBox2.getSelectedItem();
					String dong = (String)comboBox3.getSelectedItem();
					
					table.setModel(new ZipcodeTableModel(sido, gugun, dong));
					table.getColumnModel().getColumn(0).setResizable(false);
					table.getColumnModel().getColumn(1).setResizable(false);
					table.getColumnModel().getColumn(2).setResizable(false);
					table.getColumnModel().getColumn(3).setResizable(false);
					table.getColumnModel().getColumn(4).setResizable(false);
					table.getColumnModel().getColumn(5).setResizable(false);
				}
			}
		});
		comboBox3.setBounds(332, 18, 151, 27);
		panel.add(comboBox3);
		
		table = new JTable();
		table.setBounds(19, 102, 745, 438);
		contentPane.add(table);
	}
}
