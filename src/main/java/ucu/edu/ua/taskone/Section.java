package ucu.edu.ua.taskone;

public abstract class Section {
    private int denomination;
    private Section next;

    public Section(int denomination) {
        this.denomination = denomination;
    }
    public void setNext(Section section) {
        this.next = section;
    }
    public void process(int amount) {
        int remainingAmount = amount % denomination;
        
        if (next != null) {
            next.process(remainingAmount);
        } else if (remainingAmount > 0) {
            throw new IllegalArgumentException();
        }
        System.out.println("You received " + amount / denomination
        + " of denomination " + denomination);
    }
    
}
