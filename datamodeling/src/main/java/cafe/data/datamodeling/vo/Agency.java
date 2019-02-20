package cafe.data.datamodeling.vo;

public class Agency {
	private String agencyCode;
	private String agencyName;
	private String agencyUser;
	
	public String getAgencyCode() {
		return agencyCode;
	}
	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getAgencyUser() {
		return agencyUser;
	}
	public void setAgencyUser(String agencyUser) {
		this.agencyUser = agencyUser;
	}
	@Override
	public String toString() {
		return "Agency [agencyCode=" + agencyCode + ", agencyName=" + agencyName + ", agencyUser=" + agencyUser + "]";
	}
	
	
}
