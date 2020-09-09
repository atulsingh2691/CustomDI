package com.di.framework.module;

/**
 * Module interface to configure dependency injection mapping.
 *
 */
public interface IModule {

    void configure();

    <T> Class<? extends T> getMapping(Class<T> type);
}
