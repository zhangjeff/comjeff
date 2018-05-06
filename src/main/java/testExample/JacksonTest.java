package testExample;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JacksonTest {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
//        List<Person> persons = new ArrayList<Person>();
//        Integer[] arrays = new Integer[2];
//        Person person = null;
//        for (int i = 0; i < 2; i++) {
//            person = new Person("test" + i, "pwd" + i, "phone" + i,
//                    "tencent@QQ.com" + i, "男", "23");
//            persons.add(person);
//            arrays[i] = i;
//        }
//        Map<String, String> tipMap = new HashMap<String, String>();
//        tipMap.put("valueName", "10");
//        tipMap.put("valueName2", "3");
//        tipMap.put("valueName3", "5");
//        tipMap.put("valueName4", "8");
//        Map<String, Object> map2Json = new HashMap<String, Object>();
//        // 加入list对象
//        map2Json.put("personKey", persons);
//        // 加入map对象
//        map2Json.put("mapKey", tipMap);
//        // 加入数组对象
//        map2Json.put("idKey", arrays);
//        //转化为json字符串
//        String json = objectMapper.writeValueAsString(map2Json);
//        System.out.println(json);

        String json2 = "{\"name\":\"ZhangSan\",\"age\":25,\"emailAddress\":\"abc@163.com\"}";
        User user = objectMapper.readValue(json2, User.class);

        System.out.println("sucesss！");
    }
}


class User implements Serializable{

    public String name;

    public int age;

    public String emailAddress;

    /**
//     * 构造函数
//     */
//    public User(String name, int age, String emailAddress) {
//        super();
//        this.name = name;
//        this.age = age;
//        this.emailAddress = emailAddress;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}