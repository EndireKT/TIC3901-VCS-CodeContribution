public class Message {
    public static void msgWelcome() {
        System.out.println("Hello! Welcome to TIC3901 Project");
        System.out.println("_________________________________");
    }

    public static void msgDBInsert() {
        System.out.println("    Data has been inserted!");
        System.out.println("_________________________________");
    }

    public static void msgError(Exception e) {
        System.out.println(e.toString());
        System.out.println("_________________________________");
    }

    public static void msgBye() {
        System.out.println("Bye!");
        System.out.println("_________________________________");
    }
}
