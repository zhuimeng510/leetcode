package easy;
/*
 * ��Ŀ����

There are N gas stations along a circular route, where the amount of gas at station i isgas[i].
You have a car with an unlimited gas tank and it costscost[i]of gas to travel from station i to 
its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
Note: 
The solution is guaranteed to be unique.
 */
public class ����վ {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int len = gas.length;		
        for (int i = 0; i < len; i++) {
        	if (gas[i]<cost[i]) {//���Ͳ����ϣ���֦
				continue;
			}
        	int cur = (i+1)%len;//�ӵڶ�����ʼ
        	int sum = gas[i]-cost[i];
			while (cur%len!=i) {
				sum = sum+gas[cur]-cost[cur];
				if (sum<0) {//��֦
					break;
				}
				cur = (cur+1)%len;
				
			}
			if (cur%len==i) {//������һȦ������
				return i;
			}
			
		}
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int gas[] = {10,0,14,0,0};
		int cost[] = {5,6,7,2,4};
		System.out.println(new ����վ().canCompleteCircuit(gas, cost));
	}

}
