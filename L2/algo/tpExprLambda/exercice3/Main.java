package tpExprLambda.exercice3;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int t[][] = {{1, 2}, {1, 4}, {3, 2}, {1, 2}};
		Arrays.stream(t)
			.map(elem -> new Coord(elem[0], elem[1]))
			.distinct()
			.forEach(System.out::println);
	}
}
