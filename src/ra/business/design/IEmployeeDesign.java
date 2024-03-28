package ra.business.design;

import ra.business.entity.Employee;

public interface IEmployeeDesign  extends IGenericDesign<Employee,Integer> {
    void sortName();
}
