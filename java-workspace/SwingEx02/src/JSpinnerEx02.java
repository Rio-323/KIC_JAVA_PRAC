import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JSpinnerEx02 extends JFrame {

	private JPanel contentPane;
	private JSpinner spinner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JSpinnerEx02 frame = new JSpinnerEx02();
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
	public JSpinnerEx02() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		spinner = new JSpinner();
//		String[] items = {"사과", "참외", "수박", "딸기"};
//		SpinnerListModel spinnerListModel = new SpinnerListModel(items);
//		spinner.setModel(spinnerListModel);
		
		// DAO와 연결
		// spinner.setModel(new CustomSpinnerListModel());
		
		spinner.setModel(new SpinnerListModel(new String[] {""}));
		spinner.setBounds(6, 6, 227, 26);
		contentPane.add(spinner);
		
		JButton btn = new JButton("New button");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				spinner.setModel(new CustomSpinnerListModel());
				
			}
		});
		btn.setBounds(6, 44, 117, 29);
		contentPane.add(btn);
	}
}
