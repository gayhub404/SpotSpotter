package pers.zylo117.spotspotter.patternrecognition;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageReader;

import pers.zylo117.spotspotter.toolbox.File2ImageReader;
import pers.zylo117.spotspotter.toolbox.GetPostfix;

public class ScaleScaler {
	public static BufferedImage mosaic(String input, int width, int height) throws IOException {

		// ��ȡͼƬ��ʽ
		String formatname = GetPostfix.getPostfix(input);

		// ͼƬ�������
		ImageReader reader = File2ImageReader.F2IR(input);
		int oriwidth = reader.getWidth(0);
		int oriheight = reader.getHeight(0);
		
		
		
		return null;
		
	}
}