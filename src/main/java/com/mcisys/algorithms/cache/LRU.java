package main.java.com.mcisys.algorithms.cache;

import java.util.HashMap;

public class LRU<K, V> {

    private int capacity;
    private HashMap<K, Node> nodeMap;
    private Node first;
    private Node last;

    public LRU(int capacity) {
        this.capacity = capacity;
        this.nodeMap = new HashMap<>(capacity);
    }

    //添加节点
    public void put(K key, V value) {
        Node node = nodeMap.get(key);
        if (node == null) {
            if (nodeMap.size() >= capacity) {
                nodeMap.remove(last.key);
                removeLast();
            }
            node = new Node(key, value);
        }
        node.value = value;
        moveToHead(node);
        nodeMap.put(key, node);
    }

    //访问节点
    public Node get(K key) {
        Node node = nodeMap.get(key);
        if (node != null) {
            moveToHead(node);
        }
        return node;
    }

    //移除最后一个节点
    private void removeLast() {
        if (last == null) return;
        last = last.pre;
        if (last != null) {
            last.next = null;
        } else {
            first = null;
        }
    }

    //将节点移动到头部
    private void moveToHead(Node node) {
        if (node == first) return;
        if (node.next != null) {
            node.next.pre = node.pre;
        }
        if (node.pre != null) {
            node.pre.next = node.next;
        }
        if (node == last) {
            last = last.pre;
        }
        if (first == null || last == null) {
            first = last = node;
            return;
        }
        node.next = first;
        first.pre = node;
        first = node;
        first.pre = null;
    }

    //根据key移除节点
    private Node remove(K key) {
        Node node = nodeMap.get(key);
        if (node != null) {
            if (node.next != null) {
                node.next.pre = node.pre;
            }
            if (node.pre != null) {
                node.pre.next = node.next;
            }
            if (node == first) {
                first = first.next;
            }
            if (node == last) {
                last = last.pre;
            }
            nodeMap.remove(key);
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = first;
        while (node != null) {
            sb.append(String.format("%s:%s ", node.key, node.value));
            node = node.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LRU<Integer, String> lru = new LRU<Integer, String>(5);
        lru.put(1, "a");
        lru.put(2, "b");
        lru.put(3, "c");
        lru.put(4, "d");
        lru.put(5, "e");
        System.out.println("原始链表为:" + lru.toString());

        lru.get(4);
        System.out.println("获取key为4的元素之后的链表:" + lru.toString());

        lru.put(6, "f");
        System.out.println("新添加一个key为6之后的链表:" + lru.toString());

        lru.remove(3);
        System.out.println("移除key=3的之后的链表:" + lru.toString());
    }

    class Node {
        Object key;
        Object value;
        Node next;
        Node pre;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
}
