package screen;

public class HomeScreen {

    public static void open(){
        sayHello();

        provideOptions();
    }

    private static void provideOptions() {
        System.out.println("What would you like to do today?\n"+
                """
                        (1) Add item to to-do list
                        (2) Update status of item
                        (3) Complete Item
                        (4) Delete item from list
                        
                        """);
    }

    private static void sayHello() {
        System.out.println("Welcome to BinaryToDoList!");
    }
}
