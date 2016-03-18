package br.edu.loader.repository;

import br.edu.loader.entity.Quotation;
import org.easycassandra.persistence.cassandra.Persistence;

import javax.mail.Quota;
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
}
