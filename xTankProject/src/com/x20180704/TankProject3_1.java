/*
 * ̹����Ϸ3.0�汾
 * ����̹���������
 * �ҵ�̹�˿������������ƶ�
 * ����j���Է���һ���ӵ�(�������5��)
 * �����е��˵�̹��ʱ�����˾���ʧ����ը��Ч����
 * �����˻������ǣ����ǵ�̹��Сʱ
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
	
	//���캯��
	public TankProject3_1()
	{
		mp = new MyPanel();
		
		//����mp�߳�
		Thread t = new Thread(mp);
		t.start();
		
		this.add(mp);
		
		//ע�������
		this.addKeyListener(mp);
				
		this.setSize(400,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

//�ҵ����
class MyPanel extends JPanel implements KeyListener,Runnable
{
	//����һ���ҵ�̹��
	Hero hero = null;
	
	//������˵�̹����
	Vector<EnemyTank> ets = new Vector<EnemyTank>();
	
	//����ը������
	Vector<Bomb> bombs = new Vector<Bomb>();

	int etSize = 3;  //����̹�˵�����
	
	Image image1 = null; //����ͼƬ,����ͼƬ���һ��ը��
	Image image2 = null;
	
	//���캯��
	public MyPanel()
	{
		hero = new Hero(100,100);
		
		//��ʼ�����˵�̹��
		for(int i =0; i<etSize;i++)
		{
			//����һ�����˵�̹�˶���
			EnemyTank et = new EnemyTank((i+1)*50,0);
			//����
			et.setColor(0);
			et.setDirect(2);
			
			Thread t = new Thread(et);
			t.start();
			
			//������̹������һ���ӵ�
			Shot s = new Shot(et.x+10,et.y+30,2);
			//���������
			et.ss.add(s);
			
			Thread t2 = new Thread(s);
			t2.start();
			
			//����
			ets.add(et);
		}
		
		//��ʼ��ͼƬ
		image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/Capture.PNG"));
		image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/123.jpg"));
	}
	
	//��дpaint ����
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.fillRect(0, 0, 400, 300);
		//g.setColor(Color.CYAN);

		//�����Լ���̹��
		if(hero.isLive){
			this.drawTank(this.hero.x, this.hero.y, g, this.hero.direct, 1);
		}
		
		//��vector ss��ȡ��ÿһ���ӵ�
		for(int i =0; i<hero.ss.size();i++)
		{
			Shot myShot = hero.ss.get(i);
		//�����ӵ� һ��
				if(myShot!=null && myShot.isLive == true)
				{
					g.draw3DRect(myShot.x, myShot.y, 1, 1, false);
				}
				if(myShot.isLive == false)
				{
					//������ss��ɾ�����elements�ӵ���
					hero.ss.remove(myShot);
				}
		}
		
		//����ը��
		for(int i=0; i<bombs.size();i++)
		{
			//ȡ��ը��
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
			
			//���ը������ֵΪ0���ͰѸ�ը����������ȥ��
			if(b.life ==0)
			{
				bombs.remove(b);
			}
		}
		
		
		
		//�������˵�̹��,�͵��˵��ӵ�
		for(int i =0; i <ets.size();i++)
		{
			EnemyTank st = ets.get(i);
			
			if(st.isLive){
			this.drawTank(st.getX(), st.getY(), g, st.getDirect(), 0);
			
			//�������˵��ӵ�
			for(int j=0; j<st.ss.size();j++)
			{
				//ȡ���ӵ�
				Shot enemyShot = st.ss.get(j);
				if(enemyShot.isLive)
				{
					g.draw3DRect(enemyShot.x, enemyShot.y, 1, 1, false);
				}else{
					//������˵�̹�������ˣ��ʹ�������ȥ���ӵ�
					st.ss.remove(enemyShot);
				}
			}
		}
			
		}
		
	}
	
	//�ж��ҵ�̹���Ƿ񱻼���
	public void hitMe()
	{
		//ȡ��ÿһ�����˵�̹��
		for(int i=0;i<this.ets.size();i++)
		{
			//ȡ��̹��
			EnemyTank et = ets.get(i);
			
			//ȡ��ÿһ���ӵ�
			for(int j=0; j<et.ss.size();j++)
			{
				//ȡ���ӵ�
				Shot enemyShot = et.ss.get(j);
				
				this.hitTank(enemyShot, hero);
			}
		}
	}
	//�ж��ҵ��ӵ��Ƿ���е��˵�̹��
	public void hitEnemy()
	{
		//�ж��Ƿ���е��˵�̹��
		for(int i =0; i<hero.ss.size();i++)
		{
			//ȡ���ӵ�
			Shot myShot = hero.ss.get(i);
			//�ж��ӵ��Ƿ���Ч
			if(myShot.isLive )
			{
				//ƥ��ÿ��̹��
				for(int j=0; j<ets.size();j++)
				{
					//ȡ��̹��
					EnemyTank et = ets.get(j);
					
					if(et.isLive)
					{
						this.hitTank(myShot, et);
					}
				}
			}
		}
	}
	//дһ������ר���ж��ӵ��Ƿ��е���̹��
	
	public void hitTank(Shot s, Tank et)
	{
		//�жϸ�̹�˵ķ���
		switch(et.direct)
		{
		//�������ϻ�������
		case 0:
		case 2:
			if(s.x>et.x && s.x<et.x+20 && s.y>et.y && s.y<et.y+30)
			{
				//����
				
				//1.�ӵ�����
				s.isLive = false;
				//2.����̹������
				et.isLive = false;
				
				//����һ��ը��
				Bomb bomb = new Bomb(et.x,et.y);
				bombs.add(bomb);
				
				
			}
		case 1:
		case 3:
			if(s.x>et.x && s.x<et.x+30 && s.y>et.y && s.y<et.y+20)
			{
				//����
				
				//1.�ӵ�����
				s.isLive = false;
				//2.����̹������
				et.isLive = false;
				
				//����һ��ը��
				Bomb bomb = new Bomb(et.x,et.y);
				bombs.add(bomb);
			}
		}
		
	}
	
	//����̹�˺�������չ��
	public void drawTank(int x, int y, Graphics g, int direct, int type)
	{
		//�ж���ʲô���͵�̹��
		switch(type)
		{
		case 0:
			g.setColor(Color.CYAN);
			break;
		case 1:
			g.setColor(Color.green);
			break; 
		}
		
		//�жϷ���
		switch(direct)
		{
		//����
		case 0:
			//�����ҵ�̹��
			//1.������ߵľ���
			g.fill3DRect(x, y, 5, 30,false);
			//2.�����ұߵľ���
			g.fill3DRect(x+15, y, 5, 30,false);
			//3.�����м����
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//����Բ��
			g.fillOval(x+5, y+10, 10, 10);
			//������
			g.drawLine(x+10, y+15, x+10, y);
			//g.setColor(Color.black);
//			g.drawLine(x, y+5, x+5, y+5);
//			g.drawLine(x, y+10, x+5, y+10);
//			g.drawLine(x, y+15, x+5, y+15);
//			g.drawLine(x, y+20, x+5, y+20);
//			g.drawLine(x, y+25, x+5, y+25);
			break;
		case 1:
			//��Ͳ����
			g.fill3DRect(x, y, 30, 5, false);
			g.fill3DRect(x, y+15, 30, 5, false);
			g.fill3DRect(x+5, y+5, 20, 10, false);
			
			g.fillOval(x+10, y+5, 10, 10);
			g.drawLine(x+15, y+10, x+30, y+10);
			break;
		case 2:
			g.fill3DRect(x, y, 5, 30,false);
			//2.�����ұߵľ���
			g.fill3DRect(x+15, y, 5, 30,false);
			//3.�����м����
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//����Բ��
			g.fillOval(x+5, y+10, 10, 10);
			//������
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
	//�����´��� WSAD
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
//		//����repaint()���������ػ����
//		this.repaint();
		
		if(e.getKeyCode()==KeyEvent.VK_W)
		{
			//�����ҵ�̹�˵ķ���
			this.hero.setDirect(0);
			this.hero.moveUp();
			//System.out.println("up");
		}else if(e.getKeyCode()==KeyEvent.VK_D)
		{
			//����
			this.hero.setDirect(1);
			this.hero.moveRight();
		}else if(e.getKeyCode()==KeyEvent.VK_S)
		{
			//����
			this.hero.setDirect(2);
			this.hero.moveDown();
		}else if(e.getKeyCode()==KeyEvent.VK_A)
		{
			//����
			this.hero.setDirect(3);
			this.hero.moveLeft();
		}
		if(e.getKeyCode() == KeyEvent.VK_J)
		{
			if(hero.ss.size() <=4){    //�ж����5���ӵ�
				this.hero.shotEnemy();
			}
		}
		//�������»���Panel
		this.repaint();
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {

		// TODO Auto-generated method stub
		
		//ÿ��100�����ػ�
		while(true)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//�жϵ����Ƿ����ǻ���
			this.hitEnemy();
			
			//�ж��Լ���̹���Ƿ񱻻���
			this.hitMe();
			
			
			
			
			this.repaint();
		}

}
}































