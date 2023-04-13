import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class NewsJSoup extends JFrame {

	private JPanel contentPane;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JLabel lbl8;
	private JLabel lbl9;
	private JLabel lbl10;
	String btn2Link;
	String btn3Link;
	String btn4Link;
	String btn5Link;
	String btn6Link;
	String btn7Link;
	String btn8Link;
	String btn9Link;
	String btn10Link;
	String btn11Link;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewsJSoup frame = new NewsJSoup();
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
	public NewsJSoup() {
		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JButton btn1 = new JButton("실시간 뉴스 보기");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String url = "https://news.daum.net/";

				try {
		            Document doc = Jsoup.connect(url).get();
		            Elements itemIssueElements = doc.select(".item_issue");
		            int i = 0;
		            for (Element itemIssue : itemIssueElements) {
		                String newsHeadline = itemIssue.text();
		                switch (i) {
		                    case 0: lbl1.setText(newsHeadline); btn2Link = itemIssue.select("a").attr("href"); break;
		                    case 1: lbl2.setText(newsHeadline); btn3Link = itemIssue.select("a").attr("href"); break;
		                    case 2: lbl3.setText(newsHeadline); btn4Link = itemIssue.select("a").attr("href"); break;
		                    case 3: lbl4.setText(newsHeadline); btn5Link = itemIssue.select("a").attr("href"); break;
		                    case 4: lbl5.setText(newsHeadline); btn6Link = itemIssue.select("a").attr("href"); break;
		                    case 5: lbl6.setText(newsHeadline); btn7Link = itemIssue.select("a").attr("href"); break;
		                    case 6: lbl7.setText(newsHeadline); btn8Link = itemIssue.select("a").attr("href"); break;
		                    case 7: lbl8.setText(newsHeadline); btn9Link = itemIssue.select("a").attr("href"); break;
		                    case 8: lbl9.setText(newsHeadline); btn10Link = itemIssue.select("a").attr("href"); break;
		                    case 9: lbl10.setText(newsHeadline); btn11Link = itemIssue.select("a").attr("href"); break;
		                    default: break;
		                }
		                i++;
		            }
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
			}
		});
		contentPane.add(btn1, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\uB274\uC2A4 \uBCF4\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(6, 18, 770, 447);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lbl1 = new JLabel("뉴스 내용");
		lbl1.setBounds(6, 30, 589, 16);
		panel_1.add(lbl1);
		lbl1.setBorder(blackBorder);
        
        JButton btn2 = new JButton("바로 가기");
        btn2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		try {
					Desktop.getDesktop().browse(new URL(btn2Link).toURI());
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}       
        	}
        });
        btn2.setBounds(607, 30, 157, 15);
        panel_1.add(btn2);
        
        lbl2 = new JLabel("뉴스 내용");
        lbl2.setBounds(6, 70, 589, 16);
        panel_1.add(lbl2);
        lbl2.setBorder(blackBorder);
        
        JButton btn3 = new JButton("바로 가기");
        btn3.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		try {
					Desktop.getDesktop().browse(new URL(btn3Link).toURI());
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
        	}
        });
        btn3.setBounds(607, 70, 157, 15);
        panel_1.add(btn3);
        
        lbl3 = new JLabel("뉴스 내용");
        lbl3.setBounds(6, 110, 589, 16);
        panel_1.add(lbl3);
        lbl3.setBorder(blackBorder);
        
        JButton btn4 = new JButton("바로 가기");
        btn4.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		try {
					Desktop.getDesktop().browse(new URL(btn4Link).toURI());
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
        	}
        });
        btn4.setBounds(607, 110, 157, 15);
        panel_1.add(btn4);
        
        lbl4 = new JLabel("뉴스 내용");
        lbl4.setBounds(6, 150, 589, 16);
        panel_1.add(lbl4);
        lbl4.setBorder(blackBorder);
        
        JButton btn5 = new JButton("바로 가기");
        btn5.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		try {
					Desktop.getDesktop().browse(new URL(btn5Link).toURI());
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
        	}
        });
        btn5.setBounds(607, 150, 157, 15);
        panel_1.add(btn5);
        
        lbl5 = new JLabel("뉴스 내용");
        lbl5.setBounds(6, 190, 589, 16);
        panel_1.add(lbl5);
        lbl5.setBorder(blackBorder);
        
        JButton btn6 = new JButton("바로 가기");
        btn6.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		try {
					Desktop.getDesktop().browse(new URL(btn6Link).toURI());
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
        	}
        });
        btn6.setBounds(607, 190, 157, 15);
        panel_1.add(btn6);
        
        lbl6 = new JLabel("뉴스 내용");
        lbl6.setBounds(6, 230, 589, 16);
        panel_1.add(lbl6);
        lbl6.setBorder(blackBorder);
        
        JButton btn7 = new JButton("바로 가기");
        btn7.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		try {
					Desktop.getDesktop().browse(new URL(btn7Link).toURI());
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
        	}
        });
        btn7.setBounds(607, 230, 157, 15);
        panel_1.add(btn7);
        
        lbl7 = new JLabel("뉴스 내용");
        lbl7.setBounds(6, 270, 589, 16);
        panel_1.add(lbl7);
        lbl7.setBorder(blackBorder);
        
        JButton btn8 = new JButton("바로 가기");
        btn8.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		try {
					Desktop.getDesktop().browse(new URL(btn8Link).toURI());
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
        	}
        });
        btn8.setBounds(607, 270, 157, 15);
        panel_1.add(btn8);
        
        lbl8 = new JLabel("뉴스 내용");
        lbl8.setBounds(6, 310, 589, 16);
        panel_1.add(lbl8);
        lbl8.setBorder(blackBorder);
        
        JButton btn9 = new JButton("바로 가기");
        btn9.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		try {
					Desktop.getDesktop().browse(new URL(btn9Link).toURI());
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
        	}
        });
        btn9.setBounds(607, 310, 157, 15);
        panel_1.add(btn9);
        
        lbl9 = new JLabel("뉴스 내용");
        lbl9.setBounds(6, 350, 589, 16);
        panel_1.add(lbl9);
        lbl9.setBorder(blackBorder);
        
        JButton btn10 = new JButton("바로 가기");
        btn10.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		try {
					Desktop.getDesktop().browse(new URL(btn10Link).toURI());
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
        	}
        });
        btn10.setBounds(607, 350, 157, 15);
        panel_1.add(btn10);
        
        lbl10 = new JLabel("뉴스 내용");
        lbl10.setBounds(6, 390, 589, 16);
        panel_1.add(lbl10);
        lbl10.setBorder(blackBorder);
        
        JButton btn11 = new JButton("바로 가기");
        btn11.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		try {
					Desktop.getDesktop().browse(new URL(btn11Link).toURI());
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
        	}
        });
        btn11.setBounds(607, 390, 157, 15);
        panel_1.add(btn11);
	}

}



