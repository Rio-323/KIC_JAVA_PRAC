import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JMenuBarEx01 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMenuBarEx01 frame = new JMenuBarEx01();
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
	public JMenuBarEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("파일");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu2 = new JMenu("홈");
		menuBar.add(mnNewMenu2);
		
		JMenuItem mnNewMenuItem_1 = new JMenuItem("New");
		mnNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("새 파일");
			}
		});
		mnNewMenu.add(mnNewMenuItem_1);
		mnNewMenu.addSeparator();
		
		JMenuItem mnNewMenuItem_2 = new JMenuItem("Open");
		mnNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("열기");
			}
		});
		mnNewMenu.add(mnNewMenuItem_2);
		
		JMenuItem mnNewMenuItem_3 = new JMenuItem("Save");
		mnNewMenu.add(mnNewMenuItem_3);
		mnNewMenu.addSeparator();
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("사과");
		mnNewMenu.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("참외");
		chckbxNewCheckBox_1.setSelected(true);
		mnNewMenu.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("수박");
		mnNewMenu.add(chckbxNewCheckBox_2);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
