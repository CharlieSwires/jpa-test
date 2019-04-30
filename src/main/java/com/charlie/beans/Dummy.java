package com.charlie.beans;

public class Dummy {

	private String name;
	private String description;
	private Integer actionId;
	private Integer appId;
	private Integer featureId;
	private Integer moduleId;
	
	public Dummy(String name, String description, Integer actionId, Integer appId, Integer featureId,
			Integer moduleId) {
		super();
		this.name = name;
		this.description = description;
		this.actionId = actionId;
		this.appId = appId;
		this.featureId = featureId;
		this.moduleId = moduleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getActionId() {
		return actionId;
	}
	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public Integer getFeatureId() {
		return featureId;
	}
	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}
	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

}
