import java.sql.*;

public class RestaurantJDBC {

    static final String URL  = "jdbc:mysql://localhost:3306/restaurant_db";
    static final String USER = "root";
    static final String PASS = "sit123";

    // ─── Connection ───────────────────────────────────────────────────────────

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String serverUrl = "jdbc:mysql://localhost:3306/";
        try (Connection sc = DriverManager.getConnection(serverUrl, USER, PASS);
             Statement  st = sc.createStatement()) {
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS restaurant_db");
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // ─── DDL ──────────────────────────────────────────────────────────────────

    public static void createTables(Connection con) throws Exception {
        try (Statement st = con.createStatement()) {
            st.executeUpdate("DROP TABLE IF EXISTS MenuItem");
            st.executeUpdate("DROP TABLE IF EXISTS Restaurant");

            st.executeUpdate(
                "CREATE TABLE Restaurant (" +
                "  Id      INT PRIMARY KEY, " +
                "  Name    VARCHAR(255), " +
                "  Address VARCHAR(255))");

            st.executeUpdate(
                "CREATE TABLE MenuItem (" +
                "  Id    INT PRIMARY KEY, " +
                "  Name  VARCHAR(255), " +
                "  Price DOUBLE, " +
                "  ResId INT, " +
                "  FOREIGN KEY (ResId) REFERENCES Restaurant(Id))");

            System.out.println("Tables created successfully.");
        }
    }

    // ─── INSERT (10 records each) ─────────────────────────────────────────────

    public static void insertData(Connection con) throws Exception {
        String insR = "INSERT INTO Restaurant VALUES (?, ?, ?)";
        String insM = "INSERT INTO MenuItem   VALUES (?, ?, ?, ?)";

        Object[][] restaurants = {
            {1,  "Cafe Java",       "101 Main St"},
            {2,  "Pizza Palace",    "202 Oak Ave"},
            {3,  "Burger Joint",    "303 Pine Rd"},
            {4,  "The Pasta Place", "404 Elm St"},
            {5,  "Taco Corner",     "505 Maple Dr"},
            {6,  "Sub Shop",        "606 Cedar Ln"},
            {7,  "Sushi World",     "707 Birch Blvd"},
            {8,  "Steakhouse",      "808 Walnut St"},
            {9,  "Vegan Bites",     "909 Cherry Way"},
            {10, "Breakfast Club",  "1010 Ash Ct"}
        };

        Object[][] menuItems = {
            {101, "Coffee",  50.0,  1},
            {102, "Tea",     40.0,  1},
            {103, "Pastry", 120.0,  1},
            {104, "Pizza",  250.0,  2},
            {105, "Burger",  80.0,  3},
            {106, "Pasta",  180.0,  4},
            {107, "Taco",    60.0,  5},
            {108, "Pancake", 90.0, 10},
            {109, "Salad",  110.0,  9},
            {110, "Steak",  500.0,  8}
        };

        try (PreparedStatement ps1 = con.prepareStatement(insR);
             PreparedStatement ps2 = con.prepareStatement(insM)) {

            for (Object[] r : restaurants) {
                ps1.setInt(1, (Integer) r[0]);
                ps1.setString(2, (String) r[1]);
                ps1.setString(3, (String) r[2]);
                ps1.executeUpdate();
            }

            for (Object[] m : menuItems) {
                ps2.setInt(1, (Integer) m[0]);
                ps2.setString(2, (String) m[1]);
                ps2.setDouble(3, (Double)  m[2]);
                ps2.setInt(4, (Integer) m[3]);
                ps2.executeUpdate();
            }
        }
        System.out.println("Inserted 10 records into each table.");
    }

    // ─── DISPLAY ALL ─────────────────────────────────────────────────────────

    public static void displayAllRestaurants(Connection con) throws Exception {
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM Restaurant ORDER BY Id")) {
            System.out.println("\nAll Restaurants:");
            System.out.printf("%-5s %-20s %-30s%n", "ID", "Name", "Address");
            System.out.println("─".repeat(57));
            while (rs.next()) {
                System.out.printf("%-5d %-20s %-30s%n",
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getString("Address"));
            }
        }
    }

