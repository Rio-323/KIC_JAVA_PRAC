import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class JDialogMainEx02 extends JFrame {

	private JPanel contentPane;
	private JButton btn;
	private JTextField textField1;
	private JTextField textField2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDialogMainEx02 frame = new JDialogMainEx02();
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
	public JDialogMainEx02() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn = new JButton("New button");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JDialogEx02 dialog = new JDialogEx02();
				System.out.println("1");
				
				dialog.setModal(true);
				System.out.println("2");
				
				dialog.setLocationRelativeTo(contentPane);
				System.out.println("3");
				
				dialog.setVisible(true);
				System.out.println("4");
				
				// JFrame -> JDialog -> 생성자, setter
				// JDialog -> JFrame -> getter / 멤버 필드
			}
		});
		btn.setBounds(381, 20, 117, 29);
		contentPane.add(btn);
		
		textField1 = new JTextField();
		textField1.setBounds(6, 20, 363, 26);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(6, 60, 492, 26);
		contentPane.add(textField2);
		textField2.setColumns(10);
	}
}
