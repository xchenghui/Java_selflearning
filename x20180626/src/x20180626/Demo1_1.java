/*
 * BorderLanout演示
 * 1.继承JFrame
 * 2.定义你需要的组建
 * 3.创建组件（构造函数）
 * 4.添加组件
 * 5.对窗体设置
 * 6.显示窗体
 */



package x20180626;
import java.awt.*;
import javax.swing.*;

public class Demo1_1 extends JFrame{

	//定义组件
	JButton jb1,jb2,jb3,jb4,jb5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo1_1 de = new Demo1_1();
	}
	//构造函数
	public Demo1_1()
	{
		//创建组件
		jb1 = new JButton("middle");
		jb2 = new JButton("North");
		jb3 = new JButton("East");
		jb4 = new JButton("West");
		jb5 = new JButton("South");
		
		//添加各个组件
		//this.add(jb1,BorderLayout.CENTER);
		this.add(jb2,BorderLayout.NORTH);
		this.add(jb3,BorderLayout.EAST);
		this.add(jb4, BorderLayout.WEST);
		this.add(jb5,BorderLayout.SOUTH);
		
		//设置窗体属性
		this.setTitle("边界布局案例");
		this.setSize(300,200);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//显示窗体
		this.setVisible(true);
		
	}
	
	
	
}
