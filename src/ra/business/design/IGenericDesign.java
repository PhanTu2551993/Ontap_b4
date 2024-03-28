package ra.business.design;

public interface IGenericDesign <T,E> {
    void displayAll();
    void addNew();
    void update();
    void changeStatus();
    T findById(E id);
}
