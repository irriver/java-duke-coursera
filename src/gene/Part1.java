package gene;
import java.io.File;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class Part1 {
	
	String		findSimpleGene(String dna) {
		String	gene = "";
		int		startIndex = dna.indexOf("ATG");
		if (startIndex == -1) {
			return	"";
		}
		int		stopIndex = dna.indexOf("TAA", startIndex + 3); //find after start codon
		if (stopIndex == -1) {
			return	"";
		}
		gene = dna.substring(startIndex, stopIndex + 3);
		if (gene.length() % 3 == 0) {
			return	gene;
		}
		return "no valid dna strands";
	}
	
	public static void main(String[] args) {
		findSimpleGene();
	}
	
}
