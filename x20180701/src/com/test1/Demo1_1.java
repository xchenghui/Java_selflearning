/*
 * 事件处理机制
 */

package com.test1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Demo1_1 extends JFrame implements ActionListener{

	//定义一个panel
	JPanel mp =null;
	
	JButton jb1 = null;
	JButton jb2 = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Demo1_1 demo = new Demo1_1();
	}

	public Demo1_1()
	{
		mp = new JPanel();
		jb1 = new JButton("黑色");
		jb2 = new JButton("红色");
		
		this.add(jb1,BorderLayout.NORTH);
		mp.setBackground(Color.black);
		this.add(mp);
		this.add(jb2,BorderLayout.SOUTH);
		
		Cat mycat1= new Cat();
		
		//注册监听
		jb1.addActionListener(this);
		//从jb1.addActionListener(mycat1)
		//就可以推出事件源对象是jb1,时间监听对象是mycat1
		jb1.addActionListener(mycat1);
		
		
		//指定action命令 
		jb1.setActionCommand("Black");
		
		
		jb2.addActionListener(this);
		jb2.addActionListener(mycat1);
		jb2.setActionCommand("Red");
		
		this.setSize(200,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	//对事件处理的解决方法
	@Override
	public void actionPerformed(ActionEvent e) { //会把信息带过来
		// TODO Auto-generated method stub
		
		//判断是哪个按钮被点击
		if(e.getActionCommand().equals("Black"))
		{
			System.out.println("You Click Black button");
			mp.setBackground(Color.BLACK);
		}
		else if(e.getActionCommand().equals("Red"))
		{
			System.out.println("You Click red Button");
			mp.setBackground(Color.red);
		}else{
			System.out.println("Error");
		}
	}
}

class Cat implements ActionListener
{

	@Override   //actionPerformed就是处理方法
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("Black"))
		{
			System.out.println("Cat know you click black button");
		}else if(arg0.getActionCommand().equals("Red"))
		{
			System.out.println("Cat know you click red button");
		}
	}
	
}

/*
 * 一个类要实现舰艇的步骤
 *实现相应的接口【KetListener ...】
 * 吧接口的处理方法根据需要重新写（ovrride）
 * 在事件源上注册监听
 */
//class MyPanel extends JPanel
//{
//	public void paint(Graphics g)
//	{
//		super.paint(g);
//		//g.fillRect(0, 0, 200, height);
//	}
//}





























