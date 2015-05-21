package com.olenick.avatar.icare2.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Provider Filter.
 */
public class ProviderFilter implements Cloneable {
    private ProviderGrouping grouping;
    private List<String> groupingElements;
    private List<String> providers;

    public ProviderGrouping getGrouping() {
        return grouping;
    }

    public void setGrouping(ProviderGrouping grouping) {
        this.grouping = grouping;
    }

    public List<String> getGroupingElements() {
        return groupingElements;
    }

    public void setGroupingElements(String... groupingElements) {
        this.groupingElements = Arrays.asList(groupingElements);
    }

    public void setGroupingElements(List<String> groupingElements) {
        this.groupingElements = groupingElements;
    }

    public List<String> getProviders() {
        return providers;
    }

    public void setProviders(String... providers) {
        this.providers = Arrays.asList(providers);
    }

    public void setProviders(List<String> providers) {
        this.providers = providers;
    }

    @Override
    @SuppressWarnings("super")
    public ProviderFilter clone() {
        ProviderFilter clone = new ProviderFilter();
        clone.setGrouping(this.grouping);
        if (this.groupingElements != null) {
            clone.setGroupingElements(new ArrayList<>(this.groupingElements));
        }
        if (this.providers != null) {
            clone.setProviders(new ArrayList<>(this.providers));
        }
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ProviderFilter that = (ProviderFilter) o;

        if (grouping != that.grouping)
            return false;
        if (groupingElements != null ? !groupingElements
                .equals(that.groupingElements) : that.groupingElements != null)
            return false;
        if (providers != null ? !providers.equals(that.providers)
                : that.providers != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = grouping != null ? grouping.hashCode() : 0;
        result = 31 * result
                + (groupingElements != null ? groupingElements.hashCode() : 0);
        result = 31 * result + (providers != null ? providers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProviderFilter{");
        sb.append("grouping=").append(grouping);
        sb.append(", groupingElements=").append(groupingElements);
        sb.append(", providers=").append(providers);
        sb.append('}');
        return sb.toString();
    }
}
