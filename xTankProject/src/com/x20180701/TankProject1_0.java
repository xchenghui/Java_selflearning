/*
 * 坦克游戏1.0版本
 * 画出坦克这个对象
 */


package com.x20180701;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class TankProject1_0 extends JFrame{

	MyPanel mp = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TankProject1_0 tp = new TankProject1_0();
	}
	
	//构造函数
	public TankProject1_0()
	{
		mp = new MyPanel();
		
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(400,300);
		this.setVisible(true);
		
	}
}

//我的面板
class MyPanel extends JPanel implements KeyListener
{
	
	//定义一个我的坦克
	Hero hero = null;
	int x = 10;
	int y =10;
	//构造函数
	public MyPanel()
	{
		hero = new Hero(100,100);
	}
	
	//重写paint 函数
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.fillRect(0, 0, 400, 300);
		//g.setColor(Color.CYAN);
		this.drawTank(x, y, g, 0, 0);
	}
	
	//画出坦克函数
	public void drawTank(int x, int y, Graphics g, int direct, int type)
	{
		//判断是什么类型的坦克
		switch(type)
		{
		case 0:
			g.setColor(Color.CYAN);
			break;
		case 1:
			g.setColor(Color.green);
			break; 
		}
		
		//判断方向
		switch(direct)
		{
		//向上
		case 0:
			//画出我的坦克
			//1.画出左边的矩形
			g.fill3DRect(x, y, 5, 30,false);
			//2.画出右边的矩形
			g.fill3DRect(x+15, y, 5, 30,false);
			//3.画出中间矩形
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//画出圆形
			g.fillOval(x+5, y+10, 10, 10);
			//画出线
			g.drawLine(x+10, y+15, x+10, y);
			
			g.setColor(Color.black);
			g.drawLine(x, y+5, x+5, y+5);
			g.drawLine(x, y+10, x+5, y+10);
			g.drawLine(x, y+15, x+5, y+15);
			g.drawLine(x, y+20, x+5, y+20);
			g.drawLine(x, y+25, x+5, y+25);
			
			
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			//System.out.println("12");
			y = y + 10;
			System.out.println("Down");
		}else if(e.getKeyCode() ==KeyEvent.VK_UP)
		{
			y-=10;
			System.out.println("Up");
		}else if(e.getKeyCode() ==KeyEvent.VK_LEFT)
		{
			x-=10;
			System.out.println("Left");
		}else if(e.getKeyCode() ==KeyEvent.VK_RIGHT)
		{
			x+=10;
			System.out.println("Right");
		}
		//调用repaint()函数，来重绘界面
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

// 坦克类
class Tank
{
	//表示坦克的横坐标
	int x =0;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	//坦克的纵坐标
	int y =0;
	
	public Tank(int x, int y)
	{
		this.x= x;
		this.y = y;
	}
}

//我的坦克
class Hero extends Tank
{
	public Hero(int x, int y)
	{
		super(x,y);
	}
}





























