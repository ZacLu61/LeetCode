package Apr27;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146
{
    Node head, tail;

    Map<Integer, Node> map;

    int capacity;

    public LRUCache146(int capacity)
    {
        head = new Node(0, 0);

        tail = new Node(0, 0);

        head.next = tail;

        tail.pre = head;

        map = new HashMap<>();

        this.capacity = capacity;
    }

    public int get(int key)
    {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);

        removeNode(node);

        addToHead(node);

        return node.val;
    }

    private void removeNode(Node node)
    {
        node.pre.next = node.next;

        node.next.pre = node.pre;
    }

    private void addToHead(Node node)
    {
        node.next = head.next;

        head.next.pre = node;

        head.next = node;

        node.pre = head;
    }

    public void put(int key, int value)
    {
        if (map.containsKey(key))
        {
            Node node = map.get(key);

            node.val = value;

            get(key);
        }
        else
        {
            if (map.size() >= capacity)
            {
                map.remove(tail.pre.key);

                removeNode(tail.pre);
            }
            Node node = new Node(key, value);

            map.put(key, node);

            addToHead(node);
        }
    }

    private class Node
    {
        int key, val;

        Node pre, next;

        Node(int key, int val)
        {
            this.key = key;

            this.val = val;

            pre = next = null;
        }
    }
}
