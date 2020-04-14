package utilities;

import java.util.HashMap;
import java.util.Map;

public class TempDataStorageUtils {



    private static Map<String, String> data = new HashMap<>();

    public static void addData(String key, String value) {
        data.put(key, value);
    }
    public static String getData(String key) {
        return data.get(key);
    }

    public static boolean compareData(String data1, String data2) {

        if (TempDataStorageUtils.getData(data1).equals(TempDataStorageUtils.getData(data2))) return true;
        return false;
    }

    public static void clear(){
        data.clear();
    }
}
