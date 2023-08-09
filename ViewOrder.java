package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import Food.Food;

public class ViewOrder extends JFrame
{

	JLabel  quantity, price, user, date,food,title;
	JButton back;
	JTable jt;
	JScrollPane sp;
	
	public void components()
	{	
	
	
		String data[][]=new String[100][5];   
    		String column[]={"Name","Food","quantity","date","Amount"};         
    		
		user = new JLabel("Name");
		food = new JLabel("Food Item");
		quantity = new JLabel("Quantity");
		date = new JLabel("Date  Time");
		price = new JLabel("Amount");
		title = new JLabel("ORDERS");
		
		title.setBounds(580,30,120,20);
		user.setBounds(150,80,120,20);
		food.setBounds(350,80,120,20);
		quantity.setBounds(550,80,120,20);
		date.setBounds(750,80,120,20);
		price.setBounds(950,80,120,20);
    		      
    		sp=new JScrollPane(jt); 
		sp.setBounds(150,100,1000,500);  
		jt=new JTable(data,column);
		jt.setBounds(150,100,1000,500);  
		
		add(jt);
		add(sp);
		add(user);
		add(quantity);
		add(price);
		add(date);
		add(food);
		add(title);
		
		getContentPane().setBackground(new Color(211, 69, 0));
		
		user.setFont(new Font("courier",Font.ITALIC+Font.BOLD,16));
		user.setForeground(new Color(255,255,255));
		
		food.setFont(new Font("courier",Font.ITALIC+Font.BOLD,16));
		food.setForeground(new Color(255,255,255));
		
		quantity.setFont(new Font("courier",Font.ITALIC+Font.BOLD,16));
		quantity.setForeground(new Color(255,255,255));
		
		date.setFont(new Font("courier",Font.ITALIC+Font.BOLD,16));
		date.setForeground(new Color(255,255,255));
		
		price.setFont(new Font("courier",Font.ITALIC+Font.BOLD,16));
		price.setForeground(new Color(255,255,255));
		
		title.setFont(new Font("courier",Font.BOLD,20));
		title.setForeground(new Color(0,0,0));
		
		
		back = new JButton("Back");
		back.setBounds(1200,80,100,50);
		back.setFont(new Font("courier",Font.ITALIC+Font.BOLD,12));
	
		back.addActionListener(new Handler());
		
		setLayout(null);
		
		
		add(back);
		
		
		try
		{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","javadb","abcd");
			String str = "select * from foodorder";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(str);
			int i=0;
			while(rs.next())
			{
				data[i][0] = rs.getString("user_name");
				data[i][1] = rs.getString("food_item");
				data[i][2] = Integer.toString(rs.getInt("quantity"));
				data[i][3] = rs.getString("puchase_date");
				data[i][4] = Integer.toString(rs.getInt("price"));
				i++;
			}			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	
	public class Handler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Food a = new Food();
			a.setExtendedState(JFrame.MAXIMIZED_BOTH);
			a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			a.components();
			a.setVisible(true);
			setVisible(false);
		}
	}
}


