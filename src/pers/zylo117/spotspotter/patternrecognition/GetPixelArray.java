package pers.zylo117.spotspotter.patternrecognition;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

import pers.zylo117.spotspotter.toolbox.GetPostfix;
import pers.zylo117.spotspotter.toolbox.Timer;

public class GetPixelArray {

	public static int[][] data;
	// ����RGB����,�Ǳ�Ҫ,0=Red,1=Green,2=Blue,8bit�ҽ�ͼƬRGB���
	public static int[] rgb = new int[3];
	public static int[][] rawoutputR;
	public static int[][] rawoutputG;
	public static int[][] rawoutputB;
	public static int[][] rawoutputRGB;
	public static String formatname;
	public static ImageOutputStream rawoutputstream;
	public static int[][] colorvalue;
//	public static BufferedImage outputimg;
	// ����ͼƬ���������
	public static Iterator<ImageReader> readers;
	public static ImageReader reader;
	public static ImageInputStream iis;

	public static void getData(String inputpath, String outputpath, int time, int ROIstart_x, int ROIstart_y,
			int ROIlength_x, int ROIlength_y) {
		
		long beginTime = new Date().getTime();

		// ��ʱ����
		Timer.timer(time);

		File file = new File(inputpath);

		// ��ȡͼƬ��ʽ
		formatname = GetPostfix.getPostfix(inputpath);

		BufferedImage bimg;
		if (formatname.equals("png")) {
			bimg = new BufferedImage(ROIlength_x, ROIlength_y, BufferedImage.TYPE_INT_ARGB);
		} else {
			bimg = new BufferedImage(ROIlength_x, ROIlength_y, BufferedImage.TYPE_INT_RGB);
		}

		try {
			// ��ȡͼƬ��
			// ����imageIO��ȡĳЩ��ʽ��ͼƬ��ICC��Ϣʱ�������Ը����ʽ��ͼƬҪ��ԭʼ������ȡ
			while (true) {
				if (formatname.equals("jpg")) {
//					Image pic = Toolkit.getDefaultToolkit().getImage(file.getPath());
//					bimg = Image2BufferedImage.toBufferedImage(pic);
					 readers = ImageIO.getImageReadersByFormatName(formatname);
					 reader = readers.next();
					 iis = ImageIO.createImageInputStream(file);
					 reader.setInput(iis, false);
					 int imageindex = 0;
					 bimg = reader.read(imageindex);
					 reader.dispose();
					 imageindex++;
					//
					// ���ؾ������㷨
					data = new int[ROIlength_x][ROIlength_y];
//					rawoutputR = new int[ROIlength_x][ROIlength_y];
//					rawoutputG = new int[ROIlength_x][ROIlength_y];
//					rawoutputB = new int[ROIlength_x][ROIlength_y];
//					rawoutputRGB = new int[ROIlength_x][ROIlength_y];
					colorvalue = new int[ROIlength_x][ROIlength_y];
					// ��ʽһ��ͨ��getRGB()��ʽ������ؾ���
					// �˷�ʽΪ��Height����ɨ��
					for (int i = 0; i < ROIlength_x; i++) {
						for (int j = 0; j < ROIlength_y; j++) {
							data[i][j] = bimg.getRGB(i + ROIstart_x, j + ROIstart_y);

//							rgb[0] = (data[i][j] & 0xff0000);
//							rgb[1] = (data[i][j] & 0xff00);
//							rgb[2] = (data[i][j] & 0xff);

//							// �����ͼ�������Ա�ͼ�Ĳ�ֵ
//							rawoutputR[i][j] = rgb[0] - Comparison.perfectdataR[i][j];
//							rawoutputG[i][j] = rgb[1] - Comparison.perfectdataG[i][j];
//							rawoutputB[i][j] = rgb[2] - Comparison.perfectdataB[i][j];
//							rawoutputRGB[i][j] = rawoutputR[i][j] + rawoutputG[i][j] + rawoutputB[i][j];

							// ���㵥ɫɫֵ
							colorvalue[i][j] = (data[i][j] & 0xff);
//							String tempst = Integer.toHexString(rawoutputRGB[i][j]);
//							String colorstr = tempst.substring(2, 4);
//							colorvalue[i][j] = Integer.valueOf(colorstr, 16);
							
							// ���һ�����ݱȶ�
//							if (i == 0) {
//								System.out.printf("%x\t", data[i][j]);
//								// System.out.printf("%x\t", rgb[0]);
//								// System.out.printf("%x\t", rgb[1]);
//								 System.out.printf("%x\t", rgb[2]);
//								// System.out.printf("ff%x\t", rgb[0] + rgb[1] + rgb[2]);
//								System.out.printf("%x\t", rawoutputRGB[i][j]);
//							}
						}
					}
					bimg.flush();
					System.out.println("");
					System.out.println("Input Image Reading Complete");

					// ���ǵ��ԣ���������м�ͼƬ
					// д������ARGB��Ϣ��ԭʼ����ͼ�񣬲�д�뵽ԭʼͼ��·��
//					if (formatname.equals("png")) {
//						outputimg = new BufferedImage(ROIlength_x, ROIlength_y, BufferedImage.TYPE_INT_ARGB);
//					} else {
//						outputimg = new BufferedImage(ROIlength_x, ROIlength_y, BufferedImage.TYPE_INT_RGB);
//					}
//
//					for (int i = 0; i < ROIlength_x; i++) {
//						for (int j = 0; j < ROIlength_y; j++) {
//							outputimg.setRGB(i, j, data[i][j]);
//						}
//					}
//					ImageStream2File.IS2F(outputimg, formatname, outputpath);
					
					System.out.println("Raw Image Output Complete");
					
					long endTime = new Date().getTime();
					System.out.println("Rawimage output Tact Time:[" + (endTime - beginTime) + "]ms");
					System.out.println("");
					break;
					
				} else {
					System.out.println("Current Version only support JPEG/JPG");
					System.out.println("");
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}