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
            ExecutorService exec = Executors.newFixedThreadPool(20);
            out = new FileOutputStream("starbuck1.csv");
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
                out.close();
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
        ExecutorService exec = new ThreadPoolExecutor(5, 5,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        try {
            String location = longitude + "," + latitude;
            ArrayList<Future<String>> futures = new ArrayList<Future<String>>();
            futures.add(exec.submit(new TaskWithResult(location,"美食")));
            futures.add(exec.submit(new TaskWithResult(location,"购物中心")));
            futures.add(exec.submit(new TaskWithResult(location,"办公楼")));
            futures.add(exec.submit(new TaskWithResult(location,"教育培训类")));
            futures.add(exec.submit(new TaskWithResult(location,"住宅类")));
            String count1 = futures.get(0).get();
            String count2 = futures.get(1).get();
            String count3 = futures.get(2).get();
            String count4 = futures.get(3).get();
            String count5 = futures.get(4).get();

            StringBuilder line = new StringBuilder();
            line.append(storeName);
            line.append(",");
            line.append(address);
            line.append(",");
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
    private String keywords;


    public TaskWithResult(String location, String keywords){
        this.location = location;
        this.keywords = keywords;
    }

    @Override
    public String call() throws Exception {
        return  GaoDPOi.getCount(location, keywords);
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