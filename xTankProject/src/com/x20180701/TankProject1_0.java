/*
 * ̹����Ϸ1.0�汾
 * ����̹���������
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
	
	//���캯��
	public TankProject1_0()
	{
		mp = new MyPanel();
		
		this.add(mp);
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
	int x = 10;
	int y =10;
	//���캯��
	public MyPanel()
	{
		hero = new Hero(100,100);
	}
	
	//��дpaint ����
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.fillRect(0, 0, 400, 300);
		//g.setColor(Color.CYAN);
		this.drawTank(x, y, g, 0, 0);
	}
	
	//����̹�˺���
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
		//����repaint()���������ػ����
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

// ̹����
class Tank
{
	//��ʾ̹�˵ĺ�����
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

	//̹�˵�������
	int y =0;
	
	public Tank(int x, int y)
	{
		this.x= x;
		this.y = y;
	}
}

//�ҵ�̹��
class Hero extends Tank
{
	public Hero(int x, int y)
	{
		super(x,y);
	}
}





























