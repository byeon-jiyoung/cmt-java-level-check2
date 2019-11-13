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

public class Total2 {
    public static void main(String[] args) {
        String dir = System.getProperty("user.dir") + File.separator;
        String[] path = {dir + "customer.csv", dir + "product.csv", dir + "order.csv"};
        
        Map<Object, Object> map = loadFile(path);
        
        System.out.println(map);
        System.out.println(map.get("order1"));
        
    }

    private static Map<Object, Object> loadFile(String[] path) {
        Map<Object, Object> map = new HashMap<Object, Object>();
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

                        if(path[z].indexOf("customer") >= 0) {
                            Customer customer = new Customer();
                            for(int i=0; i<field.length; i++) {
                                if(i%2==0) {
                                    customer.setCustomerNumber(Integer.parseInt(field[i]));
                                }else if(i%2==1) {
                                    customer.setCustomerName(field[i]);
                                    customerList.add(customer);
                                }
                            }
                        } else if(path[z].indexOf("product") >= 0) {
                            Product product = new Product();
                            for(int i=0; i<field.length; i++) {
                                if(i%2==0) {
                                    product.setProductNumber(Integer.parseInt(field[i]));
                                }else if(i%2==1) {
                                    product.setProductName(field[i]);
                                    productList.add(product);
                                }
                            }
                        } else if(path[z].indexOf("order") >= 0) {
                            Order order = new Order();
                            for(int i=0; i<field.length; i++) {
                                if(i%3==0) {
                                    order.setOrderNumber(Integer.parseInt(field[i]));
                                }else if(i%3==1) {
                                    order.setCustomerNumber(Integer.parseInt(field[i]));
                                }else if(i%3==2) {
                                    order.setProductNumber(Integer.parseInt(field[i]));
                                    orderList.add(order);
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
        
        for(Customer customer : customerList) {
            map.put("customer"+customer.getCustomerNumber(), customer);
        }
        for(Product product : productList) {
            map.put("product"+product.getProductNumber(), product);
        }
        for(Order order : orderList) {
            map.put("order"+order.getOrderNumber(), order);
        }
        //map에 order정보만 담아서 customer랑 product가 다 나오게해보도록
        
//        for(Customer customer : customerList) {
//            list.add(customer);
//        }
//        for(Product product : productList) {
//            list.add(product);
//        }
//        for(Order order : orderList) {
//            list.add(order);
//        }
//        System.out.println(list);
        return map;
    }
}
