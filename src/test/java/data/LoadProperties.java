package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

    //Load the properties file from the folder

    public static Properties userData = loadProperties(System.getProperty("user.dir") + "/src/main/java/properties/userData.properties");

    //Load SauceLabs Account Data

    public static Properties sauceLabsData = loadProperties(System.getProperty("user.dir") + "/src/main/java/properties/saucelabsUser.properties");


    private static Properties loadProperties(String path)
    {
        Properties pro = new Properties();
        //stream for reading file
        try {
            FileInputStream stream = new FileInputStream(path);
            pro.load(stream);

        } catch (FileNotFoundException e) {
            System.out.println("Error occurred "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Error input output exception "+e.getMessage());

        }
        return pro;

    }

}
