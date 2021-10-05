public class Action {
    public static void actionSequence() {
        Message.msgWelcome();

        ActionDB.dbInsert("Tony", "Stark", "1001");
        ActionDB.dbInsert("Steve", "Roger", "1002");

        ActionDB.dbReadAllData();
        ActionDB.dbReadSpecificRow("firstName", "user", "id", "1001");

        ActionDB.dbUpdateFirstName();
        ActionDB.dbReadAllData();

        ActionDB.dbDeleteRow("1001");
        ActionDB.dbReadAllData();

        ActionDB.dbGetNumOfRow("id", "user");

        Message.msgBye();

    }
}
