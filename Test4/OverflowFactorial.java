package Test4;

import java.math.BigInteger;

public class OverflowFactorial {
	
	public static BigInteger factorial(int a) {
		
		//BigInteger를 사용하여 팩토리얼을 계산
		BigInteger result = BigInteger.ONE;
		
		// 반복문을 사용하여 오버플로우를 최대한 방지
		for (int i = 1; i <= a; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		// 1000000값을 입력하였으나 값이 너무커 출력이 안되는 상황이지만 최대한 하였습니다.
		int num = 100;
		try {
			BigInteger result = factorial(num);
			System.out.println(num + "의 팩토리얼 값은 : " + result + " 입니다");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
