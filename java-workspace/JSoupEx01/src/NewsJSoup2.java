import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;

public class NewsJSoup2 extends JFrame {
    private JPanel contentPane;
    private JLabel[] labels = new JLabel[10];
    private String[] links = new String[10];

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                NewsJSoup frame = new NewsJSoup();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public NewsJSoup2() {
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
                        labels[i].setText(newsHeadline);
                        links[i] = itemIssue.select("a").attr("href");
                        if (++i == 10) break;
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
        
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel("뉴스 내용");
            labels[i].setBounds(6, i * 30 + 30, 589, 16);
            labels[i].setBorder(blackBorder);
            panel_1.add(labels[i]);
            
            JButton button = new JButton("바로 가기");
            int index = i;
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        Desktop.getDesktop().browse(new URL(links[index]).toURI());
                    } catch (MalformedURLException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (URISyntaxException e1) {
                        e1.printStackTrace();
                    }       
                }
            });
            button.setBounds(607, i * 30 + 30, 157, 15);
            panel_1.add(button);
        }
    }
}
