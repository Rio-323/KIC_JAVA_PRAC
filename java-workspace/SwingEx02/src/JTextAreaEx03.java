import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JTextAreaEx03 extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTextAreaEx03 frame = new JTextAreaEx03();
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
	public JTextAreaEx03() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uAD6C\uAD6C\uB2E8", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 21, 766, 98);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl1 = new JLabel("시작단");
		lbl1.setBounds(12, 32, 57, 15);
		panel.add(lbl1);
		
		textField1 = new JTextField();
		textField1.setBounds(81, 29, 525, 21);
		panel.add(textField1);
		textField1.setColumns(10);
		
		JLabel lbl2 = new JLabel("끝단");
		lbl2.setBounds(12, 62, 57, 15);
		panel.add(lbl2);
		
		textField2 = new JTextField();
		textField2.setBounds(81, 60, 525, 21);
		panel.add(textField2);
		textField2.setColumns(10);
		
		JButton btn = new JButton("구구단 출력");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (textField1.getText().matches("[0-9]+") && textField2.getText().matches("[0-9]+")) {
					int startDan = Integer.parseInt(textField1.getText());
					int endDan = Integer.parseInt(textField2.getText());
					
					textArea.setText("");
					
					if(startDan >= endDan ) {
						textArea.append("입력 형식을 다시 확인해주세요.");
					} else {
						for(int i = startDan; i <= endDan; i++) {
							for(int j = 1; j < 10; j++) {
								textArea.append(String.format("%d X %d = %d\t", i, j, i * j)); 
							}
							textArea.append("\n");
						}
					}
				} else {
					textArea.append("입력 형식을 다시 확인해주세요.");
				}
				
			}
		});
		btn.setBounds(621, 28, 133, 49);
		panel.add(btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 136, 760, 415);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	}
}
