package com.jonas.backendtodolist.projection;

public interface TaskByToDoListProjection {
    
    Long getId();
    
    String getTitle();
    
    String getContent();
    
    Integer getTask_Status(); 
    
    String getDate_Initial();
    
}
