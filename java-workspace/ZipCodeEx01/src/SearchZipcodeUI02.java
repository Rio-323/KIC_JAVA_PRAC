import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class SearchZipcodeUI02 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea1;
	private JTextArea textArea2;
	private JList list;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchZipcodeUI02 frame = new SearchZipcodeUI02();
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
	public SearchZipcodeUI02() {
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
					
					JOptionPane.showConfirmDialog(SearchZipcodeUI02.this, "동 이름을 두자 이상 입력하셔야 합니다.", "Error", JOptionPane.ERROR_MESSAGE);
					
					textField.setText("");
				} else {
					
					String strDong = textField.getText().trim();
					
					ZipcodeDao dao = new ZipcodeDao();
					ArrayList<ZipcodeDto> addresses = dao.searchZipcode(strDong);
					
					DefaultListModel<String> model = new DefaultListModel<>();
					model.clear();
					
					for(ZipcodeDto to : addresses) {
						String address = String.format("[%s] %s %s %s %s %s\n", to.getZipCode(), to.getSido(), to.getGugun(), to.getDong(), to.getRi(), to.getBunji());
						
						model.addElement(address);
					}
			        
			        list.setModel(model);
				}
			
			}

				
		});
		btn.setBounds(461, 18, 117, 29);
		panel.add(btn);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 104, 584, 370);
		contentPane.add(scrollPane);
		
		list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting()) {
					return;
				}
				
				textArea1.setText((String)list.getSelectedValue());
			}
		});
		scrollPane.setViewportView(list);
		
		textArea1 = new JTextArea();
		textArea1.setText("기본 주소");
		textArea1.setBackground(new Color(207, 206, 208));
		textArea1.setEditable(false);
		textArea1.setBounds(29, 486, 574, 16);
		contentPane.add(textArea1);
		
		textArea2 = new JTextArea();
		textArea2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea2.setText("");
			}
		});
		textArea2.setText("상세주소");
		textArea2.setBounds(26, 518, 577, 16);
		contentPane.add(textArea2);
	}

}
