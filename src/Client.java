import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private static ArrayList<PhoneBook>  phoneBooksClient = PhoneBookData.saveFile;
    private static PhoneBookManager phoneBookManager = new PhoneBookManager();

    public static void main(String[] args) {



        int choice;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("_______ CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ _______");
            System.out.println("Chọn chức năng theo số ( để tiếp tục ): ");
            System.out.println("""
                    1. Xem danh sách.
                    2. Thêm mới.
                    3. Cập nhập.
                    4. Xóa.
                    5. Tìm kiếm.
                    6. Đọc từ file.
                    7. Ghi vào file.
                    8. Thoát.
                    Chọn chức năng :""");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    phoneBookManager.showContact();
                    break;
                case 2:
                    phoneBookManager.addNewContact();
                    break;
                case 3:
                    phoneBookManager.updateContactByNumber();
                    break;
                case 4:
                    phoneBookManager.deleteContactByPhoneNumber();
                    break;
                case 5:
                    Scanner input = new Scanner(System.in);
                    System.out.println("Chọn cách tìm kiếm.\n4.1 Theo số điện thoại.\n4.2 Theo họ và tên.");
                    int choice1 = input.nextInt();
                    switch (choice1){
                        case 1:
                            phoneBookManager.searchContactByPhoneNumber();
                            break;
                        case 2:
                            phoneBookManager.searchContactByName();
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Danh sách trong file là : ");
                    phoneBookManager.showReadFile();
                    break;
                case 7:
                    phoneBookManager.saveFile(phoneBooksClient);
                    System.out.println("Lưu file thành công.");
                    break;
                case 8:
                    choice = 0;
                    break;
            }
        } while (choice != 0);
    }
}
