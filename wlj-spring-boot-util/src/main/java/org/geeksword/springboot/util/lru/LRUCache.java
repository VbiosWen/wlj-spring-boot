package org.geeksword.springboot.util.lru;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 10:20 2019-08-05
 * @Modified By:
 */
public interface LRUCache<K,V> {

  void put(K key,V value);

  V get(K key);

  void remove(K key);

  int size();

  void clear();

  int limit();


}
