import java.io.*;
import java.util.ArrayList;

public class PhoneBookData implements IPhoneBookData {

    public static final String SAVE_FILE = "data/contacts.csv";
    public static PhoneBookData phoneBookData = new PhoneBookData();
    public static ArrayList<PhoneBook> saveFile = phoneBookData.readFile();

    @Override
    public ArrayList<PhoneBook> readFile() {
        ArrayList<PhoneBook> temp = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(SAVE_FILE);
            ois = new ObjectInputStream(fis);
            Object result = ois.readObject();
            temp = (ArrayList<PhoneBook>) result;
            fis.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Loading file....");
        }
        return  temp;
    }

    @Override
    public void writeFile(ArrayList<PhoneBook> phoneBooks) throws Exception {
        FileOutputStream fos = new FileOutputStream(SAVE_FILE);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(phoneBooks);
        oos.close();
        fos.close();
    }
}
