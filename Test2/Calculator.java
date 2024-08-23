package Test2;

public class Calculator {
	//필드 선언
    private int result;  

    //초기값 0
    public Calculator() {
        this.result = 0;
    }
    
    // 현재값에 더하고 객체 반환
    public Calculator add(int value) {
    	this.result += value;
    	return this;
    }
    
    // 현재값에 빼고 객체 반환
    public Calculator subtract(int value) {
    	this.result -= value;
    	return this;
    }
    
    // 최종 계산 결과 반환
    public int out() {
    	return this.result;
    }
    
    public static void main(String[] args) {
    	Calculator calculator = new Calculator();
    	int result = calculator.add(4).add(5).subtract(3).out();
    	
    	System.out.println(result);
    }
   
}