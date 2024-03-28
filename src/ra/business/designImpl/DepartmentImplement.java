package ra.business.designImpl;
import ra.business.design.IDepartmentDesign;
import ra.business.entity.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentImplement implements IDepartmentDesign {
    static List<Department> departmentList = new ArrayList<>();

    @Override
    public void displayAll() {
        if (departmentList.isEmpty()){
            System.err.println("Danh sach trống");
        }else {
            departmentList.forEach(Department::displayDepartmentData);
        }
    }

    @Override
    public void addNew() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng phòng ban muốn thêm");
        byte count  = Byte.parseByte(scanner.nextLine());
        for (int i = 1; i <= count ; i++) {
            System.out.println("Nhập thông tin cho phòng ban thứ"+i);
            Department department = new Department();
            department.inputDataDepartment(scanner,departmentList);
            departmentList.add(department);
        }
        System.out.println("Đã them moi thanh cong ");
    }

    @Override
    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy chọn department muốn update");
        int id = Integer.parseInt(scanner.nextLine());
        Department edit = findById(id);
        if (edit==null){
            System.err.println("id không tim thấy");
            return;
        }
        System.out.println("Thong tin cũ là ");
        edit.displayDepartmentData();
        // yêu cầu nhập thông tin mới
        System.out.println("Hãy nhap thong tin mơi ");
        edit.inputDataDepartment(scanner,departmentList);
        System.out.println("Cập nhật thành công");
    }
    @Override
    public void changeStatus() {
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập ID phòng ban");
            int inputId = Integer.parseInt(scanner.nextLine());
            boolean check = false;
            for (int i = 0; i < departmentList.size(); i++) {
                if (departmentList.get(i).getId() == inputId) {
                        check =true;
                        if (departmentList.get(i).isStatus()) {
                            departmentList.get(i).setStatus(false);
                            System.out.println("Đã cập nhật trạng thái mã ("+inputId+ ") chuyển sang : false");
                        } else {
                            departmentList.get(i).setStatus(true);
                            System.out.println("Đã cập nhật trạng thái mã ("+inputId+ ") chuyển sang : true");
                        }
                        break;
                    }
                }
                if (!check){
                    System.out.println("ID không có ");
                }else {
                    break;
                }
        }while (true);
    }

    @Override
    public Department findById(Integer id) {
        for (Department d : departmentList){
            if (d.getId() == id)
                return d;
        }
        return null;

    }
    @Override
    public void searchDepartmentName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên phòng ban cần tìm:");
        String inputName = scanner.nextLine();
        boolean checkName = false;
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getName().equals(inputName)){
                departmentList.get(i).displayDepartmentData();
                checkName= true;
            }
        }if (!checkName){
            System.out.println("Không co phòng ban với tên cần tìm");
        }
    }
}
