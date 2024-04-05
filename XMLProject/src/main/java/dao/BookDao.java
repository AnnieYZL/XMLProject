package dao;
import java.io.File;
import java.util.ArrayList;

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
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import bean.Book;
public class BookDao {
		public static File inputFile =  new File("C:\\Users\\annie\\eclipse-workspace-for-java2\\XMLProject\\books.xml");
		public static ArrayList<Book> ds;
		public long getMaxMaSach() throws Exception{
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        NodeList nList = doc.getElementsByTagName("book");
	        return nList.getLength();
		}
		public ArrayList<Book> getSach() throws Exception{
			ArrayList<Book> ds = new ArrayList<Book>();
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        NodeList nList = doc.getElementsByTagName("book");
	        for (int temp = 0; temp < nList.getLength(); temp++) {
	            Node nNode = nList.item(temp);
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	                Element eElement = (Element) nNode;
	                long id = Long.parseLong(eElement.getAttribute("id"));
	                String category = eElement.getAttribute("category");
	                String cover = eElement.getAttribute("cover");
	                String title = eElement
	                        .getElementsByTagName("title")
	                        .item(0)
	                        .getTextContent();
	                Node tNode = eElement.getElementsByTagName("title").item(0);
	                Element tElement = (Element) tNode;
	                String lang = tElement.getAttribute("lang");
	                NodeList lAuthor = eElement.getElementsByTagName("author");
	                ArrayList<String> author = new ArrayList<String>();
	                for(int i=0;i<lAuthor.getLength();i++) {
	                	String a = ((Element)lAuthor.item(i)).getTextContent();
	                	author.add(a);
	                }
	                
	                int year = Integer.parseInt(eElement
	                        .getElementsByTagName("year")
	                        .item(0)
	                        .getTextContent());
	                double price = Double.parseDouble(eElement
	                        .getElementsByTagName("price")
	                        .item(0)
	                        .getTextContent());
	                String image = eElement
	                        .getElementsByTagName("image")
	                        .item(0)
	                        .getTextContent();
	                ds.add(new Book(id, category, title, lang, author, cover, year, price, image));
	            }
	        }
	        return ds;
		}
		public Book inSach(long id1) throws Exception{
			Book s = null;
			ArrayList<Book> ds = getSach();
			for(Book sach:ds) {
				if(sach.getId()==id1) s = sach;
			}
			return s;
		}
		
		public void themSach(long id1, String category1, String cover1, String title1, String lang1, ArrayList<String> author1, int year1, double price1, String image1) throws Exception{
			
	        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputFile);
	        // bookstore
	        Element bookstore = document.getDocumentElement();
	        //book
	        Element book = document.createElement("book");
	        bookstore.appendChild(book);
	        Attr at = document.createAttribute("id");
	        at.setValue(Long.toString(id1));
	        book.setAttributeNode(at);
	        Attr attr = document.createAttribute("category");
	        attr.setValue(category1);
	        book.setAttributeNode(attr);
	        if(cover1==""||cover1==null) {
	        	int i = 1;
	        }
	        else {
	        	Attr atb = document.createAttribute("cover");
	            atb.setValue(cover1);
	            book.setAttributeNode(atb);
	        }
	        //tittle
	        Element title = document.createElement("title");
	        title.appendChild(document.createTextNode(title1));
	        book.appendChild(title);
	        Attr att = document.createAttribute("lang");
	        att.setValue(lang1);
	        title.setAttributeNode(att);
	        //author
	        for(String au:author1) {
	        	Element author = document.createElement("author");
	            author.appendChild(document.createTextNode(au));
	            book.appendChild(author);
	        }
	        //year
	        Element year = document.createElement("year");
	        year.appendChild(document.createTextNode(Integer.toString(year1)));
	        book.appendChild(year);
	        //price
	        Element price = document.createElement("price");
	        price.appendChild(document.createTextNode(Double.toString(id1)));
	        book.appendChild(price);
	        //Image
	        Element image = document.createElement("image");
	        image.appendChild(document.createTextNode(image1));
	        book.appendChild(image);
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        DOMSource domSource = new DOMSource(document);
	        StreamResult streamResult = new StreamResult(inputFile);
	        transformer.transform(domSource, streamResult);
	        System.out.println("Done creating XML File");
		}
		public void suaSach(long id1, String category1, String cover1, String title1, String lang1, ArrayList<String> author1, int year1, double price1, String image1) throws Exception{
			 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		        DocumentBuilder buider = factory.newDocumentBuilder();
		        Document doc = buider.parse(inputFile);
		        
		        doc.getDocumentElement().normalize();
		        NodeList nList = doc.getElementsByTagName("book");
		        for (int temp = 0; temp < nList.getLength(); temp++) {
		            Node nNode = nList.item(temp);
		            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		                Element eElement = (Element) nNode;
		                long id = Long.parseLong(eElement.getAttribute("id"));
		                if(id==id1) {
		                	NamedNodeMap attr = eElement.getAttributes();
		    		        Node nodeAttr = attr.getNamedItem("category");
		    		        nodeAttr.setTextContent(category1);
		    		        if(cover1==null||cover1=="") {
		    		        	int i=1;
		    		        }
		    		        else {
		    		        	Node nodeAttr1 = attr.getNamedItem("cover");
		    		        	nodeAttr1.setTextContent(cover1);
		    		        }
		    		        
		    		        // Cập nhập thẻ name
		    		        Element title = (Element) eElement.getElementsByTagName("title").item(0);
		    		        title.setTextContent(title1);
		    		        NamedNodeMap attr1 = title.getAttributes();
		    		        Node nodeAttra = attr1.getNamedItem("lang");
		    		        nodeAttra.setTextContent(lang1);
		    		        NodeList aList = eElement.getElementsByTagName("author");
		    		        	while(aList.getLength()!=0){
		    		        		Element tg = (Element)eElement.getElementsByTagName("author").item(0);
		    		        		eElement.removeChild(tg);
		    		        	}
		    		        	for(String au:author1) {
			    		        	Element author = doc.createElement("author");
			    		            author.appendChild(doc.createTextNode(au));
			    		            eElement.appendChild(author);
			    		        }
		    		        	Element year = (Element) eElement.getElementsByTagName("year").item(0);
			    		        year.setTextContent(Integer.toString(year1));
			    		        Element price = (Element) eElement.getElementsByTagName("price").item(0);
			    		        price.setTextContent(Double.toString(price1));
			    		        Element image = (Element) eElement.getElementsByTagName("image").item(0);
			    		        image.setTextContent(image1);
		                }
		        }
		        // Ghi xuống ổ đĩa
		        TransformerFactory transformerFactory = TransformerFactory.newInstance();
		        Transformer transformer = transformerFactory.newTransformer();
		        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		        DOMSource source = new DOMSource(doc);
		        StreamResult result = new StreamResult(inputFile);
		        transformer.transform(source, result);
		}
		        }
		public void xoaSach(long id1) throws Exception{
			 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		        DocumentBuilder buider = factory.newDocumentBuilder();
		        Document doc = buider.parse(inputFile);
		        
		        doc.getDocumentElement().normalize();
		        NodeList nList = doc.getElementsByTagName("book");
		        for (int temp = 0; temp < nList.getLength(); temp++) {
		            Node nNode = nList.item(temp);
		            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		                Element eElement = (Element) nNode;
		                long id = Long.parseLong(eElement.getAttribute("id"));
		                if(id==id1) {
		                	Element bookstore = doc.getDocumentElement();
		    		        bookstore.removeChild(eElement);
		                }
		        }
//		 
		        // Ghi xuống ổ đĩa
		        TransformerFactory transformerFactory = TransformerFactory.newInstance();
		        Transformer transformer = transformerFactory.newTransformer();
		        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		        DOMSource source = new DOMSource(doc);
		        StreamResult result = new StreamResult(inputFile);
		        transformer.transform(source, result);
		        }
		}
		        

}
