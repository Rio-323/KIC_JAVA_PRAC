import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

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
		btn7.addMouseListener(new UserMouseEvent());
		btn7.setName("btn7");
		panel_1.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addMouseListener(new UserMouseEvent());
		btn8.setName("btn8");
		panel_1.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addMouseListener(new UserMouseEvent());
		btn9.setName("btn9");
		panel_1.add(btn9);
		
		JButton btn4 = new JButton("4");
		btn4.addMouseListener(new UserMouseEvent());
		btn4.setName("btn4");
		panel_1.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addMouseListener(new UserMouseEvent());
		btn5.setName("btn5");
		panel_1.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addMouseListener(new UserMouseEvent());
		btn6.setName("btn6");
		panel_1.add(btn6);
		
		JButton btn1 = new JButton("1");
		btn1.addMouseListener(new UserMouseEvent());
		btn1.setName("btn1");
		panel_1.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addMouseListener(new UserMouseEvent());
		btn2.setName("btn2");
		panel_1.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addMouseListener(new UserMouseEvent());
		btn3.setName("btn3");
		panel_1.add(btn3);
		
		JButton btn0 = new JButton("0");
		btn0.addMouseListener(new UserMouseEvent());
		btn0.setName("btn0");
		panel_1.add(btn0);
		
		JButton btnDel = new JButton("Del");
		btnDel.addMouseListener(new UserMouseEvent());
		btnDel.setName("btnDEL");
		panel_1.add(btnDel);
		
		JButton btnCheck = new JButton("검사");
		btnCheck.addMouseListener(new UserMouseEvent());
		btnCheck.setName("btnCheck");
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
	
	class UserMouseEvent extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			
			String name = ((JButton)e.getSource()).getName();
			
			if(textField1.getText().length() <= 6) {
				switch(name) {
				case "btn0" : textField1.setText(textField1.getText() + "0"); break;
				case "btn1" : textField1.setText(textField1.getText() + "1"); break;
				case "btn2" : textField1.setText(textField1.getText() + "2"); break;
				case "btn3" : textField1.setText(textField1.getText() + "3"); break;
				case "btn4" : textField1.setText(textField1.getText() + "4"); break;
				case "btn5" : textField1.setText(textField1.getText() + "5"); break;
				case "btn6" : textField1.setText(textField1.getText() + "6"); break;
				case "btn7" : textField1.setText(textField1.getText() + "7"); break;
				case "btn8" : textField1.setText(textField1.getText() + "8"); break;
				case "btn9" : textField1.setText(textField1.getText() + "9"); break;
				case "btnDel" : if(textField1.getText().length() > 0) { String newText = textField1.getText().substring(0, textField1.getText().length() - 1); textField1.setText(newText); } break; }
			} else if(textField1.getText().length() > 6) {
				JOptionPane.showMessageDialog(JuminCheckEx01.this, "주민 등록 번호는 6자리를 넘을 수 없습니다.", "[Error]", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
