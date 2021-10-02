public class Action {
    public static void actionSequence() {
        Message.msgWelcome();
        ActionDB.insert("Tony", "Stark", "1001");
        ActionDB.insert("Steve", "Roger", "1002");
        Message.msgBye();
    }
}
