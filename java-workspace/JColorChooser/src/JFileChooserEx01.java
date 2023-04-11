import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class JFileChooserEx01 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFileChooserEx01 frame = new JFileChooserEx01();
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
	public JFileChooserEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn = new JButton("New button");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser("C:\\");
				int result = fileChooser.showOpenDialog(JFileChooserEx01.this);
				
				if(result == JFileChooser.APPROVE_OPTION) {
					System.out.println("확인");
					System.out.println(fileChooser.getSelectedFile().getName());
					File file = fileChooser.getSelectedFile();
					System.out.println(file.getName());
					System.out.println(file.getAbsolutePath());
				} else if(result == JFileChooser.CANCEL_OPTION) {
					System.out.println("취소");
				}
				
			}
		});
		btn.setBounds(6, 6, 117, 29);
		contentPane.add(btn);
	}

}
