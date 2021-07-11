import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class BinarySearchTree2{ //This BST uses name for insertion and searching
    
    public Node add(Node node, String name, String addr, int num){
        if(node == null){
            Node contact = new Node(name, addr, num);
            return contact;
        }
        if(name.compareTo(node.name) < 0){
            node.left = add(node.left, name, addr, num);
        }
        else if(name.compareTo(node.name) > 0){
            node.right = add(node.right, name, addr, num);
        }
        return node;
    }

    public int searchNumber(Node node, String name){
        if(node == null){
            return 0;
        }
        while(!name.equals(node.name)){
            if(name.compareTo(node.name) < 0){
                node = node.left;
            }
            else if(name.compareTo(node.name) > 0){
                node = node.right;
            }
        }
        return node.number;
    }
    public Node remove(Node node, int num){
        if(node == null){
            return null;
        }
        if(num < node.number){
            node.left = remove(node.left, num);
        }
        else if (num > node.number) {
            node.right = remove(node.right, num);
        }
        else{
            if(node.left == null || node.right == null){
                Node tmp = null;
                if(node.left == null){
                    tmp = node.left;
                }
                else{
                    tmp = node.right;
                }

                if(tmp == null){
                    return null;
                }
                else{
                    return node;
                }
            }else {
                Node child = getChild(node);
                node.number = child.number;
                node.right = remove(node.right,child.number);
                return node;
            }
        }
        return node;
    }
    public Node getChild(Node node){
        if(node == null){
            return null;
        }
        Node tmp = node.right;
        while(tmp != null){
            tmp = tmp.left;
        }
        return tmp;
    }

    public void inOrderTraverseTree(Node node) {
        if (node != null) {
            // Traverse the left node
            preorderTraverseTree(node.left);
            // Visit the currently focused on node
            System.out.println(node);
            // Traverse the right node
            preorderTraverseTree(node.right);
        }
    }

    public void preorderTraverseTree(Node node) {
        if (node != null) {
            System.out.println(node);
            preorderTraverseTree(node.left);
            preorderTraverseTree(node.right);
        }
    }

    public void postOrderTraverseTree(Node node) {
        if (node != null) {
            preorderTraverseTree(node.left);
            preorderTraverseTree(node.right);
            System.out.println(node);
        }
    }

}
