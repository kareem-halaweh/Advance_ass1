package src.ass1.executer;

import src.ass1.executer.executerStrategy.DataJobStrategy;
import src.ass1.executer.executerStrategy.EmailJobStrategy;
import src.ass1.executer.executerStrategy.JobStrategy;
import src.ass1.executer.executerStrategy.ReportJobStrategy;



import java.util.HashMap;

import java.util.Map;

public class JobStrategyFactory {

    private static final Map<String , JobStrategy> strategies = new HashMap<>();

    static {
        strategies.put("EMAIL" , new EmailJobStrategy());
        strategies.put("DATA",   new DataJobStrategy());
        strategies.put("REPORT", new ReportJobStrategy());
    }


    public static JobStrategy getJobStrategy(String type) {
        if (type == null) return null;
        return strategies.get(type.toUpperCase());
    }



}