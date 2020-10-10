package xml;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlProcesser {

	public static void init(){
		SAXReader saxReader=new SAXReader();
		File file=new File("resource/xml_processer.xml");
		try {
			
			Document doc=saxReader.read(file);
			Element root=doc.getRootElement();
			Element actionmappings=root.element("action-mappings");
			for(Iterator j=actionmappings.elementIterator("action");j.hasNext();){
				Element am=(Element)j.next();
				ActionMapping actionMapping=new ActionMapping();
				actionMapping.setPath(am.attributeValue("path"));
				actionMapping.setType(am.attributeValue("type"));
				Map forward=new HashMap<>();
				for(Iterator k=am.elementIterator("forward");k.hasNext();){
					Element fo=(Element)k.next();
					forward.put((String)fo.attributeValue("name"),(String)fo.attributeValue("path"));
				}
				actionMapping.setForward(forward);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class ActionMapping{
	private String path;
	private String type;
	Map forward=new HashMap<>();
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Map getForward() {
		return forward;
	}
	public void setForward(Map forward) {
		this.forward = forward;
	}
	
	
}
