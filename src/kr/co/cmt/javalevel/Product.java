package kr.co.cmt.javalevel;

public class Product {
    public int proNum;
    public String proName;

    public Product() {}

    public Product(int proNum, String proName) {
        this.proNum = proNum;
        this.proName = proName;
    }

    public int getProNum() {
        return proNum;
    }

    public void setProNum(int proNum) {
        this.proNum = proNum;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

	@Override
	public String toString() {
		return "Product [proNum=" + proNum + ", proName=" + proName + "]";
	}
}
