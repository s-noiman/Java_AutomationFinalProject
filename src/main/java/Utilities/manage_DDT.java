package Utilities;

import io.qameta.allure.Step;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class manage_DDT {

    @Step("Get node data from Data_config.xml file")
    public static String get_data(String nodeName) {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try
        {
            fXmlFile = new File("./Configuration/Data_config.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch (Exception e)
        {
            System.out.println("Error Reading XML file: " + e);
        }
        finally
        {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }
}
