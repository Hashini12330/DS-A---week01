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


    }

}
