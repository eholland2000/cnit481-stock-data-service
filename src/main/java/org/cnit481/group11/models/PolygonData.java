package org.cnit481.group11.models;

public class PolygonData {
    private double afterHours;
    private double close;
    private double from;
    private double high;
    private double low;
    private double open;
    private double preMarket;
    private String status;
    private String symbol;
    private int volume;

    public PolygonData(double afterHours, double close, double from, double high, double low, double open,
                       double preMarket, String status, String symbol, int volume) {
        this.afterHours = afterHours;
        this.close = close;
        this.from = from;
        this.high = high;
        this.low = low;
        this.open = open;
        this.preMarket = preMarket;
        this.status = status;
        this.symbol = symbol;
        this.volume = volume;
    }

    public PolygonData() {
    }

    public double getAfterHours() {
        return afterHours;
    }

    public void setAfterHours(double afterHours) {
        this.afterHours = afterHours;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getPreMarket() {
        return preMarket;
    }

    public void setPreMarket(double preMarket) {
        this.preMarket = preMarket;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

}
