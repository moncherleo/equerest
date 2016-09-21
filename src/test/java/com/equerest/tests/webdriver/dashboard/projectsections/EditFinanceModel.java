package com.equerest.tests.webdriver.dashboard.projectsections;

import com.equerest.tests.webdriver.dashboard.EditProjectOnDashboard1;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by aBulgakoff on 9/21/16.
 */
public class EditFinanceModel extends EditProjectOnDashboard1 {

    @Ignore
    @Test
    public void editFinanceModel() {
        selectedProject.editFinanceModel()
                .uploadFinancePlan("")
                .discardChanges()
                .editFinanceModel()
                .uploadFinancePlan("")
                .applyChanges();
    }
}
