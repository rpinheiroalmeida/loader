package br.edu.loader.extractor;

import br.edu.loader.entity.Quotation;
import br.edu.loader.repository.QuotationRepository;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by rodrigo on 17/03/16.
 */
public class ExtractData {

    private static final ExtractData instance = new ExtractData();

    private ExtractData() {
    }

    public static ExtractData instance() {
        return instance;
    }

    public void loadData(String filePath) throws IOException {
        LineIterator lt = IOUtils.lineIterator(new FileReader(filePath));
        process(lt);
    }

    private void process(LineIterator lineIterator) {
        String line = "";
        for (LineIterator iterator = lineIterator; iterator.hasNext();) {
            line = iterator.nextLine();
            if (isLineQuotation(line)) {
                QuotationRepository loader =  new QuotationRepository();
                loader.save(getQuotation(line));
            }
        }
    }

    private Quotation getQuotation(String line) {

        return new Quotation()
                .withId(UUID.randomUUID())
                .withCode(line.substring(12, 23).trim())
                .withCompany( String.format("%s %s", line.substring(27, 38).trim(), line.substring(39, 47).trim()) )
                .withTradingDate(line.substring(2, 10))
                .withOpenPrice(line.substring(56, 69))
                .withMaxPrice(line.substring(69, 82))
                .withMinPrice(line.substring(82, 95))
                .withAveragePrice(line.substring(95, 108))
                .withLastPrice(line.substring(108, 121))
                .withTotalTrading(line.substring(147, 152))
                .withTotalVolume(line.substring(170, 188));
    }

    private boolean isLineQuotation(String line) {
        return line.startsWith("01");
    }
}


