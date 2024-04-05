package dao;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import bean.Users;

public class dangkydao {
	public static File inputFile =  new File("C:\\Users\\annie\\eclipse-workspace-for-java2\\XMLProject\\users.xml");
	public int KtDangKy(String username1) throws Exception{
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
                if(username.equals(username1)) return 0;
            }
        }
        return 1;
	}
	public void dangKy(int id1, String hoTen1, String username1, String password1) throws Exception{
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputFile);
        // bookstore
        Element users = document.getDocumentElement();
        //book
        Element user = document.createElement("user");
        users.appendChild(user);
        Attr at = document.createAttribute("maKhach");
        at.setValue(Integer.toString(id1));
        user.setAttributeNode(at);
        Element hoTen = document.createElement("hoTen");
        hoTen.appendChild(document.createTextNode(hoTen1));
        user.appendChild(hoTen);
        Element username = document.createElement("username");
        username.appendChild(document.createTextNode(username1));
        user.appendChild(username);
        //price
        Element password = document.createElement("password");
        password.appendChild(document.createTextNode(password1));
        user.appendChild(password);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(inputFile);
        transformer.transform(domSource, streamResult);
	}
}
