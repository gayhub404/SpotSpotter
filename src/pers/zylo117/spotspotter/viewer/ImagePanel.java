package pers.zylo117.spotspotter.viewer;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class ImagePanel extends Panel {

	private final Image screenImage = new BufferedImage(800, 600, 2);

	private final Graphics2D screenGraphic = (Graphics2D) screenImage.getGraphics();

	private Image backgroundImage;

	public ImagePanel(String input) {
		loadImage(input);
		// �趨�����ڱ�����
		setFocusable(true);
		// �趨��ʼ����ʱ����С,�����Ȳ���ͼƬ�Ĵ�С
		setPreferredSize(new Dimension(800, 600));
		// ���Ʊ���
		drawView();
	}

	/**
	 * ����ͼ��
	 */
	private void loadImage(String input) {
		// ��õ�ǰ���Ӧ�����λ��image�ļ����µı���ͼ��
		ImageIcon icon = new ImageIcon(getClass().getResource(input));
		// ��ͼ��ʵ������backgroundImage
		backgroundImage = icon.getImage();
	}

	private void drawView() {
		screenGraphic.drawImage(backgroundImage, 0, 0, null);
	}

	public void paint(Graphics g) {
		g.drawImage(screenImage, 0, 0, null);
	}

}