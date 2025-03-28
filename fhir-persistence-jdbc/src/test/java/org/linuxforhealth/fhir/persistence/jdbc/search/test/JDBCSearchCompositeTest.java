/*
 * (C) Copyright IBM Corp. 2018, 2022
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.linuxforhealth.fhir.persistence.jdbc.search.test;

import org.linuxforhealth.fhir.config.FHIRConfigProvider;
import org.linuxforhealth.fhir.persistence.FHIRPersistence;
import org.linuxforhealth.fhir.persistence.jdbc.test.util.PersistenceTestSupport;
import org.linuxforhealth.fhir.persistence.search.test.AbstractSearchCompositeTest;
import org.linuxforhealth.fhir.search.util.SearchHelper;


public class JDBCSearchCompositeTest extends AbstractSearchCompositeTest {

    // Container to hide the instantiation of the persistence impl used for tests
    private PersistenceTestSupport testSupport;

    @Override
    public void bootstrapDatabase() throws Exception {
        testSupport = new PersistenceTestSupport();
    }

    @Override
    public FHIRPersistence getPersistenceImpl(FHIRConfigProvider configProvider, SearchHelper searchHelper) throws Exception {
        return testSupport.getPersistenceImpl(configProvider, searchHelper);
    }

    @Override
    protected void shutdownPools() throws Exception {
        if (testSupport != null) {
            testSupport.shutdown();
        }
    }
}