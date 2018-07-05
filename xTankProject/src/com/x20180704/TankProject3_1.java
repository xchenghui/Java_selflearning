/*
 * 坦克游戏3.0版本
 * 画出坦克这个对象
 * 我的坦克可以上下左右移动
 * 按下j可以发射一颗子弹(最多添加5颗)
 * 当击中敌人的坦克时，敌人就消失（爆炸的效果）
 * 当敌人击中我们，我们的坦克小时
 * 
 */


package com.x20180704;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
public class TankProject3_1 extends JFrame{

	MyPanel mp = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TankProject3_1 tp = new TankProject3_1();
	}
	
	//构造函数
	public TankProject3_1()
	{
		mp = new MyPanel();
		
		//启动mp线程
		Thread t = new Thread(mp);
		t.start();
		
		this.add(mp);
		
		//注册监听者
		this.addKeyListener(mp);
				
		this.setSize(400,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

//我的面板
class MyPanel extends JPanel implements KeyListener,Runnable
{
	//定义一个我的坦克
	Hero hero = null;
	
	//定义敌人的坦克组
	Vector<EnemyTank> ets = new Vector<EnemyTank>();
	
	//定义炸弹向量
	Vector<Bomb> bombs = new Vector<Bomb>();

	int etSize = 3;  //敌人坦克的数量
	
	Image image1 = null; //定义图片,多张图片组成一颗炸弹
	Image image2 = null;
	
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
			
			Thread t = new Thread(et);
			t.start();
			
			//给敌人坦克添加一颗子弹
			Shot s = new Shot(et.x+10,et.y+30,2);
			//加入给敌人
			et.ss.add(s);
			
			Thread t2 = new Thread(s);
			t2.start();
			
			//加入
			ets.add(et);
		}
		
		//初始化图片
		image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/Capture.PNG"));
		image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/123.jpg"));
	}
	
	//重写paint 函数
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.fillRect(0, 0, 400, 300);
		//g.setColor(Color.CYAN);

		//画出自己的坦克
		if(hero.isLive){
			this.drawTank(this.hero.x, this.hero.y, g, this.hero.direct, 1);
		}
		
		//从vector ss中取出每一颗子弹
		for(int i =0; i<hero.ss.size();i++)
		{
			Shot myShot = hero.ss.get(i);
		//画出子弹 一颗
				if(myShot!=null && myShot.isLive == true)
				{
					g.draw3DRect(myShot.x, myShot.y, 1, 1, false);
				}
				if(myShot.isLive == false)
				{
					//从向量ss中删除这个elements子弹。
					hero.ss.remove(myShot);
				}
		}
		
		//画出炸弹
		for(int i=0; i<bombs.size();i++)
		{
			//取出炸弹
			Bomb b = bombs.get(i);
			
			if(b.life >6)
			{
				g.drawImage(image1, b.x, b.y, 30, 30,this);
			}
			else if(b.life>3)
			{
				g.drawImage(image2, b.x, b.y, 31, 31,this);
			}
			b.lifeDown();
			
			//如果炸弹生命值为0，就把该炸弹从向量中去掉
			if(b.life ==0)
			{
				bombs.remove(b);
			}
		}
		
		
		
		//画出敌人的坦克,和敌人的子弹
		for(int i =0; i <ets.size();i++)
		{
			EnemyTank st = ets.get(i);
			
			if(st.isLive){
			this.drawTank(st.getX(), st.getY(), g, st.getDirect(), 0);
			
			//画出敌人的子弹
			for(int j=0; j<st.ss.size();j++)
			{
				//取出子弹
				Shot enemyShot = st.ss.get(j);
				if(enemyShot.isLive)
				{
					g.draw3DRect(enemyShot.x, enemyShot.y, 1, 1, false);
				}else{
					//如果敌人的坦克死亡了，就从向量里去掉子弹
					st.ss.remove(enemyShot);
				}
			}
		}
			
		}
		
	}
	
	//判断我的坦克是否被集中
	public void hitMe()
	{
		//取出每一个敌人的坦克
		for(int i=0;i<this.ets.size();i++)
		{
			//取出坦克
			EnemyTank et = ets.get(i);
			
			//取出每一颗子弹
			for(int j=0; j<et.ss.size();j++)
			{
				//取出子弹
				Shot enemyShot = et.ss.get(j);
				
				this.hitTank(enemyShot, hero);
			}
		}
	}
	//判断我的子弹是否击中敌人的坦克
	public void hitEnemy()
	{
		//判断是否击中敌人的坦克
		for(int i =0; i<hero.ss.size();i++)
		{
			//取出子弹
			Shot myShot = hero.ss.get(i);
			//判断子弹是否有效
			if(myShot.isLive )
			{
				//匹配每个坦克
				for(int j=0; j<ets.size();j++)
				{
					//取出坦克
					EnemyTank et = ets.get(j);
					
					if(et.isLive)
					{
						this.hitTank(myShot, et);
					}
				}
			}
		}
	}
	//写一个函数专门判断子弹是否集中敌人坦克
	
	public void hitTank(Shot s, Tank et)
	{
		//判断该坦克的方向
		switch(et.direct)
		{
		//方向是上或者是下
		case 0:
		case 2:
			if(s.x>et.x && s.x<et.x+20 && s.y>et.y && s.y<et.y+30)
			{
				//击中
				
				//1.子弹死亡
				s.isLive = false;
				//2.敌人坦克死亡
				et.isLive = false;
				
				//创建一颗炸弹
				Bomb bomb = new Bomb(et.x,et.y);
				bombs.add(bomb);
				
				
			}
		case 1:
		case 3:
			if(s.x>et.x && s.x<et.x+30 && s.y>et.y && s.y<et.y+20)
			{
				//击中
				
				//1.子弹死亡
				s.isLive = false;
				//2.敌人坦克死亡
				et.isLive = false;
				
				//创建一颗炸弹
				Bomb bomb = new Bomb(et.x,et.y);
				bombs.add(bomb);
			}
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
			//System.out.println("up");
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
		if(e.getKeyCode() == KeyEvent.VK_J)
		{
			if(hero.ss.size() <=4){    //判断最多5颗子弹
				this.hero.shotEnemy();
			}
		}
		//必须重新绘制Panel
		this.repaint();
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {

		// TODO Auto-generated method stub
		
		//每隔100毫秒重绘
		while(true)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//判断敌人是否被我们击中
			this.hitEnemy();
			
			//判断自己的坦克是否被击中
			this.hitMe();
			
			
			
			
			this.repaint();
		}

}
}
































