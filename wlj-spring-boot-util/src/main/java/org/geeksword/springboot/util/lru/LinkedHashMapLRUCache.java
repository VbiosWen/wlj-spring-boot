package org.geeksword.springboot.util.lru;

import com.google.common.base.Preconditions;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 10:19 2019-08-05
 * @Modified By:
 */
public class LinkedHashMapLRUCache<K,V> implements LRUCache<K,V> {

  private static final byte[] lock = new byte[0];

  private final int limit;

  private final InnerLruCache<K,V> innerLruCache;

  public LinkedHashMapLRUCache(int limit) {
    Preconditions.checkArgument(limit > 0 ,"the limit must big than zero.");
    this.limit = limit;
    this.innerLruCache = new InnerLruCache<>(limit);
  }



  @Override
  public void put(K key, V value) {
    synchronized (lock){
      innerLruCache.put(key,value);
    }
  }

  @Override
  public V get(K key) {
    return innerLruCache.get(key);
  }

  @Override
  public void remove(K key) {
    synchronized (lock){
      innerLruCache.remove(key);
    }
  }

  @Override
  public int size() {
    return innerLruCache.size();
  }

  @Override
  public void clear() {
    synchronized (lock){
      innerLruCache.clear();
    }
  }

  @Override
  public int limit() {
    return limit;
  }

  @Override
  public String toString() {
    return this.innerLruCache.toString();
  }

  private static class InnerLruCache<K,V> extends LinkedHashMap<K,V>{

    private static final long serialVersionUID = -2878946364420308368L;
    final int limit;

    public InnerLruCache(int limit) {
      super(16,0.75f,true);
      this.limit = limit;
    }

    /**
     * 重点,重写这个方法,保证 cache 缓存超过 limit 时,直接移除头结点
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
      return size() > limit;
    }
  }

}
