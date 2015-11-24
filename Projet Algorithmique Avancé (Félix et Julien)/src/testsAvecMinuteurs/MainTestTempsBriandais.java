package testsAvecMinuteurs;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

public class MainTestTempsBriandais {
	
	public static void main(String[] args) {
		
//		String[] mots = {"year", "bianca", "rjkbrr", "e", "pomfret", "what", "this", "read", "a", "see"};
//		String[] motsAInserer = {"journee", "tante", "f", "lit", "tomate", "maman", "decoupe", "smartphone", "aiguille", "riz"};

		System.out.println("==== Test sur Arbre de la Briandais ===");
		TestsTempsSuperclass testBriandais = new TestsTempsBriandais();
		
		for(int i=0; i<TestsTempsSuperclass.NB_TESTS; i++){
			testBriandais.addTpsConstruction(testBriandais.tempsConstruction());
			testBriandais.addTpsInsertion(testBriandais.tempsInsertion("year"));
			testBriandais.addTpsRecherche(testBriandais.tempsRecherche("year"));
			testBriandais.addTpsSuppression(testBriandais.tempsSuppression("year"));
			testBriandais.addTpsComptageMots(testBriandais.tempsComptageMots());
			testBriandais.resetArbre();
		}
		
		System.out.println("-> Temps de constructions : ");
		printTenLastTimesAndAverage(testBriandais.getTpsConstruction());
		System.out.println("-> Temps d'insertion : ");
		printTenLastTimesAndAverage(testBriandais.getTpsInsertion());
		System.out.println("-> Temps de recherche : ");
		printTenLastTimesAndAverage(testBriandais.getTpsRecherche());
		System.out.println("-> Temps de suppressions : ");
		printTenLastTimesAndAverage(testBriandais.getTpsSuppression());
		System.out.println("-> Temps de comptage de mots : ");
		printTenLastTimesAndAverage(testBriandais.getTpsComptageMots());
	}
	
	/**Affiche les 10 derniers temps de la liste passée en paramètres
	 * (les premiers temps étant anormalement plus grands)
	 * 
	 * @param list
	 */
	private static void printTenLastTimesAndAverage(List<BigDecimal> list){
//		list = list.subList(4, TestsTempsSuperclass.NB_TESTS-1);
		
		BigDecimal tot = new BigDecimal(0);
		for(BigDecimal res : list){
			System.out.println(res+" ms");
			tot = tot.add(res);
		}
		
		System.out.println("Moyenne de : "+tot.divide(new BigDecimal(list.size()), MathContext.DECIMAL32)+" ms\n");
	}

}
