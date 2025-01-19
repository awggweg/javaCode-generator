package net.maku;
public class test {
    public static void main(String[] args) {
        String[] driverNames = {
                "com.mysql.cj.jdbc.Driver", // MySQL Connector/J 8.x
                "com.mysql.jdbc.Driver"     // MySQL Connector/J 5.x
        };

        for (String driverName : driverNames) {
            try {
                Class.forName(driverName);
                System.out.println("Successfully loaded driver: " + driverName);
            } catch (ClassNotFoundException e) {
                System.out.println("Failed to load driver: " + driverName);
            }
        }
    }
}