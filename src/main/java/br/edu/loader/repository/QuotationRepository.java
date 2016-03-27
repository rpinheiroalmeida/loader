package br.edu.loader.repository;

import br.edu.loader.entity.Quotation;
import br.edu.loader.util.DateUtil;
import org.easycassandra.persistence.cassandra.Persistence;
import org.easycassandra.persistence.cassandra.SelectBuilder;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by rodrigo on 16/03/16.
 */
public class QuotationRepository {

    private Persistence persistence = CassandraManager.INSTANCE.getPersistence();

    public void save(Quotation quotation) {
        System.out.println(String.format("Salvando Quotation [%s]", quotation.toString()));
        persistence.insert(quotation);
    }

    public List<Quotation> findByIndex(String code) {
        return persistence.findByIndex("code", code, Quotation.class);
    }

    public List<Quotation> findAll() {
        return persistence.findAll(Quotation.class);
    }

    public  List<Quotation> listByCode(String code) {
        return  persistence.findByIndex(code, Quotation.class);
    }

    public List<Quotation> listByDate(String code, Date date) {

        SelectBuilder<Quotation> select = persistence.selectBuilder(Quotation.class);
        select.eq("code", code).eq("tradingdate", date).allowFiltering();
        return select.execute();
    }

    public Quotation getMostRecent(String code) throws Exception {

        SelectBuilder<Quotation> select = persistence.selectBuilder(Quotation.class);
        select.eq("code", code);

        List<Quotation> quotations = select.execute();
        Date mostRecentDate = new GregorianCalendar(1945,1,0).getTime();//DateUtil.convert2Date("1965-01-01");
        Quotation mostRecentQuotation = null;

        for (Quotation quotation : quotations) {
            if (quotation.getTradingDate().compareTo(mostRecentDate) >= 0) {
                mostRecentQuotation = quotation;
            }
        }
        return mostRecentQuotation;
    }
}
