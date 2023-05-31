public class GClass<E> {
    private E element;
    public E getElement() {
        return element;
    }
    public void setElement(E element) {
        this.element = element;
    }
    public String toString(){
        return "GClass has "+this.element.toString();
    }
    public void print(){
        System.out.print(this);
    }
    public void println(){
        this.print();
        System.out.println();
    }
}
