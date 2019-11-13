package kr.co.javalevel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Total3 {
    public static void main(String[] args) {
        String dir = System.getProperty("user.dir") + File.separator + "csv" + File.separator;
        String[] path = {dir + "customer.csv", dir + "product.csv", dir + "order.csv"};
        
        Map<Object, Object> map = loadFile(path);
        
        System.out.println(map);
        
        for(int i=1; i<=map.size(); i++) {
        	System.out.println(map.get(i));
        }
        
    }

    private static Map<Object, Object> loadFile(String[] path) {
        Map<Object, Object> csvMap = new HashMap<Object, Object>();
        List<Customer> customerList = new ArrayList<Customer>();
        List<Product> productList = new ArrayList<Product>();
        List<Order> orderList = new ArrayList<Order>();
        
        BufferedReader br = null;
        String line;
        
        try {
            for(int z=0; z<path.length; z++) {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(path[z])));
                while ((line = br.readLine()) != null) {
                    if(line.indexOf("식별번호") < 0) {
                        String[] field = line.split(",");
                        Order order = new Order();
                        for(int i=0; i<field.length; i++) {
                            if(i%3==0) {
                                order.setOrderNumber(Integer.parseInt(field[i]));
                            }else if(i%3==1) {
                            	Customer customer = new Customer();
                                for(int j=0; j<field.length; j++) {
                                    if(j%2==0) {
                                        customer.setCustomerNumber(Integer.parseInt(field[j]));
                                    }else if(j%2==1) {
                                        customer.setCustomerName(field[j]);
                                        customerList.add(customer);
                                        System.out.println(customer + "------------");
                                        order.setCustomerNumber(customer);
                                    }
                                }
                            }else if(i%3==2) {
                            	Product product = new Product();
                                for(int j=0; j<field.length; j++) {
                                    if(j%2==0) {
                                        product.setProductNumber(Integer.parseInt(field[j]));
                                    }else if(j%2==1) {
                                        product.setProductName(field[j]);
                                        productList.add(product);
                                        order.setProductNumber(product);
                                        orderList.add(order);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        for(Order order : orderList) {
            csvMap.put(order.getOrderNumber(), order);
        }
        
        return csvMap;
    }
}
