package com.ltlogic.db.superentity;



import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;

import org.joda.time.LocalDateTime;

@MappedSuperclass
public class SuperEntity implements SuperEntityInterface {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "pk", unique = true, nullable = false)
	    protected long pk;
	    
	    protected LocalDateTime rowUpdatedTimestamp;

	    @Override
	    public long getPk() {
	        return pk;
	    }

	    @Override
	    public void setPk(long pk) {
	        this.pk = pk;
	    }
	    
	    @Override
	    public String toString() {
	        return this.getClass().getSimpleName() + " [ pk = " + pk + " ]";
	    }
	    
	    public String originalToString() {
	        return super.toString();
	    }

	    @Override
	    public LocalDateTime getRowUpdatedTimestamp() {
	        return rowUpdatedTimestamp;
	    }

	    @Override
	    public void setRowUpdatedTimestamp(LocalDateTime rowUpdatedTimestamp) {
	        this.rowUpdatedTimestamp = rowUpdatedTimestamp;
	    }
	    
	    @PreUpdate
	    private void onUpdate(){
	        this.rowUpdatedTimestamp = new LocalDateTime();
	    }
	
}
