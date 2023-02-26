import java.util.LinkedList;
import java.util.Queue;
//2b

public class ServiceCenter {
    // TreeNode class
    static class Node {
        public int key;
        public Node left, right;
    };

    static Node newNode(int key)
    {
        Node temp = new Node();
        temp.key = key;
        temp.left = temp.right = null;
        return temp;
    }

    // Stores the minimum number of
    // cameras required
    static int cnt = 0;

    // Utility function to find minimum
    // number of cameras required to
    // monitor the entire tree
    static int minCameraSetupUtil(Node root)
    {
        // If root is NULL
        if (root == null)
            return 1;

        int L = minCameraSetupUtil(root.left);
        int R = minCameraSetupUtil(root.right);

        // Both the nodes are monitored
        if (L == 1 && R == 1)
            return 2;

            // If one of the left and the
            // right subtree is not monitored
        else if (L == 2 || R == 2) {
            cnt++;
            return 3;
        }

        // If the root node is monitored
        return 1;
    }

    // Function to find the minimum number
    // of cameras required to monitor
    // entire tree
    static void minServiceCenters(Node root)
    {
        int value = minCameraSetupUtil(root);

        // Print the count of cameras
        System.out.println(cnt + (value == 2 ? 1 : 0));
    }

    // Driver code
    public static void main(String[] args)
    {
        Integer[] tree = {0,0, null, 0, null, 0, null, null, 0, null, null};
        for (int i=0; i<tree.length; i++) {
            if (tree[i] == null) {
                tree[i] = -1;
            }
        }
        Node root = deserialize(tree);
        minServiceCenters(root);
    }


    public static Node deserialize(Integer[] A) {

        Node root = newNode(A[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while(q.size() != 0){
            Node cur = q.peek();
            q.remove();
            if(cur == null){
                continue;
            }
            int val_left = A[i];
            int val_right = A[i+1];

            i += 2;

            if(val_left == -1){
                cur.left = null;
            }
            else{
                cur.left = newNode(val_left);
            }
            if(val_right == -1){
                cur.right = null;
            }
            else{
                cur.right = newNode(val_right);
            }
            q.add(cur.left);
            q.add(cur.right);
        }

        return root;

    }
}
