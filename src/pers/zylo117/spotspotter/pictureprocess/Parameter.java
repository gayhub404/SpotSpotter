package pers.zylo117.spotspotter.pictureprocess;

public class Parameter {

	public static int ROIstart_x;
	public static int ROIstart_y;
	public static int ROIWidth;
	public static int ROIHeight;

	public static void getParameter(String input) {

		switch (TargetClassifier.getClass(input)) {

		case "GA":
			// GA Spotʶ�����
			ROIstart_x = 394;
			ROIstart_y = 338;
			ROIWidth = 560;
			ROIHeight = 320;
			break;

		case "AA":
			// AA Glueʶ�����
			// ����ROI��ʼx/y,ROI���񳤿�
			ROIstart_x = 186;
			ROIstart_y = 366;
			ROIWidth = 149;
			ROIHeight = 184;
			break;

		}

	}

}
