package pogo;

public class Species {

	private String scientificname;
	private String commonname;
	private int taxonomyId;
	
	public Species(String sciname, String comname, int taxid) {
		this.scientificname = sciname;
		this.commonname = comname;
		this.taxonomyId = taxid;
	}
	
	public String getScientificName() {
		return scientificname;
	}
	
	public String getCommonName() {
		return commonname;
	}
	
	public String toString() {
		return commonname + " (" + scientificname + ", " + taxonomyId + ")";
	}
	
}
