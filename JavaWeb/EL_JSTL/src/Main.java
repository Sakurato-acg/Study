import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main  {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        System.out.println(entries);
        System.out.println("map.entrySet() = " + map.entrySet());
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.print(next.getKey()+"\t");
            System.out.println(next.getValue());
        }
        //        for (Map.Entry<String,String> entry:entries) {
//            System.out.println("entries = " + entries);
//        }s
    }
}