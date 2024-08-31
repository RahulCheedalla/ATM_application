
package bankmanagementsystem;

import javax.swing.*;//JFrame
import java.awt.*;//Image
import java.awt.event.*;//ActionListener

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,fastcash,miniStatement,pinchange,balanceamount,exit;
    String pinNumber;
    
    Transactions(String pinNumber){
        
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(200,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(335,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Fast-Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);;
        image.add(fastcash);
        
        miniStatement = new JButton("Mini-Statement");
        miniStatement.setBounds(335,450,150,30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinchange = new JButton("Pin-Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceamount = new JButton("Balance-Enquiry");
        balanceamount.setBounds(335,485,150,30);
        balanceamount.addActionListener(this);
        image.add(balanceamount);
        
        exit = new JButton("Exit");
        exit.setBounds(250,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
//        setUndecorated(true);
        setVisible(true);
  
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }
        else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == pinchange ){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == balanceamount){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == miniStatement){
            setVisible(false);
            new MiniStatement(pinNumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Transactions("");
    }
    
}
