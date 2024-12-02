package ucu.edu.ua.taskone;

import lombok.Getter;
import lombok.Setter;

public class ATM {
    @Getter
    @Setter
    private Section firstSection;
    public ATM() {
        Section sectionhundred = new Sectionhundred();
        Section sectionfifty = new Sectionfifty();
        Section sectiontwo = new Sectiontwo();
        
        firstSection = sectionhundred;
        sectionhundred.setNext(sectionfifty);
        sectionfifty.setNext(sectiontwo);
    }
    public void process(int amount) {
        firstSection.process(amount);
    }
}
