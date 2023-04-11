import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class GugudanDialogEx01 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private int data1;
	private int data2;
	private JTextArea textArea;
	
	public int getData1() {
		return data1;
	}
	
	public int getData2() {
		return data2;
	}
	
	public GugudanDialogEx01(String data1, String data2) {
		this();
		this.data1 = Integer.parseInt(data1);
		this.data2 = Integer.parseInt(data2);
		
		generateTable();
	}

	/**
	 * Create the dialog.
	 */
	public GugudanDialogEx01() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 6, 438, 221);
			contentPanel.add(scrollPane);
			
			textArea = new JTextArea();
			scrollPane.setViewportView(textArea);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GugudanDialogEx01.this.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GugudanDialogEx01.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void generateTable() {
		   if (getData1() >= getData2()) {
		      textArea.append("Please check the entered number again");
		   } else {
		      for (int i = getData1(); i <= getData2(); i++) {
		         for (int j = 1; j <= 9; j++) {
		            textArea.append(i + " X " + j + " = " + (i*j) + "\t");
		         }
		         textArea.append("\n");
		      }
		   }
		}
}
