package dao;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

import bean.HoaDon;

public class hoadondao {
	
	public static File inputFile =  new File("C:\\Users\\annie\\eclipse-workspace-for-java2\\XMLProject\\hoadon.xml");
	public void ThemHoaDon(long mahd, long makh, Date ngay, long idsach, int sl) throws Exception{
	        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputFile);
	        // bookstore
	        Element danhsachhoadon = document.getDocumentElement();
	        //book
	        Element hoadon = document.createElement("hoadon");
	        danhsachhoadon.appendChild(hoadon);
	        Attr at = document.createAttribute("maHoaDon");
	        at.setValue(Long.toString(mahd));
	        hoadon.setAttributeNode(at);
	        Element maKhach = document.createElement("maKhach");
	        maKhach.appendChild(document.createTextNode(Long.toString(makh)));
	        hoadon.appendChild(maKhach);
	        Element ngayMua = document.createElement("ngayMua");
	        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        ngayMua.appendChild(document.createTextNode(dateFormat.format(ngay)));
	        hoadon.appendChild(ngayMua);
	        Element id = document.createElement("id");
	        id.appendChild(document.createTextNode(Long.toString(idsach)));
	        hoadon.appendChild(id);
	        Element soluong = document.createElement("soLuong");
	        soluong.appendChild(document.createTextNode(Integer.toString(sl)));
	        hoadon.appendChild(soluong);
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        DOMSource domSource = new DOMSource(document);
	        StreamResult streamResult = new StreamResult(inputFile);
	        transformer.transform(domSource, streamResult);
		
	}
	public long getMaxHD() throws Exception{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("hoadon");
        return nList.getLength();
	}
	public ArrayList<HoaDon> getLichsu(long mkh) throws Exception{
		ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("hoadon");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                long maKhach = Long.parseLong(eElement
                        .getElementsByTagName("maKhach")
                        .item(0)
                        .getTextContent());
                if(maKhach==mkh) {
                	long maHoaDon = Long.parseLong(eElement.getAttribute("maHoaDon"));
                    
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date ngaymua = dateFormat.parse(eElement
                            .getElementsByTagName("ngayMua")
                            .item(0)
                            .getTextContent());
                    long id = Long.parseLong(eElement
                            .getElementsByTagName("id")
                            .item(0)
                            .getTextContent());
                    int soluong = Integer.parseInt(eElement
                            .getElementsByTagName("soLuong")
                            .item(0)
                            .getTextContent());
                    
                    ds.add(new HoaDon(maHoaDon, maKhach, ngaymua, id, soluong));
                }
                
            }
        }
        return ds;
	}
}
