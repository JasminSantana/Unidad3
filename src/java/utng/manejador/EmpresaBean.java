/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.datos.EmpresaDAO;
import utng.datos.JefeDAO;
import utng.modelo.Empresa;
import utng.modelo.Jefe;

/**
 *
 * @author USUARIO
 */
@ManagedBean (name="empresaBean")
@SessionScoped
public class EmpresaBean implements Serializable{
     private List<Empresa> empresas;
    private Empresa empresa;
    private List<Jefe> jefes;

    public EmpresaBean() {
        empresa=new Empresa();
       empresa.setJefe(new Jefe());
    }

   

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    public Empresa getEmpresa() {
        return empresa;
    }
     public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
 public List<Jefe> getJefes() {
        return jefes;
    }

    public void setJefes(List<Jefe> jefes) {
        this.jefes = jefes;
    }
   
       public String listar(){
           EmpresaDAO dao=new EmpresaDAO();
        try{
            empresas=dao.getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return  "Empresas";
    }
    public String eliminar(){
     EmpresaDAO dao=new       EmpresaDAO();
        try{
            dao.delete(empresa);
            empresas=dao.getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return  "Eliminar";
    }
    
    public String iniciar(){
        empresa=new Empresa();
        empresa.setJefe(new Jefe());
        try{
            jefes=new JefeDAO().getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Iniciar";
    }
    public String guardar(){
    EmpresaDAO dao=new EmpresaDAO();
    try{
        if(empresa.getIdEmpresa()!=0){
            dao.update(empresa);
        }else{
            dao.insert(empresa);
        }
        empresas=dao.getAll();
    }catch(Exception e){
        e.printStackTrace();
    }
    return "Guardar";
}
    public String cancelar(){
    return "Cancelar";
    }
public String editar(Empresa empresa){
    this.empresa=empresa;
    try{
         jefes=new JefeDAO().getAll();
    }catch(Exception e){
        e.printStackTrace();
    }
    return "Editar";
}
 
    
}
