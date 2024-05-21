package com.example.focus;

import java.util.Vector;

public class AddictionManager {
    private Vector<Addiction> hm;
    public void addAddiction( Addiction name ){
        hm.add(name);
    }
    public void deleteAddiction(Addiction name ) {
        hm.remove(name);
    }
    public void editAddiction(Addiction name ) {
    }
    public void displayAddiction( Addiction name) {

    }
    public Vector<Addiction>getAllAddictions() {
        return hm;
    }
    public void show_all_data(){}
   /* public Addiction selectAddiction(Addiction name){
        Addiction h  = new Addiction();
        for(int i = 0 ;i < hm.size(); i++ ){
            if(hm.get(i)==name){
                return hm.get(i);
            }
        }
        return h;
    }*/
}
