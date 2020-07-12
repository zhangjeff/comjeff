package hashMap;

public class HashMap<K, V> implements Map<K, V> {

    private Integer maxCapcity;

    private Integer size = 0;

    private static final int defaultMaxCapcity = 16;
    private Entry[] entryList = null;

    public HashMap(Integer maxCapcity) {
        if (maxCapcity == null) {
            this.maxCapcity = defaultMaxCapcity;
        } else {
            this.maxCapcity = maxCapcity;
        }
        entryList = new Entry[maxCapcity];
    }

    @Override
    public V put(K k, V v) {
        int hash = hash(k);
        Entry entryHash = entryList[hash];
        if (entryHash == null) {
            entryList[hash] = new Entry(k, v, null, k.hashCode());
            size++;
        } else {
            entryList[hash] = new Entry(k, v, entryHash, k.hashCode());
            size++;
        }
        return (V) entryList[hash].getV();
    }

    @Override
    public V get(K k) {
        V e = getEntry(k);
        return e != null ? e : null;
    }

    private V getEntry(K k) {
        int hash = hash(k);
        for (Entry e = entryList[hash]; e != null; e = e.next) {
            if (e.hash == k.hashCode() && (k == e.k || k.equals(e.k))) {
                return (V) e.getV();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return entryList.length;
    }

    @Override
    public int hash(K k){
        int hashCode = k.hashCode();
        int hash = hashCode % (maxCapcity - 1);
        return hash > 0 ? hash : Math.abs(hash);
    };

    class Entry<K, V> implements Map.Entry<K, V> {
        K k;
        V v;
        Entry<K,V> next;
        int hash;

        public K getK() {
            return k;
        }

        public V getV() {
            return v;
        }

        public Entry(K k, V v, Entry<K, V> next, int hash) {
            this.k = k;
            this.v = v;
            this.next = next;
            this.hash = hash;
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap(16);
        for (int i = 0; i < 100; i++) {
            String key = "zhangsan"+i;
            map.put(key,"jeff" + i);
            System.out.println(map.get("zhangsan"+i) + "----hash=" + map.hash(key));
        }
    }
}
