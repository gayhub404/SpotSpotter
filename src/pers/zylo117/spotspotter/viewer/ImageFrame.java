package pers.zylo117.spotspotter.viewer;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class ImageFrame extends Frame {

	public ImageFrame(String input) {

		// Ĭ�ϵĴ�������
		this.setTitle("ImageViewer");

		// �������ʵ��
		ImagePanel panel = new ImagePanel(input);
		this.add(panel);
		this.addWindowListener(new WindowAdapter() {
			// ���ùر�
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// ִ�в����������趨
		this.pack();
		this.setVisible(true);
	}

}