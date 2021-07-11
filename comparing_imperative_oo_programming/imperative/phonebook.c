//https://www.codesdope.com This is where I found an implemntation of a BST in c. As I didn't know c before this assignment, I learned from this implementation and added on to the features so that it worked like a phonebook. I have stated in the comments what is my work and what was taken from this source
#include <stdio.h>
#include <stdlib.h>

struct node //This struct was wrote by me
{
    char name[31]; //node will store a name
    char address[50]; //node will store an address
    int number; //node will store a number
    struct node *right_child; // right child
    struct node *left_child; // left child
};


struct node* new_node(char n[31], char addr[50], int num) //got help from the website above to implement this function
{
    struct node *p;
    p = malloc(sizeof(struct node)); //To create a new node, we use the malloc() function to allocate memory dynamically
    p->name[31] = n[31];
    p->address[50] = addr[50];
    p->number = num;
    p->left_child = NULL;
    p->right_child = NULL;

    return p;
}

struct node* add(struct node *root, char n[31], char addr[50], int num) //The logic of adding to a BST was wrote by me but got help from the website commented above
{
    //looking for the place to add the node
    if(root==NULL) //if there's no node, create a new node
        return new_node(n, addr, num);
    else if(num>root->number) // if num is greater,add to right
        root->right_child = add(root->right_child, n, addr, num);
    else // num is smaller, add to left
        root->left_child = add(root->left_child, n, addr, num);
}

struct node* search(struct node *root, int num) //The logic of searching a BST was wrote by me but got help from the website commented above
{
    if(root==NULL || root->number==num) //if root->number is num then the element is found
        return root;
    else if(num>root->number){ // if num is greater, search the right subtree
        return search(root->right_child, num);
    }
    else //if num is smaller, search the left subtree
        return search(root->left_child,num);
     printf(" %d ", root->name);
     printf(" %d ", root->address);//can't get this function to print correctly
}


//function to find the minimum value in a node--used in the delete function(helper function)

struct node* find_minimum(struct node *root) //This function was taken from the website commented above. There was a lot of tricky cases invloved in removing a node from a BST and I couldn't get it working correctly myself
{
    if(root == NULL)
        return NULL;
    else if(root->left_child != NULL) // node with minimum value will have no left child
        return find_minimum(root->left_child); // left most element will be minimum
    return root;
}

// funnction to delete a node
struct node* delete(struct node *root, int num) //This function was taken from the website commented above.
{
    //searching for the item to be deleted
    if(root==NULL)
        return NULL;
    if (num>root->number)
        root->right_child = delete(root->right_child, num);
    else if(num<root->number)
        root->left_child = delete(root->left_child, num);
    else
    {
        //No Children
        if(root->left_child==NULL && root->right_child==NULL)
        {
            free(root);
            return NULL;
        }

        //One Child
        else if(root->left_child==NULL || root->right_child==NULL)
        {
            struct node *temp;
            if(root->left_child==NULL)
                temp = root->right_child;
            else
                temp = root->left_child;
            free(root);
            return temp;
        }

        //Two Children
        else
        {
            struct node *temp = find_minimum(root->right_child);
            root->number = temp->number;
            root->right_child = delete(root->right_child, temp->number);
        }
    }
    return root;
}

void inorder(struct node *root)
{
    if(root!=NULL) // checking if the root is not null
    {
        inorder(root->left_child); // visiting left child
        //printf(" %d ", root->name); // printing data at root
        //printf(" %d ", root->address);
        printf(" %d ", root->number);
        inorder(root->right_child);// visiting right child
    }
}

int main()
{
    struct node *root;
    root = new_node("Bob", "Cork", 879130657);
    add(root,"James", "Galway",838748758);
    add(root,"joe", "Dublin", 893457374);
    add(root,"Jim", "Offaly", 895967374);
    printf("In order traverse of the tree");
    printf("\n");
    inorder(root); //Can't get the name and address to print correctly
    printf("\n");
    root = delete(root, 893457374);
    printf("Joe has been removed from the tree");
    printf("\n");
    printf("In order traverse of the tree");
    printf("\n");
    inorder(root);
    printf("\n");
    printf("The person with number 879130657 is:");
    search(root, 879130657); //working but can't get it to print correctly
    
}