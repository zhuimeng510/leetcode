package hard;

import java.util.HashMap;
import java.util.Map;

/*
 * 题目描述
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class MaxPointsOnALine {
	public static int maxPoints(Point[] points) {
        if (points==null) {
			return 0;
		}
        int totalNum = points.length;//总节点数
        if (totalNum<=2) {
			return totalNum;
		}
        int maxPoints = 2;
        for (int i = 0; i < points.length; i++) {//以i为起始点
			Map<Double, Integer> map = new HashMap<Double, Integer>();
			int verNum = 1;//与点i在一条垂直线上
			int samePointNum = 0;//与i重合点
			int maxNum = 1;//本轮中最大点数
			for (int j = 0; j < points.length; j++) {
				if (j!=i) {//不是本身
					double deltaY = points[i].y-points[j].y;//y轴差值
					double deltaX = points[i].x-points[j].x;//x轴差值
					if (deltaY==0 && deltaX==0) {//与i重合点
						samePointNum++;
					}else if (deltaX==0) {//与i在同一条垂线上
						verNum++;
					}else {//正常情况
						double rate = deltaY/deltaX;//斜率
						if (map.containsKey(rate)) {//map中已存相关斜率
							int newNum = map.get(rate)+1;//当前斜率数目
							map.put(rate, newNum);//相应斜率增加一个节点
							if (newNum>maxNum) {//多于原来直线中的点数
								maxNum = newNum;
							}
						}else {
							map.put(rate, 2);//添加相应斜率
						}
					}
					
				}
			}
			maxNum = maxNum > verNum ? maxNum+samePointNum:verNum+samePointNum;//将与i在同一条垂线上的考虑进去，还有重合点
			if (maxNum>maxPoints) {
				maxPoints = maxNum;
			}
		}
        return maxPoints;
    }
	public static void main(String[] args) {
		Point[] points = {new Point(1,1),new Point(1,1),new Point(1,1)};
		System.out.println(maxPoints(points));
	}
}
