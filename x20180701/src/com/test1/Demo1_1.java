/*
 * �¼���������
 */

package com.test1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Demo1_1 extends JFrame implements ActionListener{

	//����һ��panel
	JPanel mp =null;
	
	JButton jb1 = null;
	JButton jb2 = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Demo1_1 demo = new Demo1_1();
	}

	public Demo1_1()
	{
		mp = new JPanel();
		jb1 = new JButton("��ɫ");
		jb2 = new JButton("��ɫ");
		
		this.add(jb1,BorderLayout.NORTH);
		mp.setBackground(Color.black);
		this.add(mp);
		this.add(jb2,BorderLayout.SOUTH);
		
		Cat mycat1= new Cat();
		
		//ע�����
		jb1.addActionListener(this);
		//��jb1.addActionListener(mycat1)
		//�Ϳ����Ƴ��¼�Դ������jb1,ʱ�����������mycat1
		jb1.addActionListener(mycat1);
		
		
		//ָ��action���� 
		jb1.setActionCommand("Black");
		
		
		jb2.addActionListener(this);
		jb2.addActionListener(mycat1);
		jb2.setActionCommand("Red");
		
		this.setSize(200,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	//���¼������Ľ������
	@Override
	public void actionPerformed(ActionEvent e) { //�����Ϣ������
		// TODO Auto-generated method stub
		
		//�ж����ĸ���ť�����
		if(e.getActionCommand().equals("Black"))
		{
			System.out.println("You Click Black button");
			mp.setBackground(Color.BLACK);
		}
		else if(e.getActionCommand().equals("Red"))
		{
			System.out.println("You Click red Button");
			mp.setBackground(Color.red);
		}else{
			System.out.println("Error");
		}
	}
}

class Cat implements ActionListener
{

	@Override   //actionPerformed���Ǵ�������
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("Black"))
		{
			System.out.println("Cat know you click black button");
		}else if(arg0.getActionCommand().equals("Red"))
		{
			System.out.println("Cat know you click red button");
		}
	}
	
}

/*
 * һ����Ҫʵ�ֽ�ͧ�Ĳ���
 *ʵ����Ӧ�Ľӿڡ�KetListener ...��
 * �ɽӿڵĴ�������������Ҫ����д��ovrride��
 * ���¼�Դ��ע�����
 */
//class MyPanel extends JPanel
//{
//	public void paint(Graphics g)
//	{
//		super.paint(g);
//		//g.fillRect(0, 0, 200, height);
//	}
//}




























