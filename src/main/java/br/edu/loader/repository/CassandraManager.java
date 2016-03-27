package br.edu.loader.repository;

import br.edu.loader.entity.Quotation;
import br.edu.loader.util.PropertiesUtil;
import org.easycassandra.persistence.cassandra.ClusterInformation;
import org.easycassandra.persistence.cassandra.EasyCassandraManager;
import org.easycassandra.persistence.cassandra.Persistence;

/**
 * Created by rodrigo on 16/03/16.
 */
public enum CassandraManager {

    INSTANCE;
    private EasyCassandraManager easyCassandraManager;
    private Persistence persistence;

    public static final String LOADER_ADDRESS_SERVER = "loader.address.server";

    {
        easyCassandraManager = new EasyCassandraManager(ClusterInformation.create().addHost(
                PropertiesUtil.INSTANCE.getProperty(LOADER_ADDRESS_SERVER)
        ).withKeySpace("bmfbovespa"));

        easyCassandraManager.addFamilyObject(Quotation.class);
        persistence = easyCassandraManager.getPersistence();
    }

    public Persistence getPersistence() {
        return persistence;
    }

}
