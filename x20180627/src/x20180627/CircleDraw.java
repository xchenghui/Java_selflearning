/*
 * java绘图原理
 * Component类提供了两个和绘图相关最重要的方法
 * 1.paint(Graphics g)绘图组件外观
 * 2.repaint()刷新组件外观
 */

package x20180627;
import javax.swing.*;
import java.awt.*;
public class CircleDraw extends JFrame{

	Mypanel mp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CircleDraw cd = new CircleDraw();

	}
	public CircleDraw()
	{
		mp = new Mypanel();
		
		this.add(mp);
		
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
}

//定义一个MyPanel(我自己的面板，是用于绘图和实现绘图的工具)
class Mypanel extends JPanel
{
	//覆盖JPanel的paint函数
	//Graphics 是绘图的重要类，你可以把它理解成一直画笔
	
	public void paint(Graphics g)  //自动调用paint(),窗口大小变化的时候，会调用
	{
		//1.调用父类函数完成初始化任务
		//这句话，不能少
		super.paint(g);
		
		System.out.println("Paint have been used"); //证明
		//先画出一个园
//		g.drawOval(10, 10, 30, 30);//椭圆函数
//		
//		//画出举行边框
//		g.drawRect(200,100 , 123, 62);
//		
		//填充矩形
		//设置颜色
//		g.setColor(Color.PINK);   Ctrl+/
//		g.fillRect(100, 50, 90, 60);
//		g.setColor(Color.LIGHT_GRAY);
//		g.fillRect(70, 60, 50, 30);
		
		//在面板上画出图片
//		Image im = Toolkit.getDefaultToolkit().getImage
//				(Panel.class.getResource("/Taiyan1.jpg"));
//		//显示
//		g.drawImage(im, 40, 40, 123, 80,this);
		
		//如何画出字
		g.setFont(new Font("隶书",Font.BOLD,30));
		g.setColor(Color.RED);
		g.drawString("祖国万岁", 100, 100);
	}
}






















