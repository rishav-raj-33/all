package com.glowTemp.com.Resources;

public class MetaData {
	
private	String fileName;
 private String imageName;
 private String originalSize;
 private String dimension;
 private String imageTpe;
 private String lastModifiedDate;
public MetaData() {
	
}
public MetaData(String fileName, String imageName, String originalSize, String dimension, String imageTpe,
		String lastModifiedDate) {
	super();
	this.fileName = fileName;
	this.imageName = imageName;
	this.originalSize = originalSize;
	this.dimension = dimension;
	this.imageTpe = imageTpe;
	this.lastModifiedDate = lastModifiedDate;
}
public String getFileName() {
	return fileName;
}
public void setFileName(String fileName) {
	this.fileName = fileName;
}
public String getImageName() {
	return imageName;
}
public void setImageName(String imageName) {
	this.imageName = imageName;
}
public String getOriginalSize() {
	return originalSize;
}
public void setOriginalSize(String originalSize) {
	this.originalSize = originalSize;
}
public String getDimension() {
	return dimension;
}
public void setDimension(String dimension) {
	this.dimension = dimension;
}
public String getImageTpe() {
	return imageTpe;
}
public void setImageTpe(String imageTpe) {
	this.imageTpe = imageTpe;
}
public String getLastModifiedDate() {
	return lastModifiedDate;
}
public void setLastModifiedDate(String lastModifiedDate) {
	this.lastModifiedDate = lastModifiedDate;
}


}
