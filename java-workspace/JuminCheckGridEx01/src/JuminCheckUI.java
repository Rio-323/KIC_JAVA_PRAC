import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class JuminCheckUI extends JFrame {

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
					JuminCheckUI frame = new JuminCheckUI();
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
	public JuminCheckUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel1.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(10);
		contentPane.add(panel1, BorderLayout.NORTH);
		
		textField1 = new JTextField();
		textField1.setEditable(false);
		panel1.add(textField1);
		textField1.setColumns(20);
		
		JLabel lblNewLabel = new JLabel("~");
		panel1.add(lblNewLabel);
		
		textField2 = new JTextField();
		textField2.setEditable(false);
		panel1.add(textField2);
		textField2.setColumns(20);
		
		JPanel panel2 = new JPanel();
		contentPane.add(panel2, BorderLayout.CENTER);
		panel2.setLayout(new GridLayout(4, 3, 2, 2));
		
		JButton btn1 = new JButton("7");
		panel2.add(btn1);
		
		JButton btn2 = new JButton("8");
		panel2.add(btn2);
		
		JButton btn3 = new JButton("9");
		panel2.add(btn3);
		
		JButton btn4 = new JButton("4");
		panel2.add(btn4);
		
		JButton btn5 = new JButton("5");
		panel2.add(btn5);
		
		JButton btn6 = new JButton("6");
		panel2.add(btn6);
		
		JButton btn7 = new JButton("1");
		panel2.add(btn7);
		
		JButton btn8 = new JButton("2");
		panel2.add(btn8);
		
		JButton btn9 = new JButton("3");
		panel2.add(btn9);
		
		JButton btn10 = new JButton("0");
		panel2.add(btn10);
		
		JButton btn11 = new JButton("DEL");
		panel2.add(btn11);
		
		JButton btn12 = new JButton("검사");
		panel2.add(btn12);
		
		JPanel panel3 = new JPanel();
		contentPane.add(panel3, BorderLayout.SOUTH);
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 15));
		
		textField3 = new JTextField();
		textField3.setEditable(false);
		textField3.setText("결과 :");
		panel3.add(textField3);
		textField3.setColumns(48);
	}
}
