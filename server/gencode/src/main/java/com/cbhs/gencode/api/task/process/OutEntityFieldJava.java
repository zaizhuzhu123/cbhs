package com.cbhs.gencode.api.task.process;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cbhs.gencode.api.task.api.ILevelObj;
import com.cbhs.gencode.api.task.entity.FieldObj;
import com.cbhs.gencode.api.task.entity.FileImpl;
import com.cbhs.gencode.api.task.entity.ProtoObj;

public class OutEntityFieldJava extends  AbstractProcess{
	
	private   BufferedWriter  bw=null;

	private  static  final  String   DIR=File.separator+"0.gen_code\\base_api\\src\\main\\java\\com\\yqt\\api\\static_";
	
	private   List<String>  beanNames=new ArrayList();
	
	public   OutEntityFieldJava(String  targetDir) throws IOException{
		  File    direc=new File(targetDir+DIR);
		  if(!direc.exists()){
			  direc.mkdir();
		  }		  
		  String  targetFile=targetDir+DIR+File.separator+"YqtClass.java";		
          File  sqlFile=new File(targetFile);		  
		  if(!sqlFile.exists()){			  
			  sqlFile.createNewFile();			  
		  }
		  this.bw=new BufferedWriter( new OutputStreamWriter(new FileOutputStream(sqlFile),"UTF-8"));
	}
	
	
	public  void   finish()   throws Exception {
		
		bw.newLine();
		
		//生成所有实体的名字引用常量类。
		bw.newLine();		
		bw.write("    public   static  final  class BeanNames  {");		
		for(String  bName:beanNames){
			bw.newLine();
			bw.write("    	public  static   final String  "+bName+"=\""+bName+"\";");			
		}				 		
		bw.newLine();
		bw.write("    }" );
		
		
		bw.newLine();
		bw.write("}" );
		this.bw.close();
	}
	
	
	public Iterator<ILevelObj> processFile(final FileImpl ifile,int index) throws Exception {
		
		
		if(index==0){			
			bw.write("package com.yqt.api.static_;" );
			bw.newLine();
			bw.write("public class YqtClass {" );
			bw.newLine();			
		}				
		
		
		return super.processFile(ifile, index);
	}
	
	
	@Override
	public Iterator<ILevelObj> processProto(ProtoObj proto,int index) throws Exception {	
		
		    beanNames.add(proto.toString());
			bw.write("    public   static  final  class "+proto.toString()+"  {" );
			bw.newLine();	
			return super.processProto(proto,index);
	}	
		
	@Override
	public void endProto(ProtoObj proto) throws Exception {
				
		bw.write("    }");
		bw.newLine();			
	}	

	@Override
	public Iterator<ILevelObj> processFiled(FieldObj field,int index) throws Exception {
		
		bw.write("        public  static  final  String   "+field.getFieldName()+"=\""+field.getFieldName()+"\";" );
		bw.newLine();	
		
		return  super.processFiled(field,index);
		
	}
	
	
	
	
	


	

}