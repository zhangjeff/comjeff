package hashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserTest {

    public static void main(String[] args) {
        UserFeatureInfo userFeatureInfo = new UserFeatureInfo();
        List<String> names = new ArrayList<>();
        names.add("1111");
        names.add("2222");
        userFeatureInfo.setName(names);

        List<String> testName = userFeatureInfo.getName();
        testName.add("333");
        testName.add("4444");
        testName.remove("1111");
//        System.out.println(userFeatureInfo.getName().size());
        for (String name: userFeatureInfo.getName()) {
            System.out.println(name);
        }

    }
}
