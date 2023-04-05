import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JuminCheckEx01 extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JLabel lbl;

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
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField1 = new JTextField();
		textField1.setBounds(6, 6, 130, 26);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(162, 6, 130, 26);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		JButton btn = new JButton("주민 번호 검사");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str1 = textField1.getText();
				String str2 = textField2.getText();
				
				String strJumin = str1 + str2;
				
				int[] number = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
				int tot = 0;
				
				if(strJumin.length() == 0 || str1.length() == 0 || str2.length() == 0) {
					lbl.setText("형식을 다시 확인해주세요");
				} else {
					
					for (int i = 0; i < strJumin.length() - 1; i++) {
						tot += Integer.parseInt(strJumin.substring(i, i + 1)) * number[i];
					}

					int lastNum = Integer.parseInt(strJumin.substring(12, 13));
					
					int resultNum = (11 - (tot % 11)) % 10;
					
					if(lastNum == resultNum) {
						lbl.setText("주민등록 형식이 맞음");
					} else {
						lbl.setText("주민등록 형식이 아님");
					}	
				}
				
			}
		});
		btn.setBounds(304, 6, 117, 29);
		contentPane.add(btn);
		
		lbl = new JLabel("결과");
		lbl.setBounds(6, 57, 415, 16);
		contentPane.add(lbl);
	}

}
