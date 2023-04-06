import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SearchEmpUI01 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchEmpUI01 frame = new SearchEmpUI01();
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
	public SearchEmpUI01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\uBD80\uC11C \uC774\uB984 \uAC80\uC0C9", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(19, 33, 584, 53);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
			}
		});
		textField.setBounds(6, 18, 420, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btn = new JButton("부서 이름 검색");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(textField.getText().trim().length() < 2) {
					textArea.setText("부서 이름을 두자 이상 입력하셔야 합니다.");
					textField.setText("");
				} else {
					textArea.setText("");
					
					String strDname = textField.getText().trim();
					
					EmpDao dao = new EmpDao();
					ArrayList<EmpDto> employees = dao.searchEmpcode(strDname);
					
					for(EmpDto to : employees) {
						String employee = String.format("%s %s %s %s %s %s", to.getDeptno(), to.getLoc(), to.getEmpno(), to.getEname(), to.getJob(), to.getSal());
						
						textArea.append(employee + System.lineSeparator());
					}
			        
			        
				}
			
			}

				
		});
		btn.setBounds(461, 18, 117, 29);
		panel.add(btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 119, 574, 341);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}

}
