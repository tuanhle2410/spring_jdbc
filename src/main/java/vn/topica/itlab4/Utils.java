package vn.topica.itlab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class contains methods:
 * -to parse a String into Date
 * -to read a file to a String
 *
 * @author AnhLT14(anhlt14@topica.edu.vn)
 */
public class Utils {

    /**
     * This method converts a String into Date
     * @param s the string input
     * @return  a Date
     * @throws ParseException Signals that an error has been reached unexpectedly while parsing
     */
    public static Date stringToDate(String s) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(s);
        return date;
    }

    /**
     * This method reads a csv file to a String
     *
     * @param FILE_PATH_IN the input file path
     * @return a string
     * @throws IOException Signals that an I/O exception of some sort has occurred
     */
    public static String fileToString(String FILE_PATH_IN) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH_IN));
        StringBuilder sb = new StringBuilder();
        String line = null;
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            sb.append(line);
            sb.append(ls);
        }
        // delete the last new line separator
        sb.deleteCharAt(sb.length() - 1);
        reader.close();
        String contentInput = sb.toString();
        return contentInput;
    }
}
