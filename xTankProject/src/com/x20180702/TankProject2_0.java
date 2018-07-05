/*
 * 坦克游戏2.0版本
 * 画出坦克这个对象
 * 我的坦克可以上下左右移动
 */


package com.x20180702;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
public class TankProject2_0 extends JFrame{

	MyPanel mp = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TankProject2_0 tp = new TankProject2_0();
	}
	
	//构造函数
	public TankProject2_0()
	{
		mp = new MyPanel();
		
		this.add(mp);
		
		//注册监听者
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
	
	//定义敌人的坦克组
	Vector<EnemyTank> ets = new Vector<EnemyTank>();
	
	int etSize = 3;  //敌人坦克的数量
	
	
	//构造函数
	public MyPanel()
	{
		hero = new Hero(100,100);
		
		//初始化敌人的坦克
		for(int i =0; i<etSize;i++)
		{
			//创建一个敌人的坦克对象
			EnemyTank et = new EnemyTank((i+1)*50,0);
			//加入
			et.setColor(0);
			et.setDirect(2);
			ets.add(et);
		}
	}
	
	//重写paint 函数
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.fillRect(0, 0, 400, 300);
		//g.setColor(Color.CYAN);
		
		//画出自己的坦克
		this.drawTank(this.hero.x, this.hero.y, g, this.hero.direct, 1);
		
		//画出敌人的坦克
		for(int i =0; i <ets.size();i++)
		{
			this.drawTank(this.ets.get(i).getX(), ets.get(i).getY(), g, ets.get(i).getDirect(), 0);
		}
		
	}
	
	//画出坦克函数（扩展）
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
			//g.setColor(Color.black);
//			g.drawLine(x, y+5, x+5, y+5);
//			g.drawLine(x, y+10, x+5, y+10);
//			g.drawLine(x, y+15, x+5, y+15);
//			g.drawLine(x, y+20, x+5, y+20);
//			g.drawLine(x, y+25, x+5, y+25);
			break;
		case 1:
			//炮筒向右
			g.fill3DRect(x, y, 30, 5, false);
			g.fill3DRect(x, y+15, 30, 5, false);
			g.fill3DRect(x+5, y+5, 20, 10, false);
			
			g.fillOval(x+10, y+5, 10, 10);
			g.drawLine(x+15, y+10, x+30, y+10);
			break;
		case 2:
			g.fill3DRect(x, y, 5, 30,false);
			//2.画出右边的矩形
			g.fill3DRect(x+15, y, 5, 30,false);
			//3.画出中间矩形
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//画出圆形
			g.fillOval(x+5, y+10, 10, 10);
			//画出线
			g.drawLine(x+10, y+15, x+10, y+30);
			break;
		case 3:
			g.fill3DRect(x, y, 30, 5, false);
			g.fill3DRect(x, y+15, 30, 5, false);
			g.fill3DRect(x+5, y+5, 20, 10, false);
			
			g.fillOval(x+10, y+5, 10, 10);
			g.drawLine(x+15, y+10, x, y+10);
			break;	
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//按向下处理 WSAD
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
//		if(e.getKeyCode() == KeyEvent.VK_DOWN)
//		{
//			//System.out.println("12");
//			y = y + 10;
//			System.out.println("Down");
//		}else if(e.getKeyCode() ==KeyEvent.VK_UP)
//		{
//			y-=10;
//			System.out.println("Up");
//		}else if(e.getKeyCode() ==KeyEvent.VK_LEFT)
//		{
//			x-=10;
//			System.out.println("Left");
//		}else if(e.getKeyCode() ==KeyEvent.VK_RIGHT)
//		{
//			x+=10;
//			System.out.println("Right");
//		}
//		//调用repaint()函数，来重绘界面
//		this.repaint();
		
		if(e.getKeyCode()==KeyEvent.VK_W)
		{
			//设置我的坦克的方向
			this.hero.setDirect(0);
			this.hero.moveUp();
			System.out.println("up");
		}else if(e.getKeyCode()==KeyEvent.VK_D)
		{
			//向右
			this.hero.setDirect(1);
			this.hero.moveRight();
		}else if(e.getKeyCode()==KeyEvent.VK_S)
		{
			//向下
			this.hero.setDirect(2);
			this.hero.moveDown();
		}else if(e.getKeyCode()==KeyEvent.VK_A)
		{
			//向左
			this.hero.setDirect(3);
			this.hero.moveLeft();
		}
		//必须重新绘制Panel
		this.repaint();
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}






























