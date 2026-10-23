import java.util.HashMap;
import java.util.Map;


public class Main{
    // 01 - static 
    static int add(int a, int b){   
        return a + b;
    }

    // 02 - non - static
    public int add1(int c, int d){
        return c + d;
    }

    public static void main(String[] args){
        
        // 01 - This works because both main() and add() are static. - does not need object create
        System.out.println(add(1, 2));  

        // 02 - need to create obl=ject caz this is non static
        Main obj = new Main();
        System.out.println(obj.add1(2, 4));


        // 03 - assign static to variable
        int total = add(10, 20);
        System.out.println(total);

        // 04 
        System.out.println((int)Math.sqrt(25));

        // 05
        // TESTING THE SET
        System.out.println("Testing the set");

        SimpleSet a = new SimpleSet();

        System.out.println("Adding Apple: " + a.add("Apple"));
        System.out.println("Adding Apple: " + a.add("Banana"));
        System.out.println("Adding Apple: " + a.add("Apple"));

        System.out.println("Set contents: " + a);
        System.out.println("Set size: " + a.size());


        // CUSTOM BAG (MULTISET) IMPLEMENTATION
        System.out.println("Testing the Bag");
        
        SimpleBag b = new SimpleBag();
        b.add("Apple");
        b.add("Banana");
        b.add("Apple");
        
        System.out.println("Bag contents: " + b);
        System.out.println("How many Apples? : " + b.getCount("Apple"));    // Apple need to same name as Key name
        System.out.println("How many Bananas? : " + b.getCount("Banana"));
        System.out.println("Set size: " + b.size());


    }


    // 05
    // ------------------------------
    // CUSTOM SET IMPLIMENTATION
    // ------------------------------

    static class SimpleSet{
        // Map is used to store items.
        // The key = item
        // The value = dummy value (true)
        private final Map<String, Boolean> items = new HashMap<>();

        // Adds an item.
        // Returns false if the item already exists.
        public boolean add(String item){
            if(items.containsKey(item)){
                return false; // duplicate rejected
            }
            items.put(item, true);
            return true;
        }

        // Checks whether an item exists
        public boolean contains(String item){
            return items.containsKey(item);
        }

        // Returns the number of unique items
        public int size(){
            return items.size();
        }

        @Override
        public String toString() {
            return items.keySet().toString();
        }
    }

    
    // ------------------------------
    // 2. CUSTOM BAG (MULTISET) IMPLEMENTATION
    // ------------------------------

    static class SimpleBag{
        // key   = item
        // value = number of times the item appears
        private final Map<String, Integer> items = new HashMap<>();

        // Stores the total number of items,
        // including duplicates
        private int totalSize = 0;

        // Adds an item.
        // If it already exists, increase its count.
        public void add(String item){
            int currentCount = items.getOrDefault(item, 0);

            items.put(item, currentCount + 1);

            totalSize++;

        }
        // Returns how many times a specific item exists
        public int getCount(String item){
            return items.getOrDefault(item, 0);
        }

        // Returns total number of items,
        // including duplicates.
        public int size(){
            return totalSize;
        }

        @Override 
        public String toString(){
            return items.toString();
        }
    }





}


