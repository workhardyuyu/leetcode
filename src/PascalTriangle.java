import java.util.ArrayList;

public class PascalTriangle {
	public static ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (numRows == 0)
			return result;
		if (numRows == 1) {
			ArrayList<Integer> Row1 = new ArrayList<Integer>();
			Row1.add(1);
			result.add(Row1);
			return result;
		}

		ArrayList<Integer> Row1 = new ArrayList<Integer>();
		Row1.add(1);
		ArrayList<Integer> Row2 = new ArrayList<Integer>();
		Row2.add(1);
		Row2.add(1);
		result.add(Row1);
		result.add(Row2);

		if (numRows == 2)
			return result;

		for (int ithRow = 3; ithRow <= numRows; ithRow++) {
			ArrayList<Integer> iRow = new ArrayList<Integer>();
			ArrayList<Integer> lastRow = result.get(ithRow - 2);// ¥Ì¡À£° «ithRow-2
			iRow.add(1);
			for (int i = 1; i < ithRow - 1; i++) {
				int digit = lastRow.get(i - 1) + lastRow.get(i);
				iRow.add(digit);
			}
			iRow.add(1);
			result.add(iRow);
		}

		return result;

	}

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> result = PascalTriangle.generate(3);
		System.out.println(result.get(0).get(0));
		System.out.println(result.get(2).get(0));
		System.out.println(result.get(2).get(1));
		System.out.println(result.get(2).get(2));
	}
}
