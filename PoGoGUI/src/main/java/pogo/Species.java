package pogo;

public class Species {

	private String scientificname;
	private String commonname;
	
	public Species(String sciname, String comname) {
		this.scientificname = sciname;
		this.commonname = comname;
	}
	
	public String getScientificName() {
		return scientificname;
	}
	
	public String getCommonName() {
		return commonname;
	}
	
	public String toString() {
		return commonname + " (" + scientificname + ")";
	}
	
}
