/*
 * 流式布局案例
 */

package x20180626;
import java.awt.*;
import javax.swing.*;
public class Demo8_3 extends JFrame{
	
	//定义需要的组建
	JButton jb1 = null;
	JButton jb2 = null;
	JButton jb3 = null;
	JButton jb4 = null;
	JButton jb5 = null;
	JButton jb6 = null;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo8_3 demo8_3 = new Demo8_3();
	}
	
	public Demo8_3()
	{
		//创建组件
		jb1 = new JButton("guanyu");
		jb2 = new JButton("guanyu2");
		jb3 = new JButton("guanyu3");
		jb4 = new JButton("guanyu4");
		jb5 = new JButton("guanyu5");
		jb6 = new JButton("guanyu6");
		
		
		//添加组件
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
		
		//设置布局管理器
		this.setLayout(new FlowLayout(FlowLayout.TRAILING));
		
		
		//设置窗体属性
				this.setTitle("边界布局案例");
				this.setSize(600,300);
				this.setLocation(200,200);
				
				//禁止用户改变窗体大小
				this.setResizable(false);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				this.setVisible(true);
		
	}
}






