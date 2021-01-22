package com.kovalivlesia.services;

import com.kovalivlesia.RepoBasedTest;
import com.kovalivlesia.repository.Repos;
import lombok.extern.java.Log;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Log
public class VanServiceTest extends RepoBasedTest {

    @Test
    public void testService() {
        log.info("AddSecondVan");
        Integer expected = Repos.getVanRepo().getAll().size() + 1;
        Repos.getVanRepo().add(Repos.getVanRepo().getAll().get(0));

        assertEquals(java.util.Optional.of(expected), java.util.Optional.of(Repos.getVanRepo().getAll().size()));
    }

    @Test
    public void testSort() {
        VanService vanService = new VanService();
        vanService.sort(Repos.getVanRepo().getAll().get(0));
        vanService.printVans(Repos.getVanRepo().getAll());
    }

    @Test
    public void testFind() {
        VanService vanService = new VanService();
        assertEquals(
                Repos.getVanRepo().getAll().get(0).getCoffees().size(),
                vanService.find(Repos.getVanRepo().getAll().get(0), null, null).size()
        );
    }
}
