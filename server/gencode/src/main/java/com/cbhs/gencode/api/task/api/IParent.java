package com.cbhs.gencode.api.task.api;

import java.util.Iterator;

public interface  IParent {
	
	
	  public  Iterator<ILevelObj>   getChildren();
	  
	  public  void  add(ILevelObj  child);
	  

}
