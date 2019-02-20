package stackAndQueue;

public class TestPolish {
	public static void main(String[] args) {
		Polish p = new Polish();
		int res = p.eval(" * 3 + 4 5");
		System.out.println(res == 27);
		assert res == 27;
		System.out.println(-4 == p.eval(" * + 1 3 - 2 3"));
		System.out.println(p.eval(" + * + 1 2 3 4"));
		System.out.println(p.eval(" 1 * 2 + 3 4"));
		System.out.println(p.eval(" * + 1 2 + 3 4"));
		System.out.println(17 == p.eval(" - * - 9 2 3 4"));
		System.out.println(4 == p.eval(" / * + 5 3 4 7"));
	}
}
