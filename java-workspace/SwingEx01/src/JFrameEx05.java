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
		
		contentPane.setBackground(Color.gray);
		
		JButton btn1 = new JButton("난 버튼 1");
		btn1.setBounds(10, 10, 100, 25);
		
		JButton btn2 = new JButton("난 버튼2");
		btn2.setBounds(10, 40, 100, 25);
		
		// 레이아웃(배치 관리자)
		// null - null layout / absolute layout
		contentPane.setLayout(null); // 내가 원하는대로 배치할 수 있게 해줌.
		
		contentPane.add(btn1);
		contentPane.add(btn2);
		
		this.setContentPane(contentPane);
	}

	public static void main(String[] args) {
		JFrameEx05 frame = new JFrameEx05();
		frame.setVisible(true);
	}

}
