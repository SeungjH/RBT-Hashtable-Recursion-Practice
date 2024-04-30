import java.util.NoSuchElementException;

/**
 * This class contains various methods that pairs keys to values in which
 * duplicate keys are not allowed
 *
 */
public class HashtableMap<keyType, valueType>{

    /**
     * This helper class contains methods that pairs key and value within a
     * single object
     *
     */
    public class HashPair<keyType, valueType> {
        private keyType key; // key type
        private valueType value; // value type

        /**
         * pairs the key and value within a single object
         *
         * @param key   key of hash table
         * @param value value of hash table
         */
        public HashPair(keyType key, valueType value) {
            this.key = key;
            this.value = value;
        }

        /**
         * getter for the key type
         *
         * @return key type of hash table
         */
        public keyType getKey() {
            return this.key;
        }

        /**
         * getter for the value type
         *
         * @return value type of hash table
         */
        public valueType getValue() {
            return this.value;
        }
    }

    protected HashPair<keyType, valueType>[] array; // array of key types and values within a single object=HashPair
    private int capacity; // the capacity of the hash table array
    private int size = 0; // number of pairs in the array
    private double loadFac; // load factor, size/capacity

    /**
     * the constructor for the hash table
     *
     * @param capacity the capacity of the hash table array
     */
    @SuppressWarnings("unchecked")
    public HashtableMap(int capacity) {
        this.capacity = capacity;
        this.size = size;
        array = new HashPair[capacity];
        this.loadFac = (double) size / (double) capacity;

    }

    /*
     * the constructor for the hash table with default capacity, 8
     *
     */
    @SuppressWarnings("unchecked")
    public HashtableMap() {
        this.capacity = 8;
        this.size = size;
        array = new HashPair[capacity];
        this.loadFac = (double) size / (double) capacity;

    }

    /*
     * add a new key-value pair/mapping to this hash table array
     *
     * @param key the key to add to this hash table array
     *
     * @throws IllegalArgumentException with a descriptive message indicating the
     * key is null or duplicate
     */
    public void put(keyType key, valueType value) throws IllegalArgumentException {
        //combine key and value into an object (HashPair) and add it to the array.
        //also, address collisions that may happen when adding. 
        if(key == null || containsKey(key)){
            throw new IllegalArgumentException("the key is null or is a duplicate");
        }
        
        HashPair<keyType, valueType> hp = new HashPair<keyType,valueType>(key, value);
        //index for the pair in the hashtable
        int hashIndex = Math.abs(key.hashCode()) % capacity;
        //adding pair
        if(array[hashIndex] == null){
            array[hashIndex] = hp;
        }
        //collision
        else{
            while(array[hashIndex] != null){
                hashIndex++;
                if(hashIndex == capacity){
                    hashIndex=0;
                }
            }
            array[hashIndex] = hp;
        }
        size++;
        //chekcing loadfactor
        this.loadFac = (double)size/capacity;
        if(loadFac >= 0.7){
            //double size and rehash using helper methods
            rehash();
        }

    }

    /*
     * rehasing involves doubling the array size 
     * and assigning existing HashPair objects a new index in the doubled array
     */
    private void rehash(){
        capacity = capacity * 2;
        HashPair<keyType, valueType>[] newArray = new HashPair[capacity];
        for(HashPair<keyType, valueType> hp : array){
            if(hp != null){
                int hashIndex = Math.abs(hp.key.hashCode()) % capacity;
                //checking collision
                while(newArray[hashIndex] != null){
                    hashIndex++;
                    if(hashIndex == capacity){
                        hashIndex=0;
                    }
                }
                newArray[hashIndex] = hp; 
            }
        }
        array = newArray;
    }


    
    /*
     * check whether a key maps to a value within this hash table array
     *
     * @param key the key to check within this hash table array
     */
    public boolean containsKey(keyType key) {
        for(HashPair<keyType,valueType> hp : array){
            if(hp != null  && hp.key == key){
                return true;
            }
        }
        return false;

    }

    /*
     * method that returns the string representation of the hash table array element
     *
     */
    @Override
    public String toString() {
        String s = "";
        // loop through the array and store the string representation
        // of the hash table array element
        for (HashPair<keyType,valueType> pair : array) {
            if (pair == null) {
                s += "(null, null) ";
            } else {
                s += "(" + pair.getKey() + ", " + pair.getValue() + ") ";
            }
        }
        return s;
    }

    /*
     * returns the value that is paired with the key that is stored in the
     * hash table array
     *
     * @param key the key to search for the value
     *
     * @return the value that is paired with the given key
     *
     * @throws NoSuchElementException when the key is not stored in the
     * array
     *
     */
    public valueType get(keyType key) throws NoSuchElementException {
        for(HashPair<keyType,valueType> hp : array){
            if(hp != null && hp.key.equals(key)){
                return hp.getValue();
            }
        }
        throw new NoSuchElementException("the key is not stored in the array");
    }

    /*
     * remove the pair of the given key from the hash table array
     *
     * @param key the key to remove from the hash table array
     *
     * @return the value of the given key which was removed from the hash table
     * array
     *
     */
    public valueType remove(keyType key) throws NoSuchElementException {
        for(HashPair<keyType,valueType> hp : array){
            if(hp != null && hp.key.equals(key)){
                HashPair<keyType, valueType> tempHP = new HashPair(hp.key, hp.value);
                array[Math.abs(hp.key.hashCode()) % capacity] = null;
                size--;
                return tempHP.value;
            }
        }
        throw new NoSuchElementException("the provided key does not belong to any HashPair in this array");
    }

    /*
     * remove all key-value pairs from this hash table array
     *
     */
    public void clear() {
        this.size = 0;
        this.array = new HashPair[capacity];

    }

    /*
     * return the number of keys stored within this hash table array
     *
     */
    public int getSize() {
        return this.size;
    }

    /*
     * return the capacity of this hash table array
     */
    public int getCapacity() {
        return this.capacity;
    }

}