import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class BinarySearchTree1{//In this BST, the number was used for insertion and searching

    public List searchNameAndAddress(Node node, int num){
        if(node == null){
            return null;
        }
        while(node.number != num){
            if(num < node.number){//go into the left child
                node = node.left;
            }
            else{
                node = node.right;//otherwise go to the right child
            }

        }
        return node.map.get(num);//return the name and address
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



    public Node add(Node node, String name, String addr, int num){
        if(node == null){
            Node contact = new Node(name, addr, num);
            return contact;
        }
        if(num < node.number){
            node.left = add(node.left, name, addr, num);
        }
        else if(num > node.number){
            node.right = add(node.right, name, addr, num);
        }
        return node; 
    }

    public Node remove(Node node, int num){ //Tried to implement this method myself but after a good amount of time, I couldn't get it working. Found a good explanation here: https://thecodingsimplified.com/delete-a-node-of-binary-search-tree/ and this helped me figure out where I was going wrong.
        if(node == null){
            return null;
        }
        if(num < node.number){
            node.left = remove(node.left, num);//if number is less than current number recursively go through the function until you get to the node you want to remove 
        }
        else if (num > node.number) {
            node.right = remove(node.right, num); //if number is greater than current number recursively go through the function until you get to the node you want to remove 
        }
        else{ //once the number is equal to the current number, go into this else statement
            if(node.left == null || node.right == null){ //if the node has no children
                Node tmp = null; //create a temp value
                if(node.left == null){ //if the left node is null
                    tmp = node.left; //let the temp equal to the left node
                    //return this null value(aka removed the value by setting it to null)
                }
                else{
                    tmp = node.right; //otherwise, let it equal the right node
                }

                if(tmp == null){
                    return null;
                }
                else{
                    return tmp;
                }
            }else {
                Node child = getChild(node); //if a node has both children, need to get that child
                node.number = child.number;
                node.right = remove(node.right,child.number);
                return node;
            }
        }
        return node;
    }
    public Node getChild(Node node){ //create a helper function to help get the child
        if(node == null){
            return null;
        }
        Node tmp = node.right;
        while(tmp != null){
            tmp = tmp.left;
        }
        return tmp;
    }
}