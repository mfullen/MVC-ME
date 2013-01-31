package com.pwf.mvcme;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mfullen
 */
abstract class AbstractMapManager<N extends NameProperty> implements
        Manager<N>
{
    private Map<String, N> nameToNMap = new HashMap<String, N>();

    public void add(N item)
    {
        this.nameToNMap.put(item.getName(), item);
    }

    public void remove(N item)
    {
        this.nameToNMap.remove(item.getName());
    }

    public N get(String name)
    {
        return this.nameToNMap.get(name);
    }

    public Collection<N> getAll()
    {
        return this.nameToNMap.values();
    }
}
