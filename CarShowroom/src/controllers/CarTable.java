package controllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CarTable {
    public SimpleIntegerProperty vid = new SimpleIntegerProperty();
    public SimpleStringProperty brand = new SimpleStringProperty();
    public SimpleStringProperty model = new SimpleStringProperty();
    public SimpleStringProperty type = new SimpleStringProperty();
    public SimpleStringProperty colour = new SimpleStringProperty();
    public SimpleStringProperty astatus = new SimpleStringProperty();
    public SimpleIntegerProperty rprice = new SimpleIntegerProperty();
    public SimpleIntegerProperty sprice = new SimpleIntegerProperty();

    public int getVid() {
        return vid.get();
    }

    public SimpleIntegerProperty vidProperty() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid.set(vid);
    }

    public String getModel() {
        return model.get();
    }

    public SimpleStringProperty modelProperty() {
        return model;
    }

    public void setModel(String model) {
        this.model.set(model);
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getColour() {
        return colour.get();
    }

    public SimpleStringProperty colourProperty() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour.set(colour);
    }

    public String getAstatus() {
        return astatus.get();
    }

    public SimpleStringProperty astatusProperty() {
        return astatus;
    }

    public void setAstatus(String astatus) {
        this.astatus.set(astatus);
    }

    public int getRprice() {
        return rprice.get();
    }

    public SimpleIntegerProperty rpriceProperty() {
        return rprice;
    }

    public void setRprice(int rprice) {
        this.rprice.set(rprice);
    }

    public int getSprice() {
        return sprice.get();
    }

    public SimpleIntegerProperty spriceProperty() {
        return sprice;
    }

    public void setSprice(int sprice) {
        this.sprice.set(sprice);
    }

}
