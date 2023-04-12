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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuminCheckUI2 extends JFrame {

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
					JuminCheckUI2 frame = new JuminCheckUI2();
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
	public JuminCheckUI2() {

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

		
		 ActionListener numberButtonListener = new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                JButton clickedButton = (JButton) e.getSource();
	                String buttonText = clickedButton.getText();

	                if (textField1.getText().length() < 6) {
	                    textField1.setText(textField1.getText() + buttonText);
	                } else {
	                    textField2.setText(textField2.getText() + buttonText);
	                }
	            }
	        };

	        // 숫자 버튼에 ActionListener 추가

	        btn1.addActionListener(numberButtonListener);
	        btn2.addActionListener(numberButtonListener);
	        btn3.addActionListener(numberButtonListener);
	        btn4.addActionListener(numberButtonListener);
	        btn5.addActionListener(numberButtonListener);
	        btn6.addActionListener(numberButtonListener);
	        btn7.addActionListener(numberButtonListener);
	        btn8.addActionListener(numberButtonListener);
	        btn9.addActionListener(numberButtonListener);
	        btn10.addActionListener(numberButtonListener);

	        // 'DEL' 버튼에 ActionListener 추가

	        btn11.addActionListener(new ActionListener() {

	            public void actionPerformed(ActionEvent e) {

	                if (textField2.getText().length() > 0) {
	                    textField2.setText(textField2.getText().substring(0, textField2.getText().length() - 1));

	                } else if (textField1.getText().length() > 0) {
	                    textField1.setText(textField1.getText().substring(0, textField1.getText().length() - 1));
	                }
	            }
	        });

	        // '검사' 버튼에 ActionListener 추가
	        btn12.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String juminNo = textField1.getText() + textField2.getText();
	                if (isValidJuminNo(juminNo)) {
	                    textField3.setText("결과 : 정상");
	                } else {
	                    textField3.setText("결과 : 비정상");
	                }
	            }
	        });
	    }

	    private boolean isValidJuminNo(String juminNo) {
	        if (juminNo.length() != 13) {
	            return false;
	        }

	        int[] weight = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
	        int sum = 0;

	        for (int i = 0; i < 12; i++) {
	            sum += (juminNo.charAt(i) - '0') * weight[i];
	        }

	        int lastNumber = (11 - (sum % 11)) % 10;
	        return juminNo.charAt(12) - '0' == lastNumber;
	    }
}

