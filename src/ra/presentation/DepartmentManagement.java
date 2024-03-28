package ra.presentation;
import ra.business.design.IDepartmentDesign;
import ra.business.designImpl.DepartmentImplement;

import java.util.Scanner;
public class DepartmentManagement {
     static IDepartmentDesign departmentDesign = new DepartmentImplement();

    public void displayDepartmentMenu() {
        while (true) {
            System.out.println("================Department Menu===================");
            System.out.println("1- Hiển thị tất cả phòng ban \n" +
                    "2- Thêm mới phòng ban\n" +
                    "3- Sửa thông tin phòng ban \n" +
                    "4- Tìm kiếm phòng ban theo tên \n" +
                    "5- Thay đổi trạng thái phòng ban \n" +
                    "6- Quay lại ");

            System.out.println("Nhập lựa chọn");
            byte choice = new Scanner(System.in).nextByte();
            switch (choice) {
                case 1:
                    departmentDesign.displayAll();
                    break;
                case 2:
                    departmentDesign.addNew();
                    break;
                case 3:
                    departmentDesign.update();
                    break;
                case 4:
                    departmentDesign.searchDepartmentName();
                    break;
                case 5:
                    departmentDesign.changeStatus();
                    break;
                case 6:
                    return;
                default:
                    System.err.println("Nhap lua chon ko chinh xác");
            }
        }
    }
}
