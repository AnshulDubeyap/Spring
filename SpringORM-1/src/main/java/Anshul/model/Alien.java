package Anshul.model;



@javax.persistence.Entity
public class Alien {

	@javax.persistence.Id
	private int aid;
	private String aname;
	
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	
	
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + "]";
	}
	
	
	
	
}
