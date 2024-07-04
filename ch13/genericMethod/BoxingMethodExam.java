package ch13.genericMethod;

public class BoxingMethodExam {

	public static void main(String[] args) {
		// 제네릭 메서드를 사용하여 강한 타입 체크

		Box<Integer> boxI = Util./* <Integer> */boxing(100);

		int intValue = boxI.get();
		System.out.println(intValue);
		System.out.println(boxI.get());

		Box<String> boxS = Util.<String>boxing("쑤시고쑤시고쑤시고쑤신내무릎");

		String strValue = boxS.get();
		System.out.println(strValue);
		System.out.println(boxS.get());
	}
}
