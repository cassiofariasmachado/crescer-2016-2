/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.exercicios;

import br.com.cwi.crescer.aula3.dao.ClientDao;
import br.com.cwi.crescer.aula3.dao.ContractDao;
import br.com.cwi.crescer.aula3.entities.Client;
import br.com.cwi.crescer.aula3.entities.Contract;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author cfari
 */
public class ContractRun {

    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        ContractDao daoContract = new ContractDao(em);
        ClientDao daoClient = new ClientDao(em);

        Client client = new Client();

        client.setDsEmail("client@gmail.com");
        client.setDsPassword("123456");
        client.setDsPreferredCoin("Euro");
        client.setDsState("Brazil");
        client.setDsUserName("client99");
        client.setNmClient("Client");
        client.setTpPermission("admin");

        daoClient.insert(client);

        Contract contract = new Contract();

        contract.setDsDescription("description");
        contract.setDsState("state");
        contract.setDsWebsite("website");
        contract.setNmContract("contract");
        contract.setClient(daoClient.find(1L));

        daoContract.insert(contract);

        daoContract.list().forEach(c -> System.out.println(c.getIdContract() + " - " + c.getNmContract()));

        em.close();
        emf.close();
    }
}
