/** 
 * 
 * Question - Binary to String
 * Created by Yu Zheng on 10/1/2015 
 *
 * idea: just mutiple 2 each time, if its more than 1, append 1 to string
 * else, append 0 to the string
 * 
 */

public class Solution02 {

	public static void binary2String(double num) {
		if (num >= 1 || num <= 0) {
			System.out.println("ERROR");
			return;
		}

		StringBuffer result = new StringBuffer();
		result.append("0.");

		while(num > 0) {
			if(result.length() > 33) {
				System.out.println("ERROR");
				return;
			}

			double temp = num * 2;
			if(temp >= 1) {
				result.append("1");
				num = temp - 1;
			}
			else {
				result.append("0");
				num = temp;
			}

		}

		System.out.println(result.toString());

	}

	public static void main(String[] args) {

		double num = 0.125;
		binary2String(num);
		

	}

}