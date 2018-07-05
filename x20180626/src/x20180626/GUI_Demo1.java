/*
 * gui功能界面开发演示
 */


package x20180626;

//引入包
import java.awt.*;
import javax.swing.*;


public class GUI_Demo1 extends JFrame{
	
	//吧需要的swing组建，在这里定义
	JButton jb1 = null;
	public static void main(String []args)
	{
			GUI_Demo1 demo1 = new GUI_Demo1();
	}
	//构造函数
	public GUI_Demo1()
	{
				//创建按钮组件
				 jb1 = new JButton("This is Button");
				
				//添加JButton组建
				this.add(jb1);	
			
				//给窗体设置标题
				this.setTitle("Hello, World");
				
				//设置大小，按像素计算
				this.setSize(200,200);
				
				
				
				//设置初始位置
				this.setLocation(100,200);
				
			
				//当关闭窗口的时候，保证jvm也推出
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				//显示
				this.setVisible(true);
			
	}
}





