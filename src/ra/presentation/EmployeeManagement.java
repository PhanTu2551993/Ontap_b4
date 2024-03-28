package ra.presentation;
import ra.business.design.IEmployeeDesign;
import ra.business.designImpl.EmployeeImplement;

import java.util.Scanner;

public class EmployeeManagement {
     static IEmployeeDesign employeeDesign = new EmployeeImplement();

    public void displayEmployeeMenu() {
        while (true) {
            System.out.println("================Employee Menu===================");
            System.out.println("1- Hiển thị tất cả nhân viên (phân trang) \n" +
                    "2- Thêm mới nhân viên\n" +
                    "3- Sửa thông tin nhân viên\n" +
                    "4- Thay đổi trạng thái nhân viên\n" +
                    "5- Danh sách nhân viên theo phòng ban \n"+
                    "6- Sắp xếp nhân viên theo tên tăng dần \n"+
                    "7- Quay lại ");

            System.out.println("Nhập lựa chọn");
            byte choice = new Scanner(System.in).nextByte();
            switch (choice) {
                case 1:
                    employeeDesign.displayAll();
                    break;
                case 2:
                    employeeDesign.addNew();
                    break;
                case 3:
                    employeeDesign.update();
                    break;
                case 4:
                    employeeDesign.changeStatus();
                    break;
                case 5:
                    employeeDesign.sortName();
                    break;
                case 6:
                    return;
                default:
                    System.err.println("Nhap lua chon ko chinh xác");
            }
        }
    }
}
