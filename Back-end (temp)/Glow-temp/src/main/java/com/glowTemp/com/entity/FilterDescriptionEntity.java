package com.glowTemp.com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FilterDescriptionEntity {
	
	
	@Id
	private Integer id;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	private String filterName;
	private String filterDescription;
	private String filterImagePath;
	
	
	
	public FilterDescriptionEntity(Integer id, String filterName, String filterDescription, String filterImagePath) {
		super();
		this.id = id;
		this.filterName = filterName;
		this.filterDescription = filterDescription;
		this.filterImagePath = filterImagePath;
	}
	
	public FilterDescriptionEntity() {
	}
	
	public String getFilterName() {
		return filterName;
	}
	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
	public String getFilterDescription() {
		return filterDescription;
	}
	public void setFilterDescription(String filterDescription) {
		this.filterDescription = filterDescription;
	}
	public String getFilterImagePath() {
		return filterImagePath;
	}
	public void setFilterImagePath(String filterImagePath) {
		this.filterImagePath = filterImagePath;
	}

	
	
}
