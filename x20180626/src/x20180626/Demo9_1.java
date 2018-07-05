/*
 * 网格布局
 */

package x20180626;
import java.awt.*;
import javax.swing.*;
public class Demo9_1 extends JFrame{
	
	//定义组建
	JButton jbs[] = new JButton[9];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//创建实例
		Demo9_1 de = new Demo9_1();
	}
	
	public Demo9_1()
	{
		//创建组件
		for(int i=0;i<9;i++)
		{
			jbs[i] = new JButton(String.valueOf(i));
		}
		
		   //设置网格布局
		this.setLayout(new GridLayout(3,4,10,10));
		
		//添加组件
		for(int i=0;i<9;i++)
		{
			this.add(jbs[i]);
		}
		
		//设置窗体属性
		this.setTitle("网格布局");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(200,300);
		
		//显示
		this.setVisible(true);
		
		
		
	}
}
