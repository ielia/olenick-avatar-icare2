package com.olenick.avatar.icare2.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * Report tab.
 */
public class ReportTabSpec implements Cloneable {
    @NotNull
    private ReportTab tab;
    @Null
    private String filter; // "View By" inside. This should be somewhere else.

    public ReportTabSpec() {}

    public ReportTabSpec(@NotNull final ReportTab tab, @Null final String filter) {
        this.tab = tab;
        this.filter = filter;
    }

    public ReportTab getTab() {
        return tab;
    }

    public void setTab(@NotNull final ReportTab tab) {
        this.tab = tab;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(@Null final String filter) {
        this.filter = filter;
    }

    @Override
    @SuppressWarnings("super")
    public ReportTabSpec clone() {
        return new ReportTabSpec(this.tab, this.filter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReportTabSpec reportTabSpec = (ReportTabSpec) o;

        if (filter != null ? !filter.equals(reportTabSpec.filter)
                : reportTabSpec.filter != null) {
            return false;
        }
        if (tab != null ? !tab.equals(reportTabSpec.tab)
                : reportTabSpec.tab != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = tab != null ? tab.hashCode() : 0;
        result = 31 * result + (filter != null ? filter.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReportTab{");
        sb.append("tab='").append(tab).append('\'');
        sb.append(", filter='").append(filter).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
