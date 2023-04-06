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
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ZipCodeEx02 extends JFrame {

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
					ZipCodeEx02 frame = new ZipCodeEx02();
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
	public ZipCodeEx02() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\uC6B0\uD3B8\uBC88\uD638 \uAC80\uC0C9\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		
		JButton btn = new JButton("우편번호 검색");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(textField.getText().trim().length() < 2) {
					textArea.setText("동 이름을 두자 이상 입력하셔야 합니다.");
					textField.setText("");
				} else {
					// textArea.setText("정상");
					textArea.setText("");
					
					String strDong = textField.getText().trim();
					
					String url = "jdbc:mariadb://localhost:3306/project";
					String user = "project";
					String password = "1234";
					
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					try {
						Class.forName("org.mariadb.jdbc.Driver");
						conn = DriverManager.getConnection(url, user, password);
						
						String sql = "select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like ?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, "%" + strDong + "%");
						rs = pstmt.executeQuery();
						
						while (rs.next()) {
						    textArea.append(String.format("%s %s %s %s %s %s%n",
						            rs.getString("zipcode"), rs.getString("sido"),
						            rs.getString("gugun"), rs.getString("dong"),
						            rs.getString("ri"), rs.getString("bunji")));
						}
						
					} catch (ClassNotFoundException e1) {
						System.out.println("[Error] : " + e1.getMessage());
					} catch (SQLException e1) {
						System.out.println("[Error] : " + e1.getMessage());
					} finally { 
						if (conn != null) { try { conn.close();} catch (SQLException e1) { System.out.println("[Error] : " + e1.getMessage());}}
					    if (pstmt != null) { try { pstmt.close();} catch (SQLException e1) { System.out.println("[Error] : " + e1.getMessage());}}
					    if (rs != null) { try { rs.close();} catch (SQLException e1) { System.out.println("[Error] : " + e1.getMessage());}}
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
