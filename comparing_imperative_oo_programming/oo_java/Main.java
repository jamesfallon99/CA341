import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Main{
    //For help on BSTs, I looked at Charles Daly's python notes from CA269 Programming 3. This helped me understand BSTs and how to implement them efficiently. This program is written in Java and implented by myself.
    public static void main(String[] args) {
        System.out.println("Binary search tree 1");
        BinarySearchTree1 phonebook = new BinarySearchTree1();
        Node root = null;
        root = phonebook.add(root, "James", "Galway", 879854671);
        root = phonebook.add(root, "Bob", "Dublin", 837658213);
        root = phonebook.add(root, "Tom", "Cork", 895782423);
        root = phonebook.add(root, "Mary", "Offaly", 856978901);
        System.out.println("The name and address of the person with number 895782423 is: ");
        System.out.println(phonebook.searchNameAndAddress(root, 895782423)); //Searches for the name and address of a person given the number. Returns a list
        root = phonebook.remove(root, 895782423);
        System.out.println("Tom has been removed from the tree");
        System.out.println("In order traverse of the tree");
        phonebook.inOrderTraverseTree(root);
    
        System.out.println("\n");
        System.out.println("Binary search tree 2");
        BinarySearchTree2 phonebook2 = new BinarySearchTree2();
        root = phonebook2.add(root, "James", "Galway", 879854671);
        root = phonebook2.add(root, "Bob", "Dublin", 837658213);
        root = phonebook2.add(root, "Tom", "Cork", 895782423);
        root = phonebook2.add(root, "Mary", "Offaly", 856978901);
        
        root = phonebook2.remove(root, 895782423);
        System.out.println("Tom has been removed from the tree");

        System.out.println("Bob's number is:");
        System.out.println(phonebook2.searchNumber(root, "Bob"));

        System.out.println("In order traverse of the tree");
        phonebook2.inOrderTraverseTree(root);
        
        
        
    }
}