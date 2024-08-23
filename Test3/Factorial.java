package Test3;

public class Factorial {
	
	public static int factorial(int a) {
		
		if(a == 0) {
			// 0! 은 1이여서 리턴값을 1로둠
			return 1; 
		}
		else {
			//재귀함수
			return a * factorial(a-1);
		}
	}
	
	public static void main(String[] args) {
		// 문제에 나와있는대로 4를 대입
		int result = factorial(4);
		System.out.println(result);
	}

}
