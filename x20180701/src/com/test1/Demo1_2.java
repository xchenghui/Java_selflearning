/*
 * ������¼��������Ƶ�����
 * 1.ͨ���������Ҽ�������С����ƶ���λ�ã�
 */

package com.test1;
import javax.swing.*;

import com.test2.MyPanel;

import java.awt.*;
import java.awt.Event;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Demo1_2 extends JFrame{

	
	MyPanel mp = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Demo1_2 demo = new Demo1_2();
	}

	//���캯��
	public Demo1_2()
	{
		mp = new MyPanel();
		
		this.add(mp);
		
		
		this.addKeyListener(mp);
		
		
		
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

//�����Լ������
class MyPanel extends JPanel implements KeyListener
{
	int x= 10; int y =10;
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.fillOval(x, y, 20, 20);
	}

	//����ֵ���������ӡ��
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	//��������
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Pressed" + (char)e.getKeyCode());
		
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

	//�����ͷ�
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}










