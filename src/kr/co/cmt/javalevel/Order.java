package kr.co.cmt.javalevel;

public class Order {
    public int orNum;
    public Customer cusNum;
    public Product proNum;
    
    public Order() {}

    public Order(int orNum, Customer cusNum, Product proNum) {
        this.orNum = orNum;
        this.cusNum = cusNum;
        this.proNum = proNum;
    }

    public int getOrNum() {
        return orNum;
    }

    public void setOrNum(int orNum) {
        this.orNum = orNum;
    }

    public Customer getCusNum() {
        return cusNum;
    }

    public void setCusNum(Customer cusNum) {
        this.cusNum = cusNum;
    }

    public Product getProNum() {
        return proNum;
    }

    public void setProNum(Product proNum) {
        this.proNum = proNum;
    }

	@Override
	public String toString() {
		return "Order [orNum=" + orNum + ", cusNum=" + cusNum.toString() + ", proNum=" + proNum.toString() + "]";
	}
}
