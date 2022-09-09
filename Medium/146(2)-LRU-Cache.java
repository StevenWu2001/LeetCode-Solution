// LinkedHashMap implementation

class LRUCache {
    
    LinkedHashMap<Integer, Integer> lru;
    Map<Integer, Integer> cache;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        lru = new LinkedHashMap<>();
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            updateLRU(key);
            return cache.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        updateLRU(key);
        if (cache.size() == capacity && !cache.containsKey(key)) {
            int re = lru.keySet().iterator().next();
            cache.remove(re);
            lru.remove(re);
        }
        cache.put(key, value);
    }
    
    private void updateLRU(int key) {
        lru.remove(key);
        lru.put(key, 1);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

