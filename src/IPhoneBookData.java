import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface IPhoneBookData {
    ArrayList<PhoneBook>readFile();
    void writeFile(ArrayList<PhoneBook> phoneBooks) throws Exception;
}
