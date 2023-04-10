import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class JTableEx01 extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableEx01 frame = new JTableEx01();
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
	public JTableEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 37, 685, 410);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
//		table.setModel(new DefaultTableModel(
//				new Object[][] {
//					{"1", "2", "3", "4", "5"},
//					{null, null, null, null, null},
//				},
//				
//				new String[] {
//						"컬럼명1","컬럼명2", "컬럼명3", "컬럼명4", "컬럼명5"
//				}
//				
//			) {
//				boolean[] columnEditables = new boolean[] {
//						false, false, false, false, false
//				};
//				
//				public boolean isCellEditable(int row, int column) {
//					return columnEditables[column];
//				}
//				
//		});
		
		table.setModel(new CustomTableModel3());
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		
	}

}
