package br.com.uaijug.leonidas.model.service;

import java.io.Serializable;
import java.util.List;

public interface BusinessService<E, ID extends Serializable> {
    E save(E e);
    
    E create(E e);
    
    E update(Long id,E e);
  
    List<E> list();

    E findById(ID id);

    void delete(Long id);
}
