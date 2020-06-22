package thread;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadCurrent {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("aaa", "11111");
        map.put("bbb","22222");

        for (String key : map.keySet()) {
            System.out.println("key = " + key + " : value = " + map.get(key));
        }

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("aaa", "11111");
        map2.put("bbb","22222");
        map2.put("bbb","333333");

        for (String key : map2.keySet()) {
            System.out.println("key = " + key + " : value = " + map2.get(key));
        }

//        Hashtable<String, String> map3 = new Hashtable<>();
//        map3.put("aaa", "11111");
//        map3.put("bbb","22222");
//
//        for (String key : map3.keySet()) {
//            System.out.println("key = " + key + " : value = " + map3.get(key));
//        }
    }
}
