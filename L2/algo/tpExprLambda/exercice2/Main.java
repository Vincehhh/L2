package tpExprLambda.exercice2;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		int t[][] = {{1, 2}, {1, 4}, {3, 2}};

		Stream<int[]> scoord =
			Arrays.stream(t); // Arrays.stream(t) transforme un tableau[] en stream...
							  //  monArrayList.stream() transforme un ArrayList (valable pour les
							  //  collections) en stream
		Stream<Coord> scoord2;
		scoord2 = scoord.map(elem -> new Coord(elem[0], elem[1]));
		scoord2.forEach(System.out::println);

		// ou, plus concis!
		Arrays.stream(t).map(elem -> new Coord(elem[0], elem[1])).forEach(System.out::println);
		// ou:
		Arrays.stream(t)
			.map(elem -> new Coord(elem[0], elem[1]))
			.forEach(elem -> System.out.println(elem));
	}
}
