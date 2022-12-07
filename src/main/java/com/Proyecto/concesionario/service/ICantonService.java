package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Canton;
import java.util.List;

public interface ICantonService {
    public List<Canton> getAllCanton();
    public void saveCanton(Canton canton);
    public Canton getCantonById (long id);
    public void delete (long id);
}
