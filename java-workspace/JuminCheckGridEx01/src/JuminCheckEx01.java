import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class JuminCheckEx01 extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuminCheckEx01 frame = new JuminCheckEx01();
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
	public JuminCheckEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		textField1 = new JTextField();
		panel.add(textField1);
		textField1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("~");
		panel.add(lblNewLabel);
		
		textField2 = new JTextField();
		panel.add(textField2);
		textField2.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(4, 3, 0, 0));
		
		JButton btn7 = new JButton("7");
		panel_1.add(btn7);
		
		JButton btn8 = new JButton("8");
		panel_1.add(btn8);
		
		JButton btn9 = new JButton("9");
		panel_1.add(btn9);
		
		JButton btn4 = new JButton("4");
		panel_1.add(btn4);
		
		JButton btn5 = new JButton("5");
		panel_1.add(btn5);
		
		JButton btn6 = new JButton("6");
		panel_1.add(btn6);
		
		JButton btn1 = new JButton("1");
		panel_1.add(btn1);
		
		JButton btn2 = new JButton("2");
		panel_1.add(btn2);
		
		JButton btn3 = new JButton("3");
		panel_1.add(btn3);
		
		JButton btn0 = new JButton("0");
		panel_1.add(btn0);
		
		JButton btnDel = new JButton("Del");
		panel_1.add(btnDel);
		
		JButton btnCheck = new JButton("검사");
		panel_1.add(btnCheck);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("결과 : ");
		panel_2.add(lblNewLabel_1);
		
		textField3 = new JTextField();
		panel_2.add(textField3);
		textField3.setColumns(10);
	}

}
