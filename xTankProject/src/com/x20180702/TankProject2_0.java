/*
 * ̹����Ϸ2.0�汾
 * ����̹���������
 * �ҵ�̹�˿������������ƶ�
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
	
	//���캯��
	public TankProject2_0()
	{
		mp = new MyPanel();
		
		this.add(mp);
		
		//ע�������
		this.addKeyListener(mp);
		
		
		this.setSize(400,300);
		this.setVisible(true);
		
	}
}

//�ҵ����
class MyPanel extends JPanel implements KeyListener
{
	
	//����һ���ҵ�̹��
	Hero hero = null;
	
	//������˵�̹����
	Vector<EnemyTank> ets = new Vector<EnemyTank>();
	
	int etSize = 3;  //����̹�˵�����
	
	
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
			ets.add(et);
		}
	}
	
	//��дpaint ����
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.fillRect(0, 0, 400, 300);
		//g.setColor(Color.CYAN);
		
		//�����Լ���̹��
		this.drawTank(this.hero.x, this.hero.y, g, this.hero.direct, 1);
		
		//�������˵�̹��
		for(int i =0; i <ets.size();i++)
		{
			this.drawTank(this.ets.get(i).getX(), ets.get(i).getY(), g, ets.get(i).getDirect(), 0);
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
			System.out.println("up");
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
		//�������»���Panel
		this.repaint();
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}






























