public class Action {
    public static void actionSequence() {
        Message.msgWelcome();
        // ActionDB.dbInsert("Tony", "Stark", "1001");
        // ActionDB.dbInsert("Steve", "Roger", "1002");
        ActionDB.dbReadAllData();
        ActionDB.dbReadSpecificRow("firstName", "user", "id", "1001");
        Message.msgBye();
    }
}
