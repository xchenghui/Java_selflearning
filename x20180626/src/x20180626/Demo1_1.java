/*
 * BorderLanout��ʾ
 * 1.�̳�JFrame
 * 2.��������Ҫ���齨
 * 3.������������캯����
 * 4.������
 * 5.�Դ�������
 * 6.��ʾ����
 */



package x20180626;
import java.awt.*;
import javax.swing.*;

public class Demo1_1 extends JFrame{

	//�������
	JButton jb1,jb2,jb3,jb4,jb5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo1_1 de = new Demo1_1();
	}
	//���캯��
	public Demo1_1()
	{
		//�������
		jb1 = new JButton("middle");
		jb2 = new JButton("North");
		jb3 = new JButton("East");
		jb4 = new JButton("West");
		jb5 = new JButton("South");
		
		//��Ӹ������
		//this.add(jb1,BorderLayout.CENTER);
		this.add(jb2,BorderLayout.NORTH);
		this.add(jb3,BorderLayout.EAST);
		this.add(jb4, BorderLayout.WEST);
		this.add(jb5,BorderLayout.SOUTH);
		
		//���ô�������
		this.setTitle("�߽粼�ְ���");
		this.setSize(300,200);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ʾ����
		this.setVisible(true);
		
	}
	
	
	
}
