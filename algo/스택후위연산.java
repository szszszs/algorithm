import java.util.Stack;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "6528-*2/+";
		Stack<Integer> stack = new Stack<Integer>();
		System.out.println(s);
		int size = s.length();		
		for (int i = 0; i < size; i++) {
			char temp = s.charAt(i);
			
			if (Character.isDigit(temp)) {//피연산자 - isDigit: 숫자인지 판별해주는 메소드
				stack.push(temp - '0');
			} else {//연산자
				int val2 = stack.pop();
				int val1 = stack.pop();
				
				switch (temp) {
				case '+':
					stack.push(val1 + val2);
					break;
				case '*':
					stack.push(val1 * val2);
					break;
				case '-':
					stack.push(val1 - val2);
					break;
				case '/':
					stack.push(val1 / val2);
					break;

				}
			}
		} // end of for
		System.out.println(stack.pop());
	}

}
