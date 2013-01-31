package com.pwf.mvcme;

import java.util.Collection;

/**
 *
 * @author mfullen
 */
interface ViewFramework
{
    <E extends View<?>> E getView(Class<E> type);

    View<?> getView(String name);

    void register(View<?> view);

    void unregister(View<?> view);

    Collection<View<?>> getAll();
}
