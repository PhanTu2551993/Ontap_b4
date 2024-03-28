package ra.business.designImpl;
import ra.business.design.IEmployeeDesign;
import ra.business.entity.Department;
import ra.business.entity.Employee;
import java.util.*;

import static ra.business.designImpl.DepartmentImplement.departmentList;

public class EmployeeImplement implements IEmployeeDesign {
    static List<Employee> employeeList = new ArrayList<>();


    @Override
    public void displayAll() {
        if (employeeList.isEmpty()){
            System.err.println("Danh sach trống");
        }else {
            employeeList.forEach(Employee::displayEmployeeData);
        }
    }

    @Override
    public void addNew() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng nhân viên ban muốn thêm");
        byte count  = Byte.parseByte(scanner.nextLine());
        for (int i = 1; i <= count ; i++) {
            System.out.println("Nhập thông tin cho nhân viên thứ"+i);
            Employee employee = new Employee();
            employee.inputData(scanner,departmentList);
            employeeList.add(employee);
        }
        System.out.println("Đã them moi thanh cong ");
    }

    @Override
    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy chọn nhân viên muốn cập nhật");
        int id = Integer.parseInt(scanner.nextLine());
        Employee edit = findById(id);
        if (edit==null){
            System.err.println("id không tim thấy");
            return;
        }
        System.out.println("Thong tin cũ là ");
        edit.displayEmployeeData();
        // yêu cầu nhập thông tin mới
        System.out.println("Hãy nhap thong tin mơi ");
        edit.inputData(scanner,departmentList);
        System.out.println("Cập nhật thành công");
    }

    @Override
    public void changeStatus() {
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập ID nhân viên");
            int inputId = Integer.parseInt(scanner.nextLine());
            boolean check = false;
            for (int i = 0; i < employeeList.size(); i++) {
                if (employeeList.get(i).getId() == inputId) {
                    check =true;
                    if (employeeList.get(i).isStatus()) {
                        employeeList.get(i).setStatus(false);
                        System.out.println("Đã cập nhật trạng thái mã ("+inputId+ ") chuyển sang : false");
                    } else {
                        employeeList.get(i).setStatus(true);
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
    public Employee findById(Integer id) {
        for (Employee e : employeeList){
            if (e.getId() == id)
                return e;
        }
        return null;

    }

    @Override
    public void sortName() {
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getFullName))
                .forEach(Employee::displayEmployeeData);
    }
}

