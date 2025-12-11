package tp5CollectionsGenericite.partie1Collections.exercice1bManipulationListDeSetEtDeTreeSet;

import java.util.TreeSet;

import tp5CollectionsGenericite.partie1Collections.exercice1aManipulationListDeSetEtDeTreeSet.BankAccount;

public class ObjetsOrdonnes {
	public static void main(String[] args) {
		TreeSet<Integer> setInteger = new TreeSet<>();
		for (int i = 0; i < 5; i++) {
			setInteger.add((int) (10 * Math.random()));
		}
		System.out.println("TreeSet<Integer> : " + setInteger);

		TreeSet<String> setString = new TreeSet<>();
		setString.add("un");
		setString.add("deux");
		setString.add("trois");
		setString.add("quatre");
		setString.add("cinq");

		System.out.println("TreeSet<String> : " + setString);

		TreeSet<BankAccount> setBankAccount = new TreeSet<>();
		setBankAccount.add(new BankAccount(500));
		setBankAccount.add(new BankAccount(300));
		setBankAccount.add(new BankAccount(800));
		setBankAccount.add(new BankAccount(100));
		setBankAccount.add(new BankAccount(1000));

		System.out.println("TreeSet<BankAccount> : " + setBankAccount);
	}
}
