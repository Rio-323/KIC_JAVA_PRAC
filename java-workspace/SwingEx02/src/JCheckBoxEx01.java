import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;
import javax.swing.JToggleButton;

public class JCheckBoxEx01 extends JFrame {

	private JPanel contentPane;
	private JCheckBox chckbx1;
	private JCheckBox chckbx2;
	private JCheckBox chckbx3;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCheckBoxEx01 frame = new JCheckBoxEx01();
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
	public JCheckBoxEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		chckbx1 = new JCheckBox("사과");
		chckbx1.setSelected(true);
		chckbx1.setBounds(6, 94, 128, 23);
		contentPane.add(chckbx1);
		
		chckbx2 = new JCheckBox("수박");
		chckbx2.setBounds(6, 129, 128, 23);
		contentPane.add(chckbx2);
		
		chckbx3 = new JCheckBox("딸기");
		chckbx3.setBounds(6, 164, 128, 23);
		contentPane.add(chckbx3);
		
		JButton btn = new JButton("New button");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
//				System.out.println(chckbx1.isSelected());
//				System.out.println(chckbx2.isSelected());
//				System.out.println(chckbx3.isSelected());
//				
//				System.out.println(chckbx1.getText());
//				System.out.println(chckbx2.getText());
//				System.out.println(chckbx3.getText());
				
//				if(chckbx1.isSelected()) {
//				    System.out.println(chckbx1.getText());
//				}
//				if(chckbx2.isSelected()) {
//				    System.out.println(chckbx2.getText());
//				}
//				if(chckbx3.isSelected()) {
//				    System.out.println(chckbx3.getText());
//				}
				
//				List<JCheckBox> checkboxes = Arrays.asList(chckbx1, chckbx2, chckbx3);
//				for(JCheckBox checkbox : checkboxes) {
//				    if(checkbox.isSelected()) {
//				        System.out.println(checkbox.getText());
//				    }
//				}
				
				String result = "";
				if(chckbx1.isSelected()) result += chckbx1.getText() + " ";
				if(chckbx2.isSelected()) result += chckbx2.getText() + " ";
				if(chckbx3.isSelected()) result += chckbx3.getText() + " ";
				
				System.out.println("결과 : " + result);
			}
		});
		btn.setBounds(6, 199, 117, 29);
		contentPane.add(btn);
		
		btn1 = new JButton("전체 선택");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chckbx1.setSelected(true);
				chckbx2.setSelected(true);
				chckbx3.setSelected(true);
			}
		});
		btn1.setBounds(6, 6, 117, 29);
		contentPane.add(btn1);
		
		btn2 = new JButton("전체 해제");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chckbx1.setSelected(false);
				chckbx2.setSelected(false);
				chckbx3.setSelected(false);
			}
		});
		btn2.setBounds(145, 6, 117, 29);
		contentPane.add(btn2);
		
		btn3 = new JButton("전체 선택");
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(btn3.getText().equals("전체 선택")) {
					btn3.setText("전체 해제");
				} else {
					btn3.setText("전체 선택");
				}
			}
		});
		btn3.setBounds(6, 39, 117, 29);
		contentPane.add(btn3);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.setBounds(145, 39, 161, 29);
		contentPane.add(tglbtnNewToggleButton);
	}
}
