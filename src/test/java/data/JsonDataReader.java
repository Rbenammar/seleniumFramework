package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader
{
    public String firstname, lastname, email, phoneNumber, password;

    public void JsonReader() throws IOException, ParseException {
        String filePath = System.getProperty("user.dir")+"/src/test/java/data/UserData.JSON";
        File srcFile = new File(filePath);
        JSONParser parser = new JSONParser(); // parse all the content of the JSON File

        JSONArray jarray = (JSONArray)parser.parse(new FileReader(srcFile));
        // Jarray it will go inside the file and parse (read) all the values inside the json

        for (Object jsonObj : jarray)
        {
            JSONObject person = (JSONObject) jsonObj;
            firstname = (String) person.get("firstname");
            System.out.println(firstname);
            lastname = (String) person.get("lastname");
            System.out.println(lastname);
            email = (String) person.get("email");
            System.out.println(email);
            phoneNumber = (String) person.get("phoneNumber");
            System.out.println(phoneNumber);
            password = (String) person.get("password");
            System.out.println(password);



        }

    }


}
