package com.autos.web.Serviceimp;

import com.autos.web.Dao.AutomovilDao;
import com.autos.web.Entity.Automovil;
import com.autos.web.Service.AutomovilService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AutomovilServiceImp implements AutomovilService {

    private final AutomovilDao automovilDao;

    public AutomovilServiceImp(AutomovilDao automovilDao) {
        this.automovilDao = automovilDao;
    }

    @Override
    public List<Automovil> listarTodos() {
        return automovilDao.findAll();
    }

    @Override
    public List<Automovil> filtrarAutomoviles(String marca, String modelo, String clase, String color, Integer anio) {
        return automovilDao.filtrarAutomoviles(marca, modelo, clase, color, anio);
    }

    @Override
    public List<String> listarMarcas() {
        return automovilDao.listarMarcas();
    }

    @Override
    public List<String> listarModelos(String marca) {
        return automovilDao.listarModelos(marca);
    }

    @Override
    public List<String> listarClases(String marca, String modelo) {
        return automovilDao.listarClases(marca, modelo);
    }

    @Override
    public List<String> listarColores(String marca, String modelo, String clase) {
        return automovilDao.listarColores(marca, modelo, clase);
    }

    @Override
    public List<Integer> listarAnios(String marca, String modelo, String clase, String color) {
        return automovilDao.listarAnios(marca, modelo, clase, color);
    }
}
