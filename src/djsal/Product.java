package djsal;

public class Product{
	 private String id;
	 private String name;
	 private String price;
	 private String message;
	public Product() {
		super();
	}
	public Product(String id, String name, String price, String message) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.message = message;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String toString(){
		return id+" "+" "+name+" "+" "+price+" "+" "+message;
	}
}