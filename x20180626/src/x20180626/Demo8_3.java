/*
 * ��ʽ���ְ���
 */

package x20180626;
import java.awt.*;
import javax.swing.*;
public class Demo8_3 extends JFrame{
	
	//������Ҫ���齨
	JButton jb1 = null;
	JButton jb2 = null;
	JButton jb3 = null;
	JButton jb4 = null;
	JButton jb5 = null;
	JButton jb6 = null;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo8_3 demo8_3 = new Demo8_3();
	}
	
	public Demo8_3()
	{
		//�������
		jb1 = new JButton("guanyu");
		jb2 = new JButton("guanyu2");
		jb3 = new JButton("guanyu3");
		jb4 = new JButton("guanyu4");
		jb5 = new JButton("guanyu5");
		jb6 = new JButton("guanyu6");
		
		
		//������
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
		
		//���ò��ֹ�����
		this.setLayout(new FlowLayout(FlowLayout.TRAILING));
		
		
		//���ô�������
				this.setTitle("�߽粼�ְ���");
				this.setSize(600,300);
				this.setLocation(200,200);
				
				//��ֹ�û��ı䴰���С
				this.setResizable(false);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				this.setVisible(true);
		
	}
}






