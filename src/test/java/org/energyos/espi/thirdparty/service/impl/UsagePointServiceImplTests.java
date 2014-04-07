package org.energyos.espi.thirdparty.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBException;

import org.energyos.espi.common.domain.RetailCustomer;
import org.energyos.espi.common.domain.UsagePoint;
import org.energyos.espi.common.repositories.UsagePointRepository;
import org.energyos.espi.common.service.impl.UsagePointServiceImpl;
import org.energyos.espi.thirdparty.utils.factories.Factory;
import org.junit.Before;
import org.junit.Test;

public class UsagePointServiceImplTests {

    private UsagePointRepository repository;
    private UsagePointServiceImpl service;

    @Before
    public void before() {
        service = new UsagePointServiceImpl();
        repository = mock(UsagePointRepository.class);
        service.setRepository(repository);
    }

    @Test
    public void findAllByRetailCustomer_returnsUsagePointList() throws JAXBException {
        List<UsagePoint> usagePointList = new ArrayList<>();
        when(repository.findAllByRetailCustomerId(any(Long.class))).thenReturn(usagePointList);
        RetailCustomer retailCustomer = new RetailCustomer();
        retailCustomer.setId(1L);

        assertEquals(usagePointList, service.findAllByRetailCustomer(retailCustomer));
    }

    @Test
    public void findById_returnsUsagePoint() throws JAXBException {
        UsagePoint usagePoint = Factory.newUsagePoint();

        when(repository.findById(any(Long.class))).thenReturn(usagePoint);

        assertEquals(usagePoint, service.findById(1L));
    }

    @Test
    public void findByUUID_returnsUsagePoint() throws JAXBException {
        UsagePoint usagePoint = Factory.newUsagePoint();

        when(repository.findByUUID(any(UUID.class))).thenReturn(usagePoint);

        assertEquals(usagePoint, service.findByUUID(usagePoint.getUUID()));
    }
}
