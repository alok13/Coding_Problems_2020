package Feb_22;

import java.util.*;

public class CloneGraph {
}


// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Node, Node> nodeMap=new HashMap<>();
        Node newNode=new Node(node.val);
        nodeMap.put(node,newNode);


        Queue<Node> queue=new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node currentNode=queue.poll();
            for(Node n:currentNode.neighbors){
                if(!nodeMap.containsKey(n)){
                    Node newNode1=new Node(n.val);
                    nodeMap.put(n,newNode1);
                    queue.add(n);
                }
                nodeMap.get(currentNode).neighbors.add(nodeMap.get(n));
            }
        }

        return newNode;

    }
}
