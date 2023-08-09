package Food;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import View.ViewOrder;


public class Food extends JFrame
{
	JLabel food_item, quantity, price, item, user, amount, orderid,food_order, amount_txt, food_order_txt, icon1, icon2, icon3, icon4, icon5, comp_name, comp_name1;
	
	JRadioButton dishes_mexican, dishes_chinese, dishes_italian, dishes_southindian, dishes_northindian;
	
	JTextField quantity_txt, price_txt, user_txt;
	
	JComboBox mexican_list, chinese_list, italian_list, southindian_list, northindian_list; 
	
	JButton submit, enter, order, view_order,clear;
	
	Graphics g;
		 
	
	public void components()
	{
		"Shreyash","BT21CSE105",2, 3
		9.9,"A","I Study very Smartly by Enjoying It"
		
		//object assignment
		
		food_item = new JLabel("Food Item");
		item = new JLabel("Not Selected");
		quantity = new JLabel("Quantity");
		price = new JLabel("price");
		user = new JLabel("Name");
		amount = new JLabel("Amount");
		food_order = new JLabel("Selected Item");
		user_txt = new JTextField();
		comp_name = new JLabel("Naivedyam");
		comp_name1 = new JLabel("Naivedyam");
		amount_txt = new JLabel("Total Amount");
		food_order_txt = new JLabel("Item Name");
		
		icon1 = new JLabel();
		icon1.setIcon(new ImageIcon("pizza.jpeg"));
		
		icon2 = new JLabel();
		icon2.setIcon(new ImageIcon("zucchini_crust_pizza-1-of-1.jpeg"));
		
		icon3 = new JLabel();
		icon3.setIcon(new ImageIcon("maxresdefault.jpeg"));
		
		icon4 = new JLabel();
		icon4.setIcon(new ImageIcon("19_chinese-cuisine.jpeg"));
		
		icon5 = new JLabel();
		icon5.setIcon(new ImageIcon("South Indian Food_1.jpeg"));

		dishes_mexican = new JRadioButton("i) Mexican ");
		dishes_chinese = new JRadioButton("ii) Chinese");
		dishes_italian = new JRadioButton("iii) Italian");
		dishes_southindian = new JRadioButton("iv) South Indian");
		dishes_northindian = new JRadioButton("v) North Indian");
		
		
		String mexican[] = {"Taco","Burrito","Tex-Mex","Asado","Oaxacan","New Mexican"};
		mexican_list = new JComboBox(mexican);
		
		String chinese[] = {"Sichuan cuisine","Cantonese cuisine","Beijing cuisine","Shanghai cuisine","Chinese noodles"};
		chinese_list = new JComboBox(chinese);
		
		String italian[] = {"Spagheti","Mushroom Risotto","Pasta","Focaccia Bread","Margherita Pizza"};
		italian_list = new JComboBox(italian);
		
		String southindian[] = {"Idli Sambhar","Plain Dosa","Masala Dosa","Uthhapam","Vada","70mm Dosa","Hyderabadi Biriyani"};
		southindian_list = new JComboBox(southindian);
		
		String northindian[] = {"Chhole Bhatura","Rogan Josh","Chaat","Dal-Bati Churma","Aloo Samosa","Chicken Dum Biriyani"};
		northindian_list = new JComboBox(northindian);
		
		
		quantity_txt = new JTextField();
		price_txt = new JTextField();
		submit = new JButton("Submit"); 
		enter = new JButton("Enter");
		order = new JButton("Place Order");
		view_order = new JButton("View Orders");
		clear = new JButton("Clear");
		
		
		
		//graphical design
		
		
		
		getContentPane().setBackground(new Color(211, 69, 0)); //background
		
		food_item.setForeground(new Color(153, 0, 0));
		food_item.setFont(new Font("Courier",Font.BOLD + Font.ITALIC,12));
		
		quantity.setForeground(new Color(153, 0, 0));
		quantity.setFont(new Font("Courier",Font.BOLD + Font.ITALIC,12));
		
		price.setForeground(new Color(153, 0, 0));
		price.setFont(new Font("Courier",Font.BOLD + Font.ITALIC,12));
		
		item.setForeground(new Color(153, 0, 0));
		item.setFont(new Font("Courier",Font.BOLD + Font.ITALIC,12));
		
		user.setForeground(new Color(153, 0, 0));
		user.setFont(new Font("Courier",Font.BOLD+ Font.ITALIC,12));
		
		amount.setForeground(new Color(153, 0, 0));
		amount.setFont(new Font("Courier",Font.BOLD + Font.ITALIC,12));
		
		comp_name.setForeground(new Color(255,255,255));
		comp_name.setFont(new Font("Samarkan",Font.BOLD , 30));
		
		comp_name1.setForeground(new Color(59, 41, 38));
		comp_name1.setFont(new Font("Samarkan",Font.BOLD , 30));
		//orderid.setBackground(new Color(228, 188, 255));
		
		food_order.setForeground(new Color(153, 0, 0));
		food_order.setFont(new Font("Courier",Font.BOLD + Font.ITALIC,12));
		
		amount_txt.setForeground(new Color(153, 0, 0));
		amount_txt.setFont(new Font("Courier",Font.BOLD + Font.ITALIC, 12));
		
		food_order_txt.setForeground(new Color(153, 0, 0));
		food_order_txt.setFont(new Font("Courier",Font.BOLD + Font.ITALIC, 12));
		
		//combo design
		dishes_mexican.setBackground(new Color(153, 0, 0));
		dishes_mexican.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 12));

		dishes_chinese.setBackground(new Color(153, 0, 0));
		dishes_chinese.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 12));
		
		dishes_italian.setBackground(new Color(153, 0, 0));
		dishes_italian.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 12));
		
		dishes_southindian.setBackground(new Color(153, 0, 0));
		dishes_southindian.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 12));				

		dishes_northindian.setBackground(new Color(153, 0, 0));
		dishes_northindian.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 12));
		// dishes_chinese, dishes_italian, dishes_southindian, dishes_northindian;
		
		//radio design
		 mexican_list.setFont(new Font("Courier",Font.BOLD + Font.ITALIC, 12));
		 chinese_list.setFont(new Font("Courier",Font.BOLD + Font.ITALIC, 12));
		 italian_list.setFont(new Font("Courier",Font.BOLD + Font.ITALIC, 12));
		 southindian_list.setFont(new Font("Courier",Font.BOLD + Font.ITALIC, 12));
		 northindian_list.setFont(new Font("Courier",Font.BOLD + Font.ITALIC, 12));
		 
		 //button design
		 
		 submit.setFont(new Font("Courier",Font.ITALIC,12));
		 submit.setForeground(new Color(0,0,0));
		 submit.setBackground(new Color(253, 69, 0));
		 
		 enter.setBackground(new Color(253,69,0));
		 enter.setFont(new Font("Courier",Font.ITALIC,12));
		 enter.setForeground(new Color(0,0,0));
		 
		 order.setBackground(new Color(253,69,0));
		 order.setFont(new Font("Courier",Font.ITALIC,12));
		 order.setForeground(new Color(0,0,0));
		 
		 view_order.setBackground(new Color(253,69,0));
		 view_order.setFont(new Font("Courier",Font.ITALIC,12));
		 view_order.setForeground(new Color(0,0,0));
		 
		 clear.setBackground(new Color(253,69,0));
		 clear.setFont(new Font("Courier",Font.ITALIC,12));
		 clear.setForeground(new Color(0,0,0));


		 		
		setLayout(null);
		
		food_item.setBounds(100,450,150,30);
		item.setBounds(300,450,150,30);
		comp_name.setBounds(580,620,300,40);
		comp_name1.setBounds(583,623,300,40);
		icon1.setBounds(30,10,160,100);
		icon2.setBounds(300,10,150,100);
		icon3.setBounds(850,10,178,100);
		icon4.setBounds(1150,10,150,100);
		icon5.setBounds(560,10,178,100);
		
		dishes_mexican.setBounds(100,150,150,30);
		dishes_chinese.setBounds(100,200,150,30);
		dishes_italian.setBounds(100,250,150,30);
		dishes_southindian.setBounds(100,300,150,30);
		dishes_northindian.setBounds(100,350,150,30);
		
		mexican_list.setBounds(300,150,150,30);
		chinese_list.setBounds(300,200,150,30);
		italian_list.setBounds(300,250,150,30);
		southindian_list.setBounds(300,300,150,30);
		northindian_list.setBounds(300,350,150,30);
		
		submit.setBounds(300,400,150,30);

		user.setBounds(850,150,120,30);
		user_txt.setBounds(1050,150,120,30);
		
		price.setBounds(850,200,120,30);
		price_txt.setBounds(1050,200,120,30);

		quantity.setBounds(850,300,120,30);
		quantity_txt.setBounds(1050,300,120,30);
				
		food_order.setBounds(850,250,120,30);
		food_order_txt.setBounds(1050,250,120,30);

		amount.setBounds(850,350,120,30);
		amount_txt.setBounds(1050,350,120,30);
				
		quantity.setBounds(850,300,120,30);
		enter.setBounds(850,400,320,30);
		clear.setBounds(850,450,320,30);
		order.setBounds(850,500,120,30);
		view_order.setBounds(1050,500,120,30);
		

		
		submit.addActionListener(new UI());
		order.addActionListener(new PlaceOrder());
		clear.addActionListener(new Clear());
		view_order.addActionListener(new View());

				
		add(food_item);
		add(item);
		add(quantity);
		add(price);
		add(dishes_mexican);
		add(dishes_chinese);
		add(dishes_italian);
		add(dishes_southindian);
		add(dishes_northindian);
		add(mexican_list);
		add(italian_list);
		add(chinese_list);
		add(southindian_list);
		add(northindian_list);
		add(comp_name);
		add(comp_name1);
		add(icon1);
		add(icon2);
		add(icon3);
		add(icon4);
		add(icon5);
		
		
		add(quantity_txt);
		add(price_txt);
		add(submit);
		add(enter);
		add(order);
		add(view_order);
		add(clear);

		
		add(user);
		add(amount);
		add(user_txt);
		add(amount_txt);
		add(food_order);
		add(food_order_txt);
		
		
		ButtonGroup group = new ButtonGroup();
		group.add(dishes_mexican);
		group.add(dishes_italian);
		group.add(dishes_chinese);
		group.add(dishes_southindian);
		group.add(dishes_northindian);

	
		
		{
			northindian_list.setEnabled(false);
			mexican_list.setEnabled(false);
			chinese_list.setEnabled(false);
			southindian_list.setEnabled(false);
			italian_list.setEnabled(false);
			quantity_txt.setEnabled(false);
			price_txt.setEnabled(false);
			user_txt.setText("null");
			order.setEnabled(true);	
		}
		
	}



	class UI implements ActionListener
	{
		
		
		public void actionPerformed(ActionEvent e)
		{
		
			try
			{
			
		
				g = getGraphics();
				g.setColor(new Color(59,41,38));
				g.drawRoundRect(100,150,380,450,10,10);
				g.setColor(new Color(59, 41, 38));
				g.drawRoundRect(850,150,340,450,10,10);
				g.setColor(new Color(255, 0, 0));
				g.fillRect(660,160,10,460);
				g.setColor(new Color(59, 41, 38));
				g.drawRect(660,160,10,460);			
				g.setColor(new Color(59,41,38));
				g.fillRect(260,50,3,80);
				g.fillRect(510,50,3,80);	
				g.fillRect(800,50,3,80);	
				g.fillRect(1100,50,3,80);		
					
			
			if(dishes_mexican.isSelected())
				{
					mexican_list.setEnabled(true);
					italian_list.setEnabled(false);
					chinese_list.setEnabled(false);
					southindian_list.setEnabled(false);
					northindian_list.setEnabled(false);
					quantity_txt.setEnabled(true);

					item.setText(""+mexican_list.getSelectedItem());
					food_order_txt.setText(""+item.getText());
					enter.addActionListener(new Handler());
				}
				else if(dishes_italian.isSelected())
				{
					italian_list.setEnabled(true);
					mexican_list.setEnabled(false);
					chinese_list.setEnabled(false);
					southindian_list.setEnabled(false);
					northindian_list.setEnabled(false);
					quantity_txt.setEnabled(true);
					item.setText(""+italian_list.getSelectedItem());
					food_order_txt.setText(""+item.getText());
					enter.addActionListener(new Handler());
				}
				else if(dishes_chinese.isSelected())
				{
					chinese_list.setEnabled(true);
					mexican_list.setEnabled(false);
					italian_list.setEnabled(false);
					southindian_list.setEnabled(false);
					northindian_list.setEnabled(false);
					quantity_txt.setEnabled(true);

					item.setText(""+chinese_list.getSelectedItem());
					food_order_txt.setText(""+item.getText());
					enter.addActionListener(new Handler());
				}
				else if(dishes_southindian.isSelected() == true)
				{
					southindian_list.setEnabled(true);
					mexican_list.setEnabled(false);
					chinese_list.setEnabled(false);
					italian_list.setEnabled(false);
					northindian_list.setEnabled(false);
					quantity_txt.setEnabled(true);
			
					item.setText(""+southindian_list.getSelectedItem());				
					food_order_txt.setText(""+item.getText());
					enter.addActionListener(new Handler());
				}
				else if(dishes_northindian.isSelected() == true)
				{
					northindian_list.setEnabled(true);
					mexican_list.setEnabled(false);
					chinese_list.setEnabled(false);
					southindian_list.setEnabled(false);
					italian_list.setEnabled(false);
					quantity_txt.setEnabled(true);

					item.setText(""+northindian_list.getSelectedItem());		
					food_order_txt.setText(""+item.getText());
					enter.addActionListener(new Handler());		
				}
				else
				{
					northindian_list.setEnabled(false);
					mexican_list.setEnabled(false);
					chinese_list.setEnabled(false);
					southindian_list.setEnabled(false);
					italian_list.setEnabled(false);
					quantity_txt.setEnabled(false);
		
				}
			
			
			}
			catch(Exception ex)
			{
				
			}

		}
			
	}
	
	
	public class Clear implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
					northindian_list.setEnabled(false);
					mexican_list.setEnabled(false);
					chinese_list.setEnabled(false);
					southindian_list.setEnabled(false);
					italian_list.setEnabled(false);
					quantity_txt.setEnabled(false);	
					quantity_txt.setText("");
					amount_txt.setText("Total Amount");
					price_txt.setText("");
					food_order_txt.setText("Item Name");
		}
	}
	
	public class View implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			ViewOrder obj = new ViewOrder();
			obj.setExtendedState(JFrame.MAXIMIZED_BOTH);
			obj.components();
			obj.setVisible(true);
			obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(false);
		}
	}
	
	
	public class Handler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","javadb","abcd");
			String sql = "select * from fooddb where FOOD_ITEM = '"+item.getText()+"'";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(sql);
			if(rs.next())
			{
				int amt = Integer.parseInt(quantity_txt.getText()) * rs.getInt("price");
				price_txt.setText(""+rs.getInt("price"));
				amount_txt.setText(""+amt);
				order.setEnabled(true);
				conn.close();

			}
			else
			{
				JOptionPane.showMessageDialog(null,"item not available");
			}

		    }
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
	}
	
	public class PlaceOrder implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","javadb","abcd");
				String query = "select * from fooddb where food_item = '"+item.getText()+"'";
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(query);
				String nm = user_txt.getText();
				if(rs.next())
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","javadb","abcd");
					
					String sql = "insert into foodorder (user_name,food_item,quantity,price,puchase_date) values('"+user_txt.getText()+"','"+item.getText()+"','"+Integer.parseInt(quantity_txt.getText())+"','"+Integer.parseInt(amount_txt.getText())+"',sysdate)";
					
					Statement stmnt = conn1.createStatement();
					
					stmnt.executeUpdate(sql);
					
					String sql1 = "commit";
					ResultSet rst1 = stmnt.executeQuery(sql1);
					
					JOptionPane.showMessageDialog(null,"Order Placed: "+rs.getString("food_item"));
					conn.close();
					conn1.close();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Order Couldn't be Placed");
					conn.close();
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
	}
	

}