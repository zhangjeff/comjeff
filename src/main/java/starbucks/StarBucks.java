package starbucks;

import starbucks.gaode.GaoDPOi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class StarBucks {
    public static void main(String[] args) {
        Statement st = null;
        ResultSet rs = null;
        FileOutputStream out = null;
        try {
            ExecutorService exec = Executors.newFixedThreadPool(5);
//            out = new FileOutputStream("starbuck3.csv");
            List<String> starbuckList = new ArrayList<>();
            Connection conn= getConnect();
            st = conn.createStatement();
            rs = st.executeQuery("select * from starbucks.starbucks_store_v5");
            ArrayList<Future<String>> futures = new ArrayList<Future<String>>();

            while (rs.next()) {
                String storeName = rs.getString("store_name");
                String address = rs.getString("address");
                String province = rs.getString("province");
                String city = rs.getString("city");
                String longitude = rs.getString("longitude");
                String latitude = rs.getString("latitude");
//                String lineStr = dealLine(storeName,address,province,city,longitude,latitude);
                futures.add(exec.submit(new LineTaskWithResult(storeName,address,province,city,longitude,latitude)));

            }
            for(Future<String> fs: futures){
                try {
                    starbuckList.add(fs.get());
                } catch (InterruptedException e) {
                    System.out.println(e);
                    e.printStackTrace();
                    return;
                } catch (ExecutionException e) {
                    System.out.println(e);
                    e.printStackTrace();
                }finally {
                    exec.shutdown();
                }
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("starbuck1.csv")));
            String title = "storeName,address,province,city,longitude,latitude," +
                    "外国餐厅,中餐厅,茶艺馆,甜品店,娱乐场所,咖啡厅,冷饮店,快餐厅,住宅区,楼宇,商场,培训机构,学校\r\n";
            bw.write(title);
            String title2 = "storeName,address,province,city,longitude,latitude," +
                    "050200,050100,050600,050900,080304,050500,050700,050300,120300,120200,060100,141400,141205\r\n";
            bw.write(title2);
            for (String bb : starbuckList) {
                bw.write(bb);
            }
            bw.flush();
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnect() {
        Connection conn = null;
        try {
            Class.forName( "org.postgresql.Driver" ).newInstance();
            String url = "jdbc:postgresql://10.206.31.40:5432/sf";
            conn= DriverManager.getConnection(url, "postgres" , "postgres");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static String dealLine(String storeName,
                         String address,
                         String province,
                         String city,
                         String longitude,
                         String latitude){
        ExecutorService exec = new ThreadPoolExecutor(13, 13,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        try {
            String location = longitude + "," + latitude;
            ArrayList<Future<String>> futures = new ArrayList<Future<String>>();
            futures.add(exec.submit(new TaskWithResult(location,"050200"))); //外国餐厅
            futures.add(exec.submit(new TaskWithResult(location,"050100"))); //中餐厅
            futures.add(exec.submit(new TaskWithResult(location,"050600"))); //茶艺馆
            futures.add(exec.submit(new TaskWithResult(location,"050900"))); //甜品店
            futures.add(exec.submit(new TaskWithResult(location,"080304")));//娱乐场所
            futures.add(exec.submit(new TaskWithResult(location,"050500")));//咖啡厅
            futures.add(exec.submit(new TaskWithResult(location,"050700")));//冷饮店
            futures.add(exec.submit(new TaskWithResult(location,"050300")));//快餐厅

            futures.add(exec.submit(new TaskWithResult(location,"120300")));//住宅区
            futures.add(exec.submit(new TaskWithResult(location,"120200")));//楼宇
            futures.add(exec.submit(new TaskWithResult(location,"060100")));//商场
            futures.add(exec.submit(new TaskWithResult(location,"141400")));//培训机构
            futures.add(exec.submit(new TaskWithResult(location,"141205")));//学校

            String count1 = futures.get(0).get();
            String count2 = futures.get(1).get();
            String count3 = futures.get(2).get();
            String count4 = futures.get(3).get();
            String count5 = futures.get(4).get();
            String count6 = futures.get(5).get();
            String count7 = futures.get(6).get();
            String count8 = futures.get(7).get();

            String count9 = futures.get(8).get();
            String count10 = futures.get(9).get();
            String count11 = futures.get(10).get();
            String count12 = futures.get(11).get();
            String count13 = futures.get(12).get();
            StringBuilder line = new StringBuilder();
            line.append(storeName);
            line.append(",\"");
            line.append(address);
            line.append("\",");
            line.append(province);
            line.append(",");
            line.append(city);
            line.append(",");
            line.append(longitude);
            line.append(",");
            line.append(latitude);
            line.append(",");
            line.append(count1);
            line.append(",");
            line.append(count2);
            line.append(",");
            line.append(count3);
            line.append(",");
            line.append(count4);
            line.append(",");
            line.append(count5);
            line.append(",");
            line.append(count6);
            line.append(",");
            line.append(count7);
            line.append(",");
            line.append(count8);
            line.append(",");
            line.append(count9);
            line.append(",");
            line.append(count10);
            line.append(",");
            line.append(count11);
            line.append(",");
            line.append(count12);
            line.append(",");
            line.append(count13);
            line.append("\r\n");
            System.out.println(line.toString());
            return line.toString();
//            byte[] b=line.toString().getBytes();
//            for(int i=0;i<b.length;i++) {
//                out.write(b[i]);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            exec.shutdown();
        }
        return null;
    }
}

class TaskWithResult implements Callable<String>{
    private String location;
    private String types;


    public TaskWithResult(String location, String types){
        this.location = location;
        this.types = types;
    }

    @Override
    public String call() throws Exception {
        return  GaoDPOi.getCount(location, types);
    }
}

class LineTaskWithResult implements Callable<String>{
    private String storeName;
    private String address;
    private String province;
    private String city;
    private String longitude;
    private String latitude;

    public LineTaskWithResult(String storeName,
                          String address,
                          String province,
                          String city,
                          String longitude,
                          String latitude){
        this.storeName = storeName;
        this.address = address;
        this.province = province;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;

    }

    @Override
    public String call() throws Exception {
        return  StarBucks.dealLine(storeName,address,province,city,longitude,latitude);
    }
}