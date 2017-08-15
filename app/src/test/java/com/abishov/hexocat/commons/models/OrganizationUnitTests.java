package com.abishov.hexocat.commons.models;

import com.abishov.hexocat.commons.models.Organization;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.fail;

@RunWith(JUnit4.class)
public class OrganizationUnitTests {

    @Test
    public void createMustThrowOnNullLogin() {
        try {
            Organization.create(null, "test_html_url");
            fail("NullPointerException was expected, but nothing was thrown.");
        } catch (NullPointerException nullPointerException) {
            // noop
        }
    }

    @Test
    public void createMustThrowOnNullHtmlUrl() {
        try {
            Organization.create("test_login", null);
            fail("NullPointerException was expected, but nothing was thrown.");
        } catch (NullPointerException nullPointerException) {
            // noop
        }
    }

    @Test
    public void equalsAndHashcodeMustConformToContract() {
        Organization organizationOne = Organization.create(
                "test_login", "test_html_url");
        Organization organizationTwo = Organization.create(
                "test_login", "test_html_url");

        assertThat(organizationOne).isEqualTo(organizationTwo);
        assertThat(organizationTwo).isEqualTo(organizationOne);
    }

    @Test
    public void propertiesMustBePropagatedCorrectly() {
        Organization organization = Organization.create(
                "test_login", "test_html_url");

        assertThat(organization.login()).isEqualTo("test_login");
        assertThat(organization.htmlUrl()).isEqualTo("test_html_url");
    }
}