package pers.zylo117.spotspotter.patternrecognition.regiondetector;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class DetectCorners {

	public static void corners(String inputimg, String outputimg) {
		try {
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

			final int maxCorners = 50, blockSize = 5;
			final double qualityLevel = 0.01, minDistance = 20.0, k = 0.04;
			final boolean useHarrisDetector = true;
			MatOfPoint corners = new MatOfPoint();

			Mat src = Imgcodecs.imread(inputimg);
			if (src.empty()) {
				throw new Exception("no file");
			}
			Mat dst = src.clone();
			Mat gray = new Mat();

			Imgproc.cvtColor(src, gray, Imgproc.COLOR_RGB2GRAY);
			Imgproc.goodFeaturesToTrack(gray, corners, maxCorners, qualityLevel, minDistance, new Mat(), blockSize,
					useHarrisDetector, k);
			Point[] pCorners = corners.toArray();
			for (int i = 0; i < pCorners.length; i++) {
				Imgproc.circle(dst, pCorners[i], 4, new Scalar(255, 255, 0), 2);
			}
			Imgcodecs.imwrite(outputimg, dst);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}