import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class JFrameEx02 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameEx02 frame = new JFrameEx02();
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
	public JFrameEx02() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl1 = new JLabel("라벨1");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBounds(6, 6, 156, 16);
		contentPane.add(lbl1);
		
		String text = "<html><body>Hello Label<br/> <font color = 'red'>Hello Label</font></body></html>";
		JLabel lbl2 = new JLabel(text);
		lbl2.setFont(new Font("Serif", Font.BOLD, 15));
		
		// RGB 혼합 색상
		// lbl2.setForeground(new Color(50, 50, 255));
		// lbl2.setForeground(Color.red);
		lbl2.setVerticalAlignment(SwingConstants.TOP);
		lbl2.setBounds(6, 34, 156, 44);
		contentPane.add(lbl2);
		
		System.out.println(lbl1.getText());
		System.out.println(lbl2.getText());
		
		lbl1.setText("새 라벨1");
		
		JLabel lbl3 = new JLabel("");
		lbl3.setIcon(new ImageIcon("/Users/ksy/Desktop/KIC_JAVA_PRAC/java-workspace/SwingEx02/windowbuilder.png"));
		lbl3.setBounds(6, 90, 156, 103);
		contentPane.add(lbl3);
		
	}
}
