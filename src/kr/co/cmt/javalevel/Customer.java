package kr.co.cmt.javalevel;

public class Customer {
    public int cusNum;
    public String cusName;

    public Customer() {}

    public Customer(int cusNum, String cusName) {
        this.cusNum = cusNum;
        this.cusName = cusName;
    }

    public int getCusNum() {
        return cusNum;
    }

    public void setCusNum(int cusNum) {
        this.cusNum = cusNum;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    @Override
    public String toString() {
        return "Customer [cusNum=" + cusNum + ", cusName=" + cusName + "]";
    }
}
