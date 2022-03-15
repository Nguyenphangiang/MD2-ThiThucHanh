import java.util.ArrayList;
import java.util.Scanner;
public class PhoneBookManager {

    IPhoneBookData iPhoneBookData = new PhoneBookData();
    public static ArrayList<PhoneBook> phoneBooks = PhoneBookData.saveFile;
    public void searchContactByPhoneNumber(){
        Scanner input = new Scanner(System.in);
        System.out.println("Mời bạn nhập số điện thoại người muốn tìm : ");
        String searchPhoneNumber = input.nextLine();
        if (isPhoneNumber(searchPhoneNumber)){
            System.out.println(phoneBooks.get(getIndexByPhoneNumber(searchPhoneNumber)));
        } else {
            System.out.println("Không có số điện thoại đó trong danh sách.");
        }
    }
    public void searchContactByName(){
        Scanner input = new Scanner(System.in);
        System.out.println("Mời bạn nhập họ và tên người muốn tìm : ");
        String searchName = input.nextLine();
        if (isContactName(searchName)){
            System.out.println(phoneBooks.get(getIndexByName(searchName)));
        } else {
            System.out.println("Không có tên trong danh sách.");
        }
    }
    public void showContact(){
        for (PhoneBook phoneBook : phoneBooks){
            System.out.println(phoneBook);
        }
    }
    public void addNewContact(){
        phoneBooks.add(creatNewContact());
        try {
            iPhoneBookData.writeFile(phoneBooks);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteContactByPhoneNumber(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số điện thoại bạn muốn xóa : ");
        String inputPhoneNumber = input.nextLine();
        if (isPhoneNumber(inputPhoneNumber)){
            Scanner input1 = new Scanner(System.in);
            System.out.println("Nhấn phim 'y' để xóa.");
            String accept = input1.nextLine();
            if (accept.equals("y")){
                phoneBooks.remove(getIndexByPhoneNumber(inputPhoneNumber));
            }
        } else {
            System.out.println("Không có số điện thoại đó.");
        }
    }
    public void updateContactByNumber(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số điện thoại bạn muốn cập nhập : ");
        String inputPhoneNumber = input.nextLine();
        if (isPhoneNumber(inputPhoneNumber)){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Mời bạn nhập nhóm mới: ");
            String newGroup = scanner.nextLine();
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Mời bạn nhập họ tên mới : ");
            String newName = scanner1.nextLine();
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Mời bạn nhập giới tính: ");
            String newGender = scanner2.nextLine();
            Scanner scanner3 = new Scanner(System.in);
            System.out.println("Mời bạn nhập địa chỉ mới : ");
            String newAddress = scanner3.nextLine();
            Scanner scanner4 = new Scanner(System.in);
            System.out.println("Mời bạn nhập ngày tháng năm sinh: ");
            String newDateOfBirth = scanner4.nextLine();
            Scanner scanner5 = new Scanner(System.in);
            System.out.println("Mời bạn nhập email mới : ");
            String newEmail = scanner5.nextLine();
            phoneBooks.get(getIndexByPhoneNumber(inputPhoneNumber)).setGroup(newGroup);
            phoneBooks.get(getIndexByPhoneNumber(inputPhoneNumber)).setName(newName);
            phoneBooks.get(getIndexByPhoneNumber(inputPhoneNumber)).setGender(newGender);
            phoneBooks.get(getIndexByPhoneNumber(inputPhoneNumber)).setAddress(newAddress);
            phoneBooks.get(getIndexByPhoneNumber(inputPhoneNumber)).setDateOfBirth(newDateOfBirth);
            phoneBooks.get(getIndexByPhoneNumber(inputPhoneNumber)).setEmail(newEmail);
            try {
                iPhoneBookData.writeFile(phoneBooks);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else
            System.out.println("Không có số điện thoại này.");


    }
    public boolean isContactName(String name){
        for (int i = 0; i < phoneBooks.size(); i++) {
            if (phoneBooks.get(i).getName().equals(name)){
                return true;
            }
        } return false;
    }
    public int getIndexByName(String name){
        int index = -1;
        for (int i = 0; i < phoneBooks.size(); i++) {
            if (phoneBooks.get(i).getName().equals(name)){
                index = i ;
                return index;
            } else return index;
        } return index;
    }
    public boolean isPhoneNumber(String phoneNumber){
        for (int i = 0; i < phoneBooks.size(); i++) {
            if (phoneBooks.get(i).getPhoneNumber().equals(phoneNumber)){
                return true;
            }
        } return false;
    }
    public int getIndexByPhoneNumber(String phoneNumber){
        int index = -1;
        for (int i = 0; i < phoneBooks.size(); i++) {
            if (phoneBooks.get(i).getPhoneNumber().equals(phoneNumber)){
               index = i;
               return index;
            } else return index;
        } return index;
    }
    public PhoneBook creatNewContact(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập số điện thoại : ");
        String phoneNumber = scanner.nextLine();
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Mời bạn nhập nhóm : ");
        String group = scanner1.nextLine();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Mời bạn nhập họ và tên : ");
        String name = scanner2.nextLine();
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Mời bạn nhập giới tính : ");
        String gender = scanner3.nextLine();
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Mời bạn nhập địa chỉ : ");
        String address = scanner4.nextLine();
        Scanner scanner5 = new Scanner(System.in);
        System.out.println("Mời bạn nhập ngày tháng năm sinh : ");
        String dateOfBirth = scanner5.nextLine();
        Scanner scanner6 = new Scanner(System.in);
        System.out.println("Mời bạn nhập địa chỉ email : ");
        String email = scanner6.nextLine();
        PhoneBook newContact = new PhoneBook(phoneNumber,group,name,gender,address,dateOfBirth,email);
        return newContact;
    }
    public void showReadFile(){
        System.out.println(iPhoneBookData.readFile());
    }
    public void saveFile(ArrayList<PhoneBook> phoneBooks){
        try {
            iPhoneBookData.writeFile(phoneBooks);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
