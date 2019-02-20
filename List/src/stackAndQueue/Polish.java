package stackAndQueue;

public class Polish {
	private Stack s;
	private int res;

	public Polish() {
		s = new Stack();
		res = 0;
	}

	public int eval(String str){
		res = 0;
		fillStack(str);
		return (Integer)s.pop();
	}

	private void fillStack(String str) {
		String tmp = "";
		for (int i = str.length()-1; i >= 0; i--) {
			if (str.charAt(i) == ' ') {
				System.out.println(tmp);
				addToStacks(tmp);
				tmp = "";
			}
			else {
				tmp = tmp + Character.toString(str.charAt(i));
			}
		}
	}



	private void addToStacks(String tmp) {
		if (tmp.charAt(0) == '+' || tmp.charAt(0) == '-' || tmp.charAt(0) == '*' || tmp.charAt(0) == '/') {
			if (res == 0){
				char op = tmp.charAt(0);
				Integer first = (Integer) s.pop();
				Integer second = (Integer) s.pop();
				if (op == '+') {
					s.push((first + second));
				}
				else if (op == '-') {
					s.push((first - second));
				}
				else if (op == '*') {
					s.push((first * second));
				}
				else if (op == '/') {
					s.push((first / second));
				}
			}
		}
		else {
			s.push(Integer.parseInt(tmp));
		}
	}
	
//	public int eval(String str) {
//	String tmp = "";
//	for (int i = 0; i < str.length(); i++) {
//		if (str.charAt(i) == ' ') {
//			System.out.println(tmp);
//			addToStacks(tmp);
//			tmp = "";
//		}
//		else {
//			tmp = tmp + Character.toString(str.charAt(i));
//		}
//	}
//	calculate();
//	return res;
//}
	
//	private void calculate() {
//		while (!(s.isEmpty())) {
//			Integer first = (Integer) s.pop();
//			Integer second = (Integer) s.pop();
//			Character op = (Character) s.pop();
//			if (op == '+') {
//				res = res + (first + second);
//			}
//			else if (op == '-') {
//				res = res + (first - second);
//			}
//			else if (op == '*') {
//				res = res + (first * second);
//			}
//			else if (op == '/') {
//				res = res + (first / second);
//			}
//		}
//	}
}
