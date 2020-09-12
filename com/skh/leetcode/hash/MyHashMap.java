package leetcode.hash;

/**
 * 706. 设计哈希映射
 * @Description
 * 不使用任何内建的哈希表库设计一个哈希映射
 *
 * 具体地说，你的设计应该包含以下的功能
 *
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 * remove(key)：如果映射中存在这个键，删除这个数值对。
 *
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);          
 * hashMap.put(2, 2);        
 * hashMap.get(1);            // 返回 1
 * hashMap.get(3);            // 返回 -1 (未找到)
 * hashMap.put(2, 1);         // 更新已有的值
 * hashMap.get(2);            // 返回 1
 * hashMap.remove(2);         // 删除键为2的数据
 * hashMap.get(2);            // 返回 -1 (未找到)
 *
 * @auther SHENKAIHUAN
 * @create 2020-09-12 16:15
 */
public class MyHashMap {

    int[] table;
    /** Initialize your data structure here. */
    public MyHashMap() {
        table=new int[1000001];
        for (int i=0;i<table.length;i++){
            table[i]=-1;
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        table[key]=value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return table[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        table[key]=-1;
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        // 返回 1
        System.out.println ( hashMap.get(1));
        // 返回 -1 (未找到)
        System.out.println (hashMap.get(3));
        // 更新已有的值
        hashMap.put(2, 1);
        // 返回 1
        System.out.println (hashMap.get(2));
        // 删除键为2的数据
        hashMap.remove(2);
        // 返回 -1 (未找到)
        System.out.println (hashMap.get(2));
    }
}
