package dao;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import bean.Users;

public class dangnhapdao {
	public static File inputFile =  new File("C:\\Users\\annie\\eclipse-workspace-for-java2\\XMLProject\\users.xml");
	public int getMaxMaND() throws Exception{
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("user");
		return nList.getLength();
	}
	public Users getNgdung(String tdn, String mk) throws Exception{
		Users nd = null;
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("user");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String username = eElement.getElementsByTagName("username")
                        .item(0)
                        .getTextContent();
                String password = eElement.getElementsByTagName("password")
                        .item(0)
                        .getTextContent();
                if(username.equals(tdn)&&password.equals(mk)) {
                	int maKhach = Integer.parseInt(eElement.getAttribute("maKhach"));
                    String hoTen = eElement
                            .getElementsByTagName("hoTen")
                            .item(0)
                            .getTextContent();
                    nd = new Users(maKhach, hoTen, username, password);
                }
            }
        }
        return nd;
	}
}