    public static void displayAllMenuItems(Connection con) throws Exception {
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM MenuItem ORDER BY Id")) {
            System.out.println("\nAll Menu Items:");
            printMenu(rs);
        }
    }

    // ─── SELECT: Price <= 100 ────────────────────────────────────────────────

    public static void selectPriceLessThanOrEqual100(Connection con) throws Exception {
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(
                     "SELECT * FROM MenuItem WHERE Price <= 100 ORDER BY Id")) {
            System.out.println("\nMenu Items with Price <= 100:");
            printMenu(rs);
        }
    }

    // ─── SELECT: Items from Cafe Java ────────────────────────────────────────

    public static void selectCafeJavaItems(Connection con) throws Exception {
        String query =
            "SELECT m.* FROM MenuItem m " +
            "JOIN Restaurant r ON m.ResId = r.Id " +
            "WHERE r.Name = 'Cafe Java'";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            System.out.println("\nMenu Items available in 'Cafe Java':");
            printMenu(rs);
        }
    }

    // ─── UPDATE: Price <= 100 → Price = 200 ──────────────────────────────────

    public static void updatePrice(Connection con) throws Exception {
        try (Statement st = con.createStatement()) {
            int rows = st.executeUpdate(
                    "UPDATE MenuItem SET Price = 200 WHERE Price <= 100");
            System.out.println("\nUpdated " + rows + " row(s): Price <= 100 set to 200.");
        }
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM MenuItem ORDER BY Id")) {
            System.out.println("\nMenu Items After Update:");
            printMenu(rs);
        }
    }

    // ─── DELETE: Name starts with 'P' ────────────────────────────────────────

    public static void deleteItemsStartingWithP(Connection con) throws Exception {
        try (Statement st = con.createStatement()) {
            int rows = st.executeUpdate(
                    "DELETE FROM MenuItem WHERE Name LIKE 'P%'");
            System.out.println("\nDeleted " + rows + " row(s) where Name starts with 'P'.");
        }
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM MenuItem ORDER BY Id")) {
            System.out.println("\nMenu Items After Deletion:");
            printMenu(rs);
        }
    }

    // ─── Helper: print MenuItem ResultSet ────────────────────────────────────

    public static void printMenu(ResultSet rs) throws Exception {
        System.out.printf("%-5s %-15s %-10s %-10s%n", "ID", "Name", "Price", "ResId");
        System.out.println("─".repeat(45));
        boolean hasRows = false;
        while (rs.next()) {
            hasRows = true;
            System.out.printf("%-5d %-15s %-10.2f %-10d%n",
                    rs.getInt("Id"),
                    rs.getString("Name"),
                    rs.getDouble("Price"),
                    rs.getInt("ResId"));
        }
        if (!hasRows) System.out.println("(No records found)");
    }

    // ─── Main ─────────────────────────────────────────────────────────────────

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║   Restaurant JDBC Application    ║");
        System.out.println("╚══════════════════════════════════╝\n");

        try {
            System.out.println(">> Connecting to MySQL...");
            Connection con = getConnection();
            System.out.println("   Connected successfully!\n");

            // DDL
            System.out.println(">> Creating Tables...");
            createTables(con);

            // INSERT
            System.out.println("\n>> Inserting Data...");
            insertData(con);
            displayAllRestaurants(con);
            displayAllMenuItems(con);

            // SELECT – Price <= 100
            System.out.println("\n>> SELECT: Menu Items with Price <= 100");
            selectPriceLessThanOrEqual100(con);

            // SELECT – Cafe Java
            System.out.println("\n>> SELECT: Items from Cafe Java");
            selectCafeJavaItems(con);

            // UPDATE
            System.out.println("\n>> UPDATE: Set Price = 200 where Price <= 100");
            updatePrice(con);

            // DELETE
            System.out.println("\n>> DELETE: Remove items whose Name starts with 'P'");
            deleteItemsStartingWithP(con);

            System.out.println("\n╔══════════════════════════════════╗");
            System.out.println("║   Program completed successfully ║");
            System.out.println("╚══════════════════════════════════╝");

            con.close();

        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
