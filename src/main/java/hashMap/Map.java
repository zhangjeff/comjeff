package hashMap;

public interface Map<K, V> {

    V put(K k, V v);

    V get(K k);

    int size();

    int hash(K k);

    interface Entry<K, V> {
        K getK();

        V getV();
    }
}
