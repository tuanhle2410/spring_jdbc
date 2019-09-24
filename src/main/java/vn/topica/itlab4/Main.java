package vn.topica.itlab4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.text.ParseException;

/**
 * This class is to execute.
 *
 * @author AnhLT14(anhlt14@topica.edu.vn)
 */
public class Main {
    private static final String FILE_PATH_IN = ".//src//files//people.csv";

    /**
     * This main method execute inserting data from a csv file into DB
     * @param args
     * @throws ParseException Signals that an error has been reached unexpectedly while parsing
     * @throws IOException Signals that an I/O exception of some sort has occurred
     */
    public static void main(String[] args) throws ParseException, IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        PeopleDAO peopleDAO = (PeopleDAO) context.getBean("people");

        String contentInput = Utils.fileToString(FILE_PATH_IN);
        String[] arr = contentInput.split("[\r\n]+");

        System.out.println("------Records Created--------" );
        for(int i=0; i<arr.length; i++){
            String[] arrInput = arr[i].split(",");
            peopleDAO.create(Integer.parseInt(arrInput[0]), arrInput[1], Utils.stringToDate(arrInput[2]),Integer.parseInt(arrInput[3]));
        }
    }
}
