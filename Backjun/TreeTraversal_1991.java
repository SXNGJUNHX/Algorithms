package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeTraversal_1991 {

    public static class Node{
        String data;
        Node left;
        Node right;

        Node(String data){
            this.data=data;
        }
    }

    static StringBuilder sb = new StringBuilder();
    static public Node root;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");

            String parent = st.nextToken();
            String leftChild = st.nextToken();
            String rightChild = st.nextToken();

            createNode(parent, leftChild, rightChild);
        }

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);


    }

    public static void createNode(String data, String leftData, String rightData) {
        if(root==null) { //루트 노트 없으면
            root = new Node(data);

            if(!leftData.equals(".")) {
                root.left= new Node(leftData);
            }
            if(!rightData.endsWith(".")) {
                root.right = new Node(rightData);
            }

        }else { //루트 노드 있으면
            searchNode(root, data, leftData, rightData);
        }
    }

    public static void searchNode(Node node ,String data, String leftData, String rightData) {
        if(node==null) return;
        else if(node.data.equals(data)) {
            if(!leftData.equals(".")) {
                node.left = new Node(leftData);
            }
            if(!rightData.equals(".")) {
                node.right = new Node(rightData);
            }
        }else {
            searchNode(node.left, data, leftData, rightData);
            searchNode(node.right, data, leftData, rightData);
        }
    }

    public static void preOrder(Node node) { //전위순회
        if(node !=null) {
            System.out.print(node.data);
            if(node.left!=null) preOrder(node.left);
            if(node.right!=null) preOrder(node.right);
        }
    }

    public static void inOrder(Node node) { //중위순회
        if(node!=null) {
            if(node.left!=null) inOrder(node.left);
            System.out.print(node.data);
            if(node.right!=null) inOrder(node.right);
        }
    }

    public static void postOrder(Node node) { //후위순회
        if(node!=null) {
            if(node.left!=null) postOrder(node.left);
            if(node.right!=null) postOrder(node.right);
            System.out.print(node.data);
        }
    }
}


