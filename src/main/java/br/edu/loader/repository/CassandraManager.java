package br.edu.loader.repository;

import br.edu.loader.entity.Quotation;
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
    {
        easyCassandraManager = new EasyCassandraManager(ClusterInformation.create().addHost("localhost").withKeySpace("javabahia"));
        easyCassandraManager.addFamilyObject(Quotation.class);
        persistence = easyCassandraManager.getPersistence();
    }

    public Persistence getPersistence() {
        return persistence;
    }

}
