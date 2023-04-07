import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class JSpinnerEx01 extends JFrame {

	private JPanel contentPane;
	private JSpinner spinner2;
	private JSpinner spinner3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JSpinnerEx01 frame = new JSpinnerEx01();
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
	public JSpinnerEx01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				System.out.println((Integer)spinner.getValue());
				System.out.println((String)spinner2.getValue());
				System.out.println((Date)spinner3.getValue());
				
			}
		});
		spinner.setModel(new SpinnerNumberModel(50, 0, 100, 10));
		spinner.setBounds(6, 6, 94, 26);
		contentPane.add(spinner);
		
		JButton btn = new JButton("New button");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println((Integer)spinner.getValue());
			}
		});
		btn.setBounds(6, 46, 117, 29);
		contentPane.add(btn);
		
		spinner2 = new JSpinner();
		spinner2.setModel(new SpinnerListModel(new String[] {"사과", "참외", "수박", "딸기"}));
		spinner2.setBounds(6, 88, 94, 26);
		contentPane.add(spinner2);
		
		spinner3 = new JSpinner();
		spinner3.setModel(new SpinnerDateModel(new Date(1680793200000L), null, null, Calendar.YEAR));
		spinner3.setBounds(6, 126, 94, 26);
		contentPane.add(spinner3);
	}
}
