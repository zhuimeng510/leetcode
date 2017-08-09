package hard;

import java.util.HashMap;
import java.util.Map;

/*
 * ��Ŀ����
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class MaxPointsOnALine {
	public static int maxPoints(Point[] points) {
        if (points==null) {
			return 0;
		}
        int totalNum = points.length;//�ܽڵ���
        if (totalNum<=2) {
			return totalNum;
		}
        int maxPoints = 2;
        for (int i = 0; i < points.length; i++) {//��iΪ��ʼ��
			Map<Double, Integer> map = new HashMap<Double, Integer>();
			int verNum = 1;//���i��һ����ֱ����
			int samePointNum = 0;//��i�غϵ�
			int maxNum = 1;//������������
			for (int j = 0; j < points.length; j++) {
				if (j!=i) {//���Ǳ���
					double deltaY = points[i].y-points[j].y;//y���ֵ
					double deltaX = points[i].x-points[j].x;//x���ֵ
					if (deltaY==0 && deltaX==0) {//��i�غϵ�
						samePointNum++;
					}else if (deltaX==0) {//��i��ͬһ��������
						verNum++;
					}else {//�������
						double rate = deltaY/deltaX;//б��
						if (map.containsKey(rate)) {//map���Ѵ����б��
							int newNum = map.get(rate)+1;//��ǰб����Ŀ
							map.put(rate, newNum);//��Ӧб������һ���ڵ�
							if (newNum>maxNum) {//����ԭ��ֱ���еĵ���
								maxNum = newNum;
							}
						}else {
							map.put(rate, 2);//�����Ӧб��
						}
					}
					
				}
			}
			maxNum = maxNum > verNum ? maxNum+samePointNum:verNum+samePointNum;//����i��ͬһ�������ϵĿ��ǽ�ȥ�������غϵ�
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
