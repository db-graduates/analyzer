package db.com.analyzer.message;

import com.cf.data.model.poloniex.PoloniexChartData;

import java.util.List;

public class Message {

    List<PoloniexChartData> chartDataList;

    public Message(List<PoloniexChartData> chartDataList) {
        this.chartDataList = chartDataList;
    }

    public List<PoloniexChartData> getChartDataList() {
        return chartDataList;
    }

    public void setChartDataList(List<PoloniexChartData> chartDataList) {
        this.chartDataList = chartDataList;
    }


    @Override
    public String toString() {
        return "Message{" +
                "chartDataList=" + chartDataList +
                '}';
    }
}
