package pers.zylo117.spotspotter.pictureprocess;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import pers.zylo117.spotspotter.patternrecognition.GetPixelArray;

public class ImageStream2File {

	public static File rawoutputimage;
	public static ImageOutputStream rawoutputstream;

	public static void setData(ImageOutputStream ios, String path) throws IOException {
		rawoutputimage = new File(path);
		Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName(GetPixelArray.formatname);
		ImageWriter writer = (ImageWriter) writers.next();
		// һ����ȡ��һ��ImageWriter���󣬱����������һ�����ԴImageOutputStream��
		writer.setOutput(ios);

	}
}
