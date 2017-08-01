package pers.zylo117.spotspotter.pictureprocess;

public class TargetClassifier {
	public static String getClass(String input) {
		String classname;
		switch (GetPicType.getPicType(input)) {
		case "glue":
			classname = "AA";
			break;
		case "chip":
			classname = "GA";
			break;
		case "glass":
			classname = "GA";
			break;
		default:
			classname = "Unknown Pic";
			break;
		}
		return classname;
	}
}
