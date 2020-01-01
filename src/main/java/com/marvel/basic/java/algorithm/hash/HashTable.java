package com.marvel.basic.java.algorithm.hash;

import java.util.Map;

/**
 * 散列表的实现
 */
public class HashTable<K, V> {
    //默认列表长度
    private static final int DEFAULT_INIT_CAPANITY = 8;
    //默认装载因子大小
    private static final float LOAD_FACTOR = 0.75f;
    //初始化散列表数组
    private Entry<K, V>[] table;
    //数组中实际元素数量
    private int size = 0;
    //散列表索引数量
    private int use = 0;

    public HashTable() {
        table = (Entry<K, V>[]) new Map.Entry[DEFAULT_INIT_CAPANITY];
    }

    static class Entry<K, V> {
        K key;
        V value;

        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    //实现hash函数,参考hashmap散列函数, 返回值大小区间是不是在[0,table.length]
    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16)) % table.length;
    }

    /**往hash表中新增数据**/
    public void put(K key, V value) {
        int index = hash(key);
        //位置未被占用，创建哨兵节点
        if (table[index] == null) {
            table[index] = new Entry<K, V>(null, null, null);
        }

        Entry<K, V> tmp = table[index];
        //新增节点
        if (tmp.next == null) {
            tmp.next = new Entry<K, V>(key, value, null);
            size++;
            use++;
            //动态扩容
            if (use >= table.length * LOAD_FACTOR) {
                resize();
            }
        } else {
            //解决散列冲突，使用链表法
            do {
                tmp = tmp.next;
                if (tmp.key == key) {
                    tmp.value = value;
                    return;
                }
            }while (tmp.next != null);

            Entry<K, V> temp = table[index].next;
            table[index].next = new Entry<K, V>(key, value, temp);
            size++;
        }
    }

    //删除数据
    public void remove(K key) {
        int index = hash(key);
        Entry e = table[index];
        if (e == null || e.next == null) {
            return;
        }

        Entry pre;
        Entry<K, V> headNode = table[index];
        do {
            pre = e;
            e = e.next;
            if (key == e.key) {
                pre.next = e.next;
                size--;
                if (headNode.next == null)
                    use--;
                return;
            }
        } while (e.next != null);
    }

    //获取值
    public V get(K key) {
        int index = hash(key);
        Entry<K, V> e = table[index];
        if (e == null || e.next == null) {
            return null;
        }

        while (e.next != null) {
            e = e.next;
            if (key == e.key) {
                return e.value;
            }
        }

        return null;
    }

    //扩容
    public void resize() {
        Entry<K, V>[] oldTable = table;
        table = (Entry<K, V>[]) new Entry[table.length * 2];
        use = 0;
        //将老表中的元素复制到新表中
        for (int i=0; i<oldTable.length; i++) {
            if (oldTable[i] == null || oldTable[i].next == null) {
                continue;
            }
            Entry<K, V> e = oldTable[i];
            while (e.next != null) {
                e = e.next;
                int index = hash(e.key);
                if (table[index] == null) {
                    use++;
                    //创建哨兵节点
                    table[index] = new Entry<K, V>(null, null, null);
                }
                table[index].next = new Entry<K, V>(e.key, e.value, table[index].next);
            }
        }
    }
}
