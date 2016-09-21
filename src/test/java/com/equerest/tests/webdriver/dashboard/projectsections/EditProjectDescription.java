package com.equerest.tests.webdriver.dashboard.projectsections;

import com.equerest.tests.webdriver.dashboard.EditProjectOnDashboard1;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by aBulgakoff on 9/21/16.
 */
public class EditProjectDescription extends EditProjectOnDashboard1 {

    @Ignore
    @Test
    public void editProjectDescription() {
        selectedProject.editProjectDescription()
                .editText("Промежуточное описание")
                .discardChanges()
                .editProjectDescription()
                .editText("Новый проект")
                .applyChanges();
    }
}
