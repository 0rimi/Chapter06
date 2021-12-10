package minipro;

public class Phone {
	
	private String name;
	private String hp;
	private String company;
	
	public Phone() {}
	public Phone(String name, String hp, String company) {
		super();
		this.name = name;
		this.hp = hp;
		this.company = company;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	

	@Override
	public String toString() {
		return "Phone [name=" + name + ", hp=" + hp + ", company=" + company + "]";
	}
	public void print() {
		System.out.println(name+"\t"+hp+"\t"+company);
	}
	public String info() {
		return name+","+hp+","+company;
	}
	
	

}
