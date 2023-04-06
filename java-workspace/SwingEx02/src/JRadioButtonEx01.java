import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JRadioButtonEx01 extends JFrame {

	private JPanel contentPane;
	private JRadioButton rdbtn1;
	private JRadioButton rdbtn2;
	private JRadioButton rdbtn3;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JRadioButtonEx01 frame = new JRadioButtonEx01();
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
	public JRadioButtonEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdbtn1 = new JRadioButton("사과");
		buttonGroup.add(rdbtn1);
		rdbtn1.setSelected(true);
		rdbtn1.setBounds(6, 22, 141, 23);
		contentPane.add(rdbtn1);
		
		rdbtn2 = new JRadioButton("수박");
		buttonGroup.add(rdbtn2);
		rdbtn2.setBounds(6, 57, 141, 23);
		contentPane.add(rdbtn2);
		
		rdbtn3 = new JRadioButton("딸기");
		buttonGroup.add(rdbtn3);
		rdbtn3.setBounds(6, 92, 141, 23);
		contentPane.add(rdbtn3);
		
		JButton btn = new JButton("New button");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtn1.isSelected()) {
					System.out.println(rdbtn1.getText());
				} else if(rdbtn2.isSelected()) {
					System.out.println(rdbtn2.getText());
				} else {
					System.out.println(rdbtn3.getText());
				}
				
			}
		});
		btn.setBounds(6, 140, 117, 29);
		contentPane.add(btn);
	}
}
