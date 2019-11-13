package kr.co.javalevel;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Total {
    public static void main(String[] args) {
        List<String> cusList = loadFile("C:\\JavaLevelCheck\\customer.csv");
        List<String> proList = loadFile("C:\\JavaLevelCheck\\product.csv");
        List<String> orList = loadFile("C:\\JavaLevelCheck\\order.csv");
        
        String[] cusArray = cusList.toArray(new String[cusList.size()]);
        Customer customer = new Customer(Integer.parseInt(cusArray[0]), cusArray[1]);
        System.out.println(customer.toString());
        
        String[] proArray = proList.toArray(new String[proList.size()]);
        Product product = new Product(Integer.parseInt(proArray[0]), proArray[1]);
        System.out.println(product.toString());

        String[] orArray = orList.toArray(new String[orList.size()]);
        Order order = new Order(Integer.parseInt(orArray[0]), customer, product);
        System.out.println(order.toString());
    }

    private static List<String> loadFile(String path) {
        List<String> list = new ArrayList<>();
        BufferedReader br = null;
        String line;
    
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            while ((line = br.readLine()) != null) {
                if(line.indexOf("�ĺ���ȣ") < 0) {
                    String[] field = line.split(",");
                    
                    for(int i=0; i<field.length; i++) {
                        list.add(field[i]);
                    }
                }
            }
        } catch (FileNotFoundException e) { // ������ ��θ��� Ʋ�� ���
            e.printStackTrace();
        } catch (IOException e) { // ���� �д� ���� ����� ������ �߻��� ���
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
        return list;
    }
}
