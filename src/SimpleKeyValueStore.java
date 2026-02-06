import java.util.ArrayList;

public class SimpleKeyValueStore<K, V> implements KeyValueStore<K, V> {

    ArrayList<K> keys = new ArrayList<>();
    ArrayList<V> values = new ArrayList<>();


    @Override
    public void put(K key, V value) {
        if(containsKey(key)) {
            int index = keys.indexOf(key);
            values.set(index, value);
        } else {
            keys.add(key);
            values.add(value);
        }
    }

    @Override
    public V get(K key) {
        if(containsKey(key)){
            int index = keys.indexOf(key);
            return values.get(index);
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return keys.contains(key);
    }
}
