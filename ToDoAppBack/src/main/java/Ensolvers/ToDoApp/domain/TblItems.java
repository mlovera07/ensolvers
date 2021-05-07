package Ensolvers.ToDoApp.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tbl_items", catalog = "items", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblItems.findAll", query = "SELECT t FROM TblItems t"),
    @NamedQuery(name = "TblItems.findById", query = "SELECT t FROM TblItems t WHERE t.id = :id"),
    @NamedQuery(name = "TblItems.findByTask", query = "SELECT t FROM TblItems t WHERE t.task = :task"),
    @NamedQuery(name = "TblItems.findByIsDone", query = "SELECT t FROM TblItems t WHERE t.isDone = :isDone")})
public class TblItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 45)
    @Column(name = "task", length = 45)
    private String task;
    @Size(max = 45)
    @Column(name = "is_done", length = 45)
    private String isDone;

    public TblItems() {
    }

    public TblItems(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean getIsDone() {
        if(this.isDone == "false"){
          return false;  
        }else{
          return true;
        }
        
    }

    public void setIsDone(boolean isDone) {
        if(isDone){
            this.isDone = "true";
        }else{
            this.isDone = "false";
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblItems)) {
            return false;
        }
        TblItems other = (TblItems) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ensolvers.ToDoApp.domain.TblItems[ id=" + id + " ]";
    }
    
}
