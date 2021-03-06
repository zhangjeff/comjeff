package starbucks.gaode;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GaoDPOi {

    public static void main(String[] args) throws Exception {
//        generateData("121.4911219,31.26247455", "美食");
//        generateData("121.471031,31.231657", "购物中心");
//        generateData("121.4911219,31.26247455", "办公楼");
//        generateData("121.471031,31.231657", "教育培训类");
//        generateData("121.471031,31.231657", "住宅类");
        //31.237121,121.500322
        String count = getCount("113.73947,23.000161", "050300");
        System.out.println(count);
    }

//    public static void  generateData(String location, String keywords) throws Exception{
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        String radius = "500";
//        String url = "https://restapi.amap.com/v3/place/around?key=6809f51ea24cd02694e4639bb85260ea&location="
//                +location+"&keywords="+
//                keywords+"&radius=" + radius +"&offset=1&page=1";
//        HttpGet get = new HttpGet(url);
//        CloseableHttpResponse response = httpClient.execute(get);
//        int statusCode = response.getStatusLine().getStatusCode();
////        System.out.println(statusCode);
//        HttpEntity entity = response.getEntity();
//        String objString = EntityUtils.toString(entity, "utf-8");
//        ShopInfo shopInfo = JSON.parseObject(objString, ShopInfo.class);
////        System.out.println(objString);
////        关闭httpclient
////        System.out.println(shopInfo);
//        String line = "坐标(" + location +"),关键字:" + keywords +"， 数量---" + shopInfo.getCount();
//        System.out.println(line);
//        for (Poi poi : shopInfo.getPois()) {
//            String linel = "坐标("+ location +"),数量："+shopInfo.getCount() + ",名称:" + poi.getName() + ",地址：" + poi.getAddress()
//                    +",城市："+poi.getCityname();
//            System.out.println(linel);
//        }
//
//        response.close();
//        httpClient.close();
//    }

    public static String  getCount(String location, String types) throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String radius = "500";
        String url = "https://restapi.amap.com/v3/place/around?key=6809f51ea24cd02694e4639bb85260ea&location="
                +location+ "&types=" + types +"&radius=" + radius +"&offset=100&page=1";
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(get);
        int statusCode = response.getStatusLine().getStatusCode();
//        System.out.println(statusCode);
        HttpEntity entity = response.getEntity();
        String objString = EntityUtils.toString(entity, "utf-8");
        ShopInfo shopInfo = JSON.parseObject(objString, ShopInfo.class);
//        System.out.println(objString);
//        关闭httpclient
//        System.out.println(shopInfo);
//        String line = "坐标(" + location +"),关键字:" + keywords +"， 数量---" + shopInfo.getCount();
//        System.out.println(line);

        for (Poi poi : shopInfo.getPois()) {
            String linel = "坐标("+ location +"),数量："+shopInfo.getCount() + ",名称:" + poi.getName() + ",地址：" + poi.getAddress()
                    +",城市："+poi.getCityname();
            System.out.println(linel);
        }

        response.close();
        httpClient.close();
        return shopInfo.getCount();
    }



}
