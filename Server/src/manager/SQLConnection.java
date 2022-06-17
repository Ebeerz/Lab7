package manager;

import Org.*;
import java.sql.*;
import java.util.TreeSet;

public class SQLConnection {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "postgres";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/studs";
    private static Connection connection;

    public static void ConnectionToDB() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    public static void get_values() throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_GET_VALUES = "select * from product";
        ResultSet result = statement.executeQuery(SQL_GET_VALUES);
        while(result.next()) {
            Product product = new Product();
            product.setId(result.getLong(1));
            product.setName(result.getString(2));
            Coordinates coordinates = new Coordinates();
            coordinates.setX(result.getInt(3));
            coordinates.setY(result.getDouble(4));
            product.setCoordinates(coordinates);
            product.setCreationDate(result.getTimestamp(5).toLocalDateTime());
            product.setPrice(result.getLong(6));
            product.setPartNumber(result.getString(7));
            product.setManufactureCost(result.getDouble(8));
            product.setUnitOfMeasure(UnitOfMeasure.valueOf(result.getString(9)));
            Organization organization = new Organization();
            organization.setId(result.getInt(10));
            organization.setName(result.getString(11));
            organization.setName(result.getString(11));
            organization.setFullName(result.getString(12));
            organization.setAnnualTurnover(result.getFloat(13));
            organization.setType(OrganizationType.valueOf(result.getString(14)));
            Address address = new Address();
            address.setStreet(result.getString(15));
            organization.setOfficialAddress(address);
            product.setManufacturer(organization);
            product.setUser(result.getString(16));
            ProductCollection.add(product);
        }

    }

    public static void set_values() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("TRUNCATE product");
            TreeSet<Product> productCollection = ProductCollection.getCollection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into product values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            productCollection.stream().forEach(x -> {
                try {
                    preparedStatement.setLong(1, x.getId());
                    preparedStatement.setString(2, x.getName());
                    preparedStatement.setInt(3, x.getCoordinates().getX());
                    preparedStatement.setDouble(4, x.getCoordinates().getY());
                    preparedStatement.setTimestamp(5, Timestamp.valueOf(x.getCreationDate()));
                    preparedStatement.setLong(6, x.getPrice());
                    preparedStatement.setString(7, x.getPartNumber());
                    preparedStatement.setDouble(8, x.getManufactureCost());
                    preparedStatement.setString(9, x.getUnitOfMeasure().toString());
                    preparedStatement.setInt(10, x.getManufacturer().getId());
                    preparedStatement.setString(11, x.getManufacturer().getName());
                    preparedStatement.setString(12, x.getManufacturer().getFullName());
                    preparedStatement.setFloat(13, x.getManufacturer().getAnnualTurnover());
                    preparedStatement.setString(14, x.getManufacturer().getType().toString());
                    preparedStatement.setString(15, x.getManufacturer().getOfficialAddress().getStreet());
                    preparedStatement.setString(16, x.getUser());
                    preparedStatement.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Boolean userExist(String user, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(" select * from userdb where name = ? and password= ?");
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                return true;
            } else return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static Boolean alreadyUserExist(String user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(" select * from userdb where name = ?");
            preparedStatement.setString(1, user);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                return true;
            } else return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Integer getNewId() {
        try {
            Statement statement = connection.createStatement();
            ResultSet result= statement.executeQuery("SELECT nextval('id')");
            if (result.next()) {
                return result.getInt(1);
            } else return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Boolean addNewUser(String user, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into userdb values (?,?)");
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }


}
