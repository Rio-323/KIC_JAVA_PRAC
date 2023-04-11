import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GugudanMainEx01 extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GugudanMainEx01 frame = new GugudanMainEx01();
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
	public GugudanMainEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField1 = new JTextField();
		textField1.setBounds(56, 19, 130, 26);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(56, 57, 130, 26);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("시작 단 : ");
		lblNewLabel.setBounds(6, 24, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("끝 단 : ");
		lblNewLabel_1.setBounds(6, 62, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GugudanDialogEx01 dialog = new GugudanDialogEx01(textField1.getText(), textField2.getText());
				dialog.setModal(true);
				dialog.setLocationRelativeTo(contentPane);
				dialog.setVisible(true);
			}
		});
		btnNewButton.setBounds(216, 19, 117, 64);
		contentPane.add(btnNewButton);
	}
}
