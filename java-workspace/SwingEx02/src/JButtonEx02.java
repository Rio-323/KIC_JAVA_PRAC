import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JButtonEx02 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JButtonEx02 frame = new JButtonEx02();
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
	public JButtonEx02() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1 = new JButton("button1");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼 1 클릭");
			}
		});
		btn1.setBounds(6, 6, 117, 29);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("button2");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼 2 클릭");
			}
		});
		btn2.setBounds(152, 6, 117, 29);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("button3");
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("버튼 3 클릭");
			}
		});
		btn3.setBounds(310, 6, 117, 29);
		contentPane.add(btn3);
		
		JLabel lbl = new JLabel("결과");
		lbl.setBounds(16, 57, 411, 16);
		contentPane.add(lbl);
	}

}
