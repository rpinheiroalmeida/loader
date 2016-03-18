package br.edu.loader;

import br.edu.loader.repository.QuotationRepository;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
//        Loader.INSTANCE.loaderFile("/home/rodrigo/workspace/bmfbovespa-ws/src/main/resources/COTAHIST_A2014.TXT");
        System.out.print(new QuotationRepository().findAll());
    }
}
