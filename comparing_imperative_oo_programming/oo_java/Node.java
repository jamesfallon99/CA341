import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Node{
    public String name;
    public String address;
    public int number;
    public Node left;
    public Node right;
    Map<Integer, List<String>> map = new HashMap<Integer, List<String>>(); //mapping the number to the name and address
    List<String> contact = new ArrayList<String>(); //A list used to store the name and address as a map can only have one key and one value

    public Node(String n, String addr, int num){
        name = n;
        address = addr;
        number = num;
        left = null;
        right = null;
        contact.add(name);
        contact.add(address);
        map.put(number, contact);
    }
    public String toString(){
        return name + " lives in " + address + " and has number " + number;
    }
}
