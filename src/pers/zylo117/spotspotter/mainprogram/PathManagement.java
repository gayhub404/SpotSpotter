package pers.zylo117.spotspotter.mainprogram;

public class PathManagement {

	// ����ͼƬ·��
	public static String inputdir = "D:/SpotSpotterWorkLog/input/";
	public static String rawoutputdir = "D:/SpotSpotterWorkLog/rawoutput/";
	public static String bipicdir = "D:/SpotSpotterWorkLog/bipic/";
	public static String finaloutputdir = "D:/SpotSpotterWorkLog/finaloutput/";
	public static String perfect = "D:/SpotSpotterWorkLog/perfect/perfect.jpg";
	public static String IRCF = "D:/SpotSpotterWorkLog/IRCF/";
	public static String ROI = "D:/SpotSpotterWorkLog/ROI/";
//	static File fromPic = new File(inputdir); // ԭͼ
//	static File toIRCF = new File(IRCF); // �����IRCFͼƬ
//	static File toROI = new File(ROI); // �����ROIͼƬ
	
//	// ����/��ת zoom/rotate
//	int x = 0;
//	int y = 0;
//	static double scale = 0;
//	static double angle = 0;
//
//	public static void zoom(int x, int y, double scale, double angle) throws IOException {
//		// size(x,y)Ϊ����������
//		// ע�⣬thumbnailĬ�ϱ��ֺ��ݱ�������xĿ��ֵΪ�ο�
//
//		while (true) {
//			if (scale == 0) {
//				// Thumbnails.of(fromPic).size(100, 100).keepAspectRatio(false);
//				// ����Thumbnails.of(fromPic).forceSize(100,100);
//				Thumbnails.of(fromPic.listFiles()).forceSize(x, y).rotate(angle).toFiles(toIRCF,
//						Rename.PREFIX_DOT_THUMBNAIL);
//				break;
//			}
//			if (scale == 1) {
//				Thumbnails.of(fromPic.listFiles()).size(x, y).rotate(angle).toFiles(toIRCF,
//						Rename.PREFIX_DOT_THUMBNAIL);
//				break;
//			}
//			if (scale != 0 && scale != 1 && scale > 0) {
//				// ���ձ���������С�ͷŴ�
//				// Thumbnails.of(fromPic).scale(0.2f);//��������С��0.2��
//				// Thumbnails.of(fromPic).scale(2f);//�������Ŵ�2��
//				Thumbnails.of(fromPic.listFiles()).scale(scale).rotate(angle).toFiles(toIRCF,
//						Rename.PREFIX_DOT_THUMBNAIL);
//				break;
//			} else {
//				System.out.println("Input Error");
//			}
//		}
//	}
//
//	// �ü�Crop,����Ҫ�������
//	public static void crop(String fromfile , String IRCFfile, String ROIfile) throws IOException {
//		Thumbnails.of(fromfile).sourceRegion(302, 252, 734, 502).size(734, 502).toFile(IRCFfile);
//		// ����ROI��ԭ��,�ߴ�
//		Thumbnails.of(IRCFfile).sourceRegion(82, 86, 570, 340).size(570, 340).toFile(ROIfile);
//	}
//	
//	// Old School Style
//	public static void crop2(String infile, String outfile, String format, int x, int y, int w, int h) throws IOException  {
//		System.out.println(infile);	
//		FileInputStream fis = new FileInputStream(infile);
//		FileOutputStream fos = new FileOutputStream(outfile);
//		BufferedImage originpic = ImageIO.read(fis);
//		BufferedImage ROIpic = originpic.getSubimage(x, y, w, h);
//		ImageIO.write(ROIpic, format, fos); 
//		originpic = null;
//		ROIpic = null;
//		fos.close();
//		fis.close();
//	}
//	
}
