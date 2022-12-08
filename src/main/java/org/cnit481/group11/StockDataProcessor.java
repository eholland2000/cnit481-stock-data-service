package org.cnit481.group11;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import org.cnit481.group11.connections.PolygonConnection;
import org.cnit481.group11.models.StockHistory;
import org.cnit481.group11.models.UserStock;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class StockDataProcessor {
    @Inject
    PolygonConnection polygon;

    public List<StockHistory> fetchAllStockData() {
        List<StockHistory> polygonDataList = new ArrayList<>();
        PanacheQuery<String> query = UserStock.find("select symbol from USER_STOCK u group by u.symbol").project(String.class);
        for (String symbol : query.list()) {
            System.out.println(symbol);
            polygonDataList.add(new StockHistory(polygon.retrieveDataFromPolygon(symbol, Date.from(Instant.now()))));
        }
        StockHistory.persist(polygonDataList);
        return polygonDataList;
    }

    public StockHistory fetchStockData(String symbol) {
        StockHistory stockHistory = new StockHistory(polygon.retrieveDataFromPolygon(symbol, Date.from(Instant.now())));
        StockHistory.persist(stockHistory);
        return stockHistory;
    }

    public List<StockHistory> getAllStockData() {
        return StockHistory.listAll();
    }

    public List<StockHistory> getStockForUser(String username) {
        List<UserStock> userStockList = UserStock.list("username", username);
        List<StockHistory> stockHistoryList = new ArrayList<>();
        for (UserStock userStock : userStockList) {
            stockHistoryList.add(StockHistory.findById(userStock.getStockSymbol()));
        }
        return stockHistoryList;
    }

}
