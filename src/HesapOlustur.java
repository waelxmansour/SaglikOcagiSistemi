import javax.swing.*;
import java.awt.*;

public class HesapOlustur extends JFrame {
    JLabel LhesapOLustur =new JLabel("HESAP OLUŞTUR");
    JPanel panel1 = new JPanel(null);
    JButton hesapOLusturB =new JButton("HESAP OLUŞTUR");
    JButton jButOnayla= new JButton("ONAYLA");
    JButton jButGeri= new JButton("GERİ");
    JLabel hesapOlusturLabel = new JLabel("HESAP OLUŞTUR");

    JPanel panel2 = new JPanel(null);
    private JTextField adSoyadField = new JTextField(20);
    private JTextField tcField = new JTextField(20);
    private JTextField yasField = new JTextField(20);
    private JTextField telefonNoField = new JTextField(20);
    private JPasswordField sifreField = new JPasswordField(20);
    private JPasswordField sifreOnayField = new JPasswordField(20);
    private JTextField cinsiyetField = new JTextField(20);
    private JTextField emailField = new JTextField(20);

    public HesapOlustur(){
        this.setTitle(" HESAP OLUŞTUR");
        this.setLayout(null);
        this.setSize(1200,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        panel1.setBounds(0,0,1200,80);
        hesapOlusturLabel.setFont(new Font("Inter",Font.BOLD,40));
       hesapOlusturLabel.setForeground(new Color(0xffffff));
       hesapOlusturLabel.setBounds(429,0,342,80);
       hesapOLusturB.setBounds(422,108,356,68);



    }




}
