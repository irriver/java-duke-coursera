package gene;

public class Part1 {

	static String findSimpleGene(String dna) {
		int startIndex = dna.indexOf("ATG");
//		System.out.println("startIndex " + startIndex);
		if (startIndex == -1) {
			return "noStart";
		}
		int stopIndex = dna.indexOf("TAA", startIndex + 3); // find after start codon
//		System.out.println("stopIndex " + stopIndex);
		if (stopIndex == -1) {
			return "noStop";
		}
		String gene = dna.substring(startIndex, stopIndex + 3);
//		System.out.println("geneLength " + gene.length());
//		System.out.println(gene);
		if (gene.length() % 3 == 0) {
//			System.out.println(gene);
			return gene;
		}
		return "";
	}

	public static void main(String[] args) {
//		FileResource fr = new FileResource("brca1.fa");
//		String dnaSample = fr.asString();
		System.out.println(findSimpleGene("AAATGCCCTAACTAGATTAAGAAACC"));
	}
}