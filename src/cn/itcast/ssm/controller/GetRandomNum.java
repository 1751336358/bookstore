package cn.itcast.ssm.controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

//��¼��ע��ʱ��Ҫ������֤��
@Controller
public class GetRandomNum{
	public int width = 120;	//ͼƬ���
	public int height = 40;	//ͼƬ�߶�
	@RequestMapping("/getImg.action")
	public void testImg(HttpServletResponse response,HttpSession session) throws Exception{
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D) image.getGraphics();

		//1�����ñ���ɫ
		setBackGround(g);
		//2�����ñ߿�
		setBorder(g);
		//3����������
		drawRandomLine(g);
		//4��д�����,�����ز����������
		String str= drawRandomNum(g);
		session.setAttribute("randomNum",str);//�����������������Session���ڵ�¼��ע���Controller��ȡֵ��֤
		//�����������ͼƬ�ķ�ʽ��
		response.setContentType("image/jpeg");
		//�����������Ҫ����
		response.setHeader("expries","-1");
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma","no-cache");
		//5��д�������
		ImageIO.write(image,"jpg",response.getOutputStream());
		//��Ҫ�з���
	}
	
	//���ñ�����ɫ
	private void setBackGround(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
	}
	//���ñ߿�
	private void setBorder(Graphics g){
		g.setColor(Color.BLUE);
		g.drawRect(1, 1, width-2, height-2);
	}
	//��������
	private void drawRandomLine(Graphics g){
		g.setColor(Color.GREEN);
		for(int i = 0;i<5;i++){
			int x1 = new Random().nextInt(width);
			int y1 = new Random().nextInt(height);
			int x2 = new Random().nextInt(width);
			int y2 = new Random().nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}
	}
	//���������
	private String drawRandomNum(Graphics2D g){
		String str = "";
		//����������ɫ
		g.setColor(Color.RED);
		g.setFont(new Font("����",Font.BOLD,20));
		String base = "abcdefghijklmnopqrstuvwxyz123456789";
		int x = 5;//�����λ��
		for(int i = 0;i<4;i++){
			int degree = new Random().nextInt()%30;//��ת�Ƕ�
			int index = new Random().nextInt(base.length());
			
			String ch = base.charAt(index)+"";
			str += ch;	//�������������ƴ���������أ���̨��֤
			g.rotate(degree*Math.PI/180, x,height);
			g.drawString(ch, x, 20);
			g.rotate(-degree*Math.PI/180, x, height);
			x+= 30;
		}
		return str;
	}
}
