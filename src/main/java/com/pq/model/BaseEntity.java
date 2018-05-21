package com.pq.model;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * 实体类基类 
 *
 */
@SuppressWarnings("serial")
@MappedSuperclass			//默认基类无表
public class BaseEntity implements java.io.Serializable{
	
	@Id
	@GeneratedValue(generator="generator_hilo")
	@GenericGenerator(name="generator_hilo", strategy = "org.hibernate.id.enhanced.TableGenerator"
						, parameters = {
							@Parameter(name = "table_name", value = "hibernate_sequences")
							, @Parameter(name = "prefer_entity_table_as_segment_value", value = "true")
						})
	@Column(name = "id", nullable = false)
	protected Integer id;
	
	@Override
	public String toString(){
		return (this.toString());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
