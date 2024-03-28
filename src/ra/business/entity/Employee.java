package ra.business.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Employee {
        private static int nextID = 1;
        private int id;
        private String fullName;
        private String address;
        private String phone;
        private LocalDate dateOfBirth;
        private Department department;
        private boolean status = true;

    public Employee() {
        this.id = nextID++;
    }

    public Employee(int id, String fullName, String address, String phone, LocalDate dateOfBirth, Department department, boolean status) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner, List<Department> departmentList){
        this.fullName = getInputEmployeeName(scanner);
        this.address = getInputAddress(scanner);
        this.phone = getInputPhone(scanner);
        this.dateOfBirth = getInputBirthDay(scanner);
        System.out.println("có chon phòng ban hay không ?");
        System.out.println("1. Có");
        System.out.println("2. Không");
        while (true){
            System.out.println("Nhap lựa chọn");
            byte choice = new Scanner(System.in).nextByte();
            switch (choice){
                case 1:
                    this.department = getInputDepartment(scanner,departmentList);
                    break;
                case 2:
                    this.department = null;
                    break;
                default:
                    System.err.println("ko hợp lệ, nhập lai");
            }
            if (choice==1 || choice ==2){
                break;
            }
        }


    }

    public String getInputEmployeeName(Scanner scanner){
        do {
            System.out.println("Nhập tên nhân viên");
            String inputEmployeeName = scanner.nextLine();
            if (!inputEmployeeName.trim().isEmpty()) {
                    return inputEmployeeName;
            } else {
                System.err.println("Không được để trống");
            }
        }while (true);
    }

    public String getInputAddress(Scanner scanner){
        do {
            System.out.println("Nhập địa chỉ nhân viên");
            String inputAddressName = scanner.nextLine();
            if (!inputAddressName.trim().isEmpty()) {
                return inputAddressName;
            } else {
                System.err.println("Không được để trống");
            }
        }while (true);
    }

    public String getInputPhone(Scanner scanner){
        do {
            System.out.println("Nhập số điện thoại nhân viên");
            String inputPhone = scanner.nextLine();
            if (!inputPhone.trim().isEmpty()) {
                if (Pattern.matches("^(03|05|07|08|09|01[2|6|8|9])+([0-9]{8})$",inputPhone)){
                    return inputPhone;
                }else{
                    System.err.println("Nhập không đúng,hãy nhâ lại");
                }

            } else {
                System.err.println("Không được để trống");
            }
        }while (true);
    }

    public LocalDate getInputBirthDay(Scanner scanner){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        while (true){
            System.out.println("Nhập vào ngày sinh dd-MM-yyyy");
            String employeeDateInput = scanner.nextLine();
            try {
                return LocalDate.parse(employeeDateInput,dtf);
            }catch (DateTimeParseException e){
                System.err.println("Khong dung dinh dang");
            }
        }
    }
    private Department getInputDepartment(Scanner scanner,List<Department> departmentList){
        // hiển thị danh sách phòng ban
        System.out.println("Danh sach phòng ban");
        for (int i = 0; i < departmentList.size(); i++) {
            System.out.printf("| STT : %d | Name : %-15s |\n",i+1,departmentList.get(i).getName());
        }
        while (true){
            System.out.println("Nhập vào vị trí phòng ban (theo STT)");
            int index = scanner.nextInt();
            if (index>=1 && index<= departmentList.size()){
                Department department1 = departmentList.get(index - 1);
                // tăng số nhân viên lên 1
                department1.setNumberEmployee(department1.getNumberEmployee()+1);
                return department1;
            }
            System.err.println("Vi tri nhap khong hơp lẹ, vui lòng chọn lại");
        }
    }
    public void displayEmployeeData(){
        System.out.printf("| ID : %-5s | Name : %-15s | Address : %-15s | Phone : %-15s | DoB : %-10s | Department : %-15s |\n",
                id,fullName,address,phone,dateOfBirth,department);
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
    }

}
