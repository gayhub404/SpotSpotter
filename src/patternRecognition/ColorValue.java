package patternRecognition;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import patternRecognition.Comparison;

public class ColorValue {

	public static int[][] data;
	// ����RGB����,�Ǳ�Ҫ,0=Red,1=Green,2=Blue,8bit�ҽ�ͼƬRGB���
	public static int[] rgb = new int [3];
	public static int[][] originalresultR;
	public static int[][] originalresultG;
	public static int[][] originalresultB;
	

	public static void getData(String path, int ROIstart_x, int ROIstart_y, int ROIlength_x, int ROIlength_y) {
		
		File file = new File(path);
		
		try {
			// ��ȡͼƬ��
			Iterator <ImageReader> readers = ImageIO.getImageReadersByFormatName("jpg");
			ImageReader reader = (ImageReader)readers.next();
			ImageInputStream iis = ImageIO.createImageInputStream(file);
			reader.setInput(iis, false);
			
			int imageindex = 0;
			BufferedImage bimg = reader.read(imageindex);
			reader.dispose();
			imageindex++;
			data = new int[ROIlength_x][ROIlength_y];
			originalresultR = new int[ROIlength_x][ROIlength_y];
			originalresultG = new int[ROIlength_x][ROIlength_y];
			originalresultB = new int[ROIlength_x][ROIlength_y];
			// ��ʽһ��ͨ��getRGB()��ʽ������ؾ���
			// �˷�ʽΪ��Height����ɨ��
			for (int i = 0; i < ROIlength_x; i++) {
				for (int j = 0; j < ROIlength_y; j++) {
					data[i][j] = bimg.getRGB(i + ROIstart_x, j + ROIstart_y);
					
			        rgb[0] = (data[i][j] & 0xff0000);
			        rgb[1] = (data[i][j] & 0xff00);
			        rgb[2] = (data[i][j] & 0xff);
				        
					// ���һ�����ݱȶ�
			        if(i == 0){
						System.out.printf("%x\t", data[i][j]);
						// System.out.printf("%x\t", rgb[0]);
						// System.out.printf("%x\t", rgb[1]);
						// System.out.printf("%x\t", rgb[2]);
						// System.out.printf("ff%x\t", rgb[0] + rgb[1] + rgb[2]);

						// �����ͼ�������Ա�ͼ�Ĳ�ֵ
						originalresultR[i][j] = rgb[0] - Comparison.perfectdataR[i][j];
						originalresultG[i][j] = rgb[1] - Comparison.perfectdataG[i][j];
						originalresultB[i][j] = rgb[2] - Comparison.perfectdataB[i][j];

						System.out.printf("%x\t", originalresultR[i][j] + originalresultG[i][j] + originalresultB[i][j]);
			        }

				}
			}
			bimg.flush();
			// ��ʽ����ͨ��getPixels()��ʽ������ؾ���
			// �˷�ʽΪ��Width����ɨ��
			//Raster raster = bimg.getData();
			System.out.println("");
			//int[] temp = new int[raster.getWidth() * raster.getHeight() * raster.getNumBands()];
			//int[] pixels = raster.getPixels(0, 0, raster.getWidth(), raster.getHeight(), temp);
			//for (int i = 0; i < pixels.length;) {
				// ���һ�����ݱȶ�
				//if ((i % raster.getWidth() * raster.getNumBands()) == 0)
					//System.out.printf("ff%x%x%x\t", pixels[i], pixels[i + 1], pixels[i + 2]);
				//i += 3;
			//}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}