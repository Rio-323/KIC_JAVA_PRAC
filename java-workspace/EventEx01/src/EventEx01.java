import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class EventEx01 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventEx01 frame = new EventEx01();
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
	public EventEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1 = new JButton("New button");
		// 1. 이벤트 연결하는 메서드
		// 2. 이벤트 클래스
			// interface / adapter class
		// 3. 이벤트 핸들러(이벤트 처리용 메서드)
		btn1.addMouseListener(new MouseListener() {

			// 이벤트 핸들러
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("mouseClicked");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("mousePressed");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("mouseReleased");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("mouseEntered");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("mouseExited");
			}
			
		});
		btn1.setBounds(6, 6, 117, 29);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("New button");
		btn2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("mouseClicked");
			}
			
		});
		btn2.setBounds(6, 38, 117, 29);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("New button");
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("mouseClicked");
			}
		});
		btn3.setBounds(6, 72, 117, 29);
		contentPane.add(btn3);
	}

}
