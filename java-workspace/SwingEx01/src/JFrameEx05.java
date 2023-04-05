import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameEx05 extends JFrame {
	
	private JPanel contentPane;
	
	public JFrameEx05() {
		
		this.setBounds(100, 100, 1024, 768);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		
		contentPane.setBackground(Color.red);
		
		JButton btn1 = new JButton("난 버튼");
		btn1.setBounds(10, 10, 100, 25);
		
		contentPane.add(btn1);
		
		this.setContentPane(contentPane);
	}

	public static void main(String[] args) {
		JFrameEx05 frame = new JFrameEx05();
		frame.setVisible(true);
	}

}
