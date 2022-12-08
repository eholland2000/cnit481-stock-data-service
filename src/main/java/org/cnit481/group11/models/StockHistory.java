package org.cnit481.group11.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK_HISTORY")
public class StockHistory extends PanacheEntityBase {
    private double afterHours;
    private double close;
    private double fromDate;
    private double high;
    private double low;
    private double open;
    private double preMarket;
    private String status;
    @Id private String symbol;
    private int volume;

    public StockHistory(double afterHours, double close, double fromDate, double high, double low, double open,
                       double preMarket, String status, String symbol, int volume) {
        this.afterHours = afterHours;
        this.close = close;
        this.fromDate = fromDate;
        this.high = high;
        this.low = low;
        this.open = open;
        this.preMarket = preMarket;
        this.status = status;
        this.symbol = symbol;
        this.volume = volume;
    }

    public StockHistory() {
    }

    public StockHistory(PolygonData polygonData) {
        this.afterHours = polygonData.getAfterHours();
        this.close = polygonData.getClose();
        this.fromDate = polygonData.getFrom();
        this.high = polygonData.getHigh();
        this.low = polygonData.getLow();
        this.open = polygonData.getOpen();
        this.preMarket = polygonData.getPreMarket();
        this.status = polygonData.getStatus();
        this.symbol = polygonData.getSymbol();
        this.volume = polygonData.getVolume();
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

    public double getFromDate() {
        return fromDate;
    }

    public void setFromDate(double fromDate) {
        this.fromDate = fromDate;
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
