package org.energyos.espi.thirdparty.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.UUID;

import javax.xml.bind.JAXBException;

import org.energyos.espi.common.domain.MeterReading;
import org.energyos.espi.thirdparty.repository.MeterReadingRESTRepository;
import org.energyos.espi.thirdparty.utils.factories.Factory;
import org.junit.Before;
import org.junit.Test;

public class MeterReadingServiceImplTests {

    private MeterReadingRESTRepository repository;
    private MeterReadingRESTServiceImpl service;

    @Before
    public void before() {
        service = new MeterReadingRESTServiceImpl();
        repository = mock(MeterReadingRESTRepository.class);
        service.setRepository(repository);
    }

    @Test
    public void findByUUID_returnsMeterReading() throws JAXBException {
        MeterReading meterReading = Factory.newMeterReading();

        when(repository.findByUUID(eq(1L), any(UUID.class))).thenReturn(meterReading);

        assertEquals(meterReading, service.findByUUID(1L, UUID.randomUUID()));
    }
}
