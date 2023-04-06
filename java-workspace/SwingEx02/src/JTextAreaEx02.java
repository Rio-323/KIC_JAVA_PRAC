import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class JTextAreaEx02 extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextArea textArea;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTextAreaEx02 frame = new JTextAreaEx02();
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
	public JTextAreaEx02() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\uAD6C\uAD6C\uB2E8", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 6, 339, 87);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl1 = new JLabel("시작 단 : ");
		lbl1.setBounds(6, 23, 49, 16);
		panel.add(lbl1);
		
		textField1 = new JTextField();
		textField1.setBounds(67, 18, 130, 26);
		panel.add(textField1);
		textField1.setColumns(10);
		
		JLabel lbl2 = new JLabel("끝 단 : ");
		lbl2.setBounds(6, 60, 49, 16);
		panel.add(lbl2);
		
		textField2 = new JTextField();
		textField2.setBounds(67, 55, 130, 26);
		panel.add(textField2);
		textField2.setColumns(10);
		
		JButton btn = new JButton("구구단 출력");
		btn.setBounds(216, 23, 117, 53);
		panel.add(btn);
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (textField1.getText().matches("[0-9]+") && textField2.getText().matches("[0-9]+")) {
					int startDan = Integer.parseInt(textField1.getText());
					int endDan = Integer.parseInt(textField2.getText());
					
					for(int i = startDan; i <= endDan; i++) {
						for(int j = 1; j < 10; j++) {
							textArea.append(String.format("%d X %d = %d\t", i, j, i * j)); 
						}
						textArea.append("\n");
					}
				} else {
					textArea.append("입력 형식을 다시 확인해주세요.");
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 114, 327, 271);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}
