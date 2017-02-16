
package com.vektorel.hrappe.service;

import java.util.List;

/**
 *
 * @author eaytac
 */
public interface IBaseService<T> {
        
    boolean save(T entity) throws Exception;
    
    boolean update(T entity) throws Exception;
    
    boolean delete(T entity) throws Exception;
    
    List<T> getAll(String query);
    
    T getById(Long id);
}
