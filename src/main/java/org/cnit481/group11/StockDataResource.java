package org.cnit481.group11;

import org.cnit481.group11.connections.UserServiceConnection;
import org.cnit481.group11.models.StockHistory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class StockDataResource {

    @Inject
    UserServiceConnection userService;
    @Inject
    StockDataProcessor stockDataProcessor;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    public String hello() {
        return "hello!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/fetch")
    public String fetchData() {
        List<StockHistory> polygonDataList;
        try {
            polygonDataList = stockDataProcessor.fetchAllStockData();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
        return "Records Updated: " + polygonDataList.size();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stocks")
    public List<StockHistory> getStocks() {
        List<StockHistory> polygonDataList;
        try {
            polygonDataList = stockDataProcessor.getAllStockData();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return polygonDataList;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/load/{symbol}")
    public String getStocks(@PathParam("symbol") String symbol) {
        try {
            if (stockDataProcessor.fetchStockData(symbol) != null) {
                return "Record Updated";
            } else {
                return "Error!";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stocks/{username}")
    public List<StockHistory> getStocksForUser(@PathParam("username") String username) {
        List<StockHistory> polygonDataList;
        try {
            polygonDataList = stockDataProcessor.getStockForUser(username);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return polygonDataList;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/health")
    public String getHealth() {
        if (userService.connected()) {
            return "health: good";
        } else {
            return "health: not connected to userService";
        }
    }
}