/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.exercicios;

import br.com.cwi.crescer.aula3.dao.ClientDao;
import br.com.cwi.crescer.aula3.entities.Client;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author cfari
 */
public class ClientRun {

    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        ClientDao dao = new ClientDao(em);
        
        Client client = new Client();

        client.setDsEmail("client@gmail.com");
        client.setDsPassword("123456");
        client.setDsPreferredCoin("Euro");
        client.setDsState("Brazil");
        client.setDsUserName("client99");
        client.setNmClient("Client");
        client.setTpPermission("admin");

        dao.insert(client);

        dao.list().forEach(c -> System.out.println(c.getIdClient() + " - " + c.getNmClient()));
        
        dao.exportToCsv("arquivo.csv");
        
        em.close();
        emf.close();
    }
}
