package Main;

import java.sql.*;
import persistence.PeopleLoader;
import persistence.sql.SqlitePeopleLoader;
import view.persistence.HistogramDisplay;
import view.swing.SwingHistogramDisplay;
import model.Histogram;
import model.Person;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        PeopleLoader peopleLoader = new SqlitePeopleLoader(); // Cargador de personas
        Histogram<String> histogram = new Histogram();
        for(Person p : peopleLoader.load()){
            System.out.println("?"+p.getEmailDomain()+"?");
            histogram.increment(p.getEmailDomain());
        }
        HistogramDisplay histogramDisplay = new SwingHistogramDisplay("Prueba", histogram);
        histogramDisplay.execute();
    }
}
