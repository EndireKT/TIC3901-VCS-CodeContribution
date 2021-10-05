public class Message {
    public static void msgWelcome() {
        System.out.println("Hello! Welcome to TIC3901 Project");
        System.out.println("----------------------------------");
    }

    public static void msgConnection() {
        System.out.println("Connected!");
        System.out.println("----------------------------------");
    }

    public static void msgDBInsert() {
        System.out.println("    Data has been inserted!");
        System.out.println("----------------------------------");
    }

    public static void msgDBPrUserRow(String lastName, String firstName, String id) { // temporary for database tutorial
        System.out.println("Query for entire row:");
        System.out.println("    lastName: " + lastName);
        System.out.println("    firstName: " + firstName);
        System.out.println("    id: " + id);
        System.out.println("----------------------------------");
    }

    public static void msgDBPrUserRow(String selectFrom, String fromTable, String where, String whereEqualsTo,
            String result) {
        System.out.println("Query for specified row:");
        System.out.println("    << SELECT " + selectFrom + " FROM " + fromTable);
        System.out.println("        WHERE " + where + " = " + whereEqualsTo + " >>");
        System.out.println("    result: " + result);
        System.out.println("----------------------------------");

    }

    // Database Related

    public static void msgConnection() {
        System.out.println("Connected!");
        System.out.println("----------------------------------");
    }

    public static void msgDBInsert() {
        System.out.println("    Data has been inserted!");
        System.out.println("----------------------------------");
    }

    public static void msgDBPrUserRow(String lastName, String firstName, String id) { // temporary for database tutorial
        System.out.println("    Query for entire row:");
        System.out.println("    lastName: " + lastName);
        System.out.println("    firstName: " + firstName);
        System.out.println("    id: " + id);
        System.out.println("----------------------------------");
    }

    public static void msgDBPrUserRow(String selectFrom, String fromTable, String where, String whereEqualsTo,
            String result) {
        System.out.println("    Query for specified row:");
        System.out.println("    << SELECT " + selectFrom + " FROM " + fromTable);
        System.out.println("        WHERE " + where + " = " + whereEqualsTo + " >>");
        System.out.println("    result: " + result);
        System.out.println("----------------------------------");
    }

    public static void msgDBUpdate() {
        System.out.println("    Data has been updated!");
        System.out.println("----------------------------------");
    }

    public static void msgDBDelete() {
        System.out.println("    One Row has been deleted!");
        System.out.println("----------------------------------");
    }

    public static void msgDBNumOfRow(int num) {
        System.out.println("    Row Count: " + num);
        System.out.println("----------------------------------");
    }
}
