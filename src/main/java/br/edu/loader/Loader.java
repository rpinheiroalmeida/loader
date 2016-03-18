package br.edu.loader;

import br.edu.loader.extractor.ExtractData;

import java.io.IOException;

/**
 * Created by rodrigo on 16/03/16.
 */
public enum Loader {

    INSTANCE;

    public void loaderFile(String path) throws IOException {
        ExtractData.instance().loadData(path);
    }

}
