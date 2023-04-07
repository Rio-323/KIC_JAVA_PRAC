import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JOptionPaneEx01 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPaneEx01 frame = new JOptionPaneEx01();
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
	public JOptionPaneEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1 = new JButton("New button");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 에러 / 경고
				// JOptionPane.showMessageDialog(JOptionPaneEx01.this, "메세지");
				JOptionPane.showMessageDialog(JOptionPaneEx01.this, "메세지", "새타이틀", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btn1.setBounds(6, 25, 117, 29);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("New button");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// JOptionPane.showConfirmDialog(JOptionPaneEx01.this, "메세지");
				int result = JOptionPane.showConfirmDialog(JOptionPaneEx01.this, "메세지", "새 타이틀", JOptionPane.OK_CANCEL_OPTION);
				
				if(result == JOptionPane.OK_OPTION) {
					System.out.println("OK click");
				} else if (result == JOptionPane.CANCEL_OPTION) {
					System.out.println("Cancel click");
				} else {
					System.out.println("ETC");
				}
			}
		});
		btn2.setBounds(6, 66, 117, 29);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("New button");
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String result = JOptionPane.showInputDialog("메세지", "초기값");
				// System.out.println("결과 : " + result);
				
				if(result != null) {
					System.out.println("결과 : " + result);
				} else {
					System.out.println("입력 취소");
				}
				
			}
		});
		btn3.setBounds(6, 107, 117, 29);
		contentPane.add(btn3);
	}
}
