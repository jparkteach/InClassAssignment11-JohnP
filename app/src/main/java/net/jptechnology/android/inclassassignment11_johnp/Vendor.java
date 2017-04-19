package net.jptechnology.android.inclassassignment11_johnp;

public class Vendor {

    public String id;
    public String name;
    public String info;
    public int logoId;
    public boolean freeShip;
    public boolean pickupAvailable;
    public double exchangeRateEuro;
    public double exchangeRateReal;
    public double exchangeRateYen;
    public double exchangeRateYuon;
    public double exchangeRateWon;

    public Vendor(String id, String name, String info, int logoId, boolean freeShip, boolean pickupAvailable, double exchangeRateEuro, double exchangeRateReal, double exchangeRateYen, double exchangeRateYuon, double exchangeRateWon) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.logoId = logoId;
        this.freeShip = freeShip;
        this.pickupAvailable = pickupAvailable;
        this.exchangeRateEuro = exchangeRateEuro;
        this.exchangeRateReal = exchangeRateReal;
        this.exchangeRateYen = exchangeRateYen;
        this.exchangeRateYuon = exchangeRateYuon;
        this.exchangeRateWon = exchangeRateWon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getLogoId() {
        return logoId;
    }

    public void setLogoId(int logoId) {
        this.logoId = logoId;
    }

    public boolean isFreeShip() {
        return freeShip;
    }

    public void setFreeShip(boolean freeShip) {
        this.freeShip = freeShip;
    }

    public boolean isPickupAvailable() {
        return pickupAvailable;
    }

    public void setPickupAvailable(boolean pickupAvailable) {
        this.pickupAvailable = pickupAvailable;
    }

    public double getExchangeRateEuro() {
        return exchangeRateEuro;
    }

    public void setExchangeRateEuro(double exchangeRateEuro) {
        this.exchangeRateEuro = exchangeRateEuro;
    }

    public double getExchangeRateReal() {
        return exchangeRateReal;
    }

    public void setExchangeRateReal(double exchangeRateReal) {
        this.exchangeRateReal = exchangeRateReal;
    }

    public double getExchangeRateYen() {
        return exchangeRateYen;
    }

    public void setExchangeRateYen(double exchangeRateYen) {
        this.exchangeRateYen = exchangeRateYen;
    }

    public double getExchangeRateYuon() {
        return exchangeRateYuon;
    }

    public void setExchangeRateYuon(double exchangeRateYuon) {
        this.exchangeRateYuon = exchangeRateYuon;
    }

    public double getExchangeRateWon() {
        return exchangeRateWon;
    }

    public void setExchangeRateWon(double exchangeRateWon) {
        this.exchangeRateWon = exchangeRateWon;
    }
}
