package ra.business.entity;

import java.util.List;
import java.util.Scanner;

public class Department {
            private static int nextId = 1;
//            private static int nextnumber = 0;

            private int	id;
            private String	name;
            private int numberEmployee;
            private boolean status = true;

    public Department() {
        this.id = nextId++;
    }

    public Department(int id, String name, int numberEmployee, boolean status) {
        this.id = id;
        this.name = name;
        this.numberEmployee = numberEmployee;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberEmployee() {
        return numberEmployee;
    }

    public void setNumberEmployee(int numberEmployee) {
        this.numberEmployee = numberEmployee;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputDataDepartment(Scanner scanner,List<Department> departmentList){
           this.name = getDepartmentName(scanner,departmentList);
    }
    public String getDepartmentName(Scanner scanner, List<Department> departmentList){
        while (true){
            System.out.println("Nhập vào tên phòng ban");
            String departmentNameInput = scanner.nextLine();
            if (!departmentNameInput.isBlank()){
                // đúng định dạng -> kiểm tra trùng lặp
                if (departmentList.stream().noneMatch(t->t.getName().equals(departmentNameInput))){
                    // trùng lặp
                    return departmentNameInput;
                }
                System.err.println("Tên đã tồn tại, vui long nhập giá trị khác");
            }else {
                System.err.println("Không được để trống");
            }
        }
    }
    public void displayDepartmentData(){
        System.out.printf("| ID : %-5s | Name : %-15s | Number Employee : %-3s | Status : %-3b |\n",
                id,name,numberEmployee,status);
        System.out.println("------------------------------------------------------------------------");
    }

}
