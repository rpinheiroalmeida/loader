package br.edu.loader;

import br.edu.loader.repository.QuotationRepository;
import br.edu.loader.util.PropertiesUtil;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Hello world!
 *
 */


public class App 
{
    public static void main( String[] args ) throws Exception {
//        Loader.INSTANCE.loaderFile(PropertiesUtil.INSTANCE.getProperty("loader.file"));
        System.out.print(new QuotationRepository().findAll());

        System.out.println(new QuotationRepository().listByCode("ABEV3"));
        System.out.println(new QuotationRepository().listByDate("ABEV3", new GregorianCalendar(2014,1,2).getTime() ));
        System.out.println( new QuotationRepository().getMostRecent("ABEV3") );
    }
}
