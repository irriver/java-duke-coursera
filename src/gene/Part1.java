package gene;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part1 {

	static String findSimpleGene(String dna) {
		String gene = "";
		int startIndex = dna.indexOf("ATG");
		if (startIndex == -1) {
			return "";
		}
		int stopIndex = dna.indexOf("TAA", startIndex + 3); // find after start codon
		if (stopIndex == -1) {
			return "";
		}
		gene = dna.substring(startIndex, stopIndex + 3);
		if (gene.length() % 3 == 0) {
			return gene;
		}
		return "no valid dna strands";
	}

	public static void main(String[] args) {
		// File f = new File("C:\\Dev\\workSpace\\BlueJ\\dna\\mansmall.fa");
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("C:\\Dev\\workSpace\\BlueJ\\dna\\mansmall.fa"));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				// read next line
				line = reader.readLine();
				findSimpleGene(line);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}