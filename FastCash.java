
package bankmanagementsystem;

import javax.swing.*;//JFrame
import java.awt.*;//Image
import java.awt.event.*;//ActionListener
import java.sql.*;//ResultSet
import java.util.Date;//Date

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,fastcash,miniStatement,pinchange,balanceamount,exit;
    String pinNumber;
    
    FastCash(String pinNumber){
        
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please select withdrawl amount");
        text.setBounds(200,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(335,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);;
        image.add(fastcash);
        
        miniStatement = new JButton("Rs 2000");
        miniStatement.setBounds(335,450,150,30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceamount = new JButton("Rs 10000");
        balanceamount.setBounds(335,485,150,30);
        balanceamount.addActionListener(this);
        image.add(balanceamount);
        
        exit = new JButton("Back");
        exit.setBounds(250,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
//        setUndecorated(true);
        setVisible(true);
  
    }
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == exit) {
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    } else {
        String amount = ((JButton) ae.getSource()).getText().substring(3);
        Conn c = new Conn();
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinNumber + "'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            if (balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }
            Date date = new Date();
            String query = "insert into bank values('" + pinNumber + "', '" + date + "', 'Withdrawal', '" + amount + "')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

    public static void main(String args[]){
        new FastCash("");
    }
    
}
