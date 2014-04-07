/*
 * Copyright 2013 EnergyOS.org
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.energyos.espi.thirdparty.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.energyos.espi.common.domain.ApplicationInformation;
import org.energyos.espi.common.service.ApplicationInformationService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

public class DataCustodianListControllerTests {

    protected DataCustodianListController controller;
    private ApplicationInformationService applicationInformationService;

    @Before
    public void before() {
        controller = new DataCustodianListController();
        applicationInformationService = mock(ApplicationInformationService.class);
        controller.setApplicationInformationService(applicationInformationService);
    }

    @Test
    public void index_displaysIndexView() throws Exception {
        assertEquals("/RetailCustomer/DataCustodianList/index", controller.index(new ModelMap()));
    }

    @Test
    public void index_setsApplicationInformationListModel() throws Exception {
        List<ApplicationInformation> applicationInformationList = new ArrayList<>();
        when(applicationInformationService.findAll()).thenReturn(applicationInformationList);
        ModelMap model = new ModelMap();

        controller.index(model);

        assertSame(applicationInformationList, model.get("applicationInformationList"));
    }
}
