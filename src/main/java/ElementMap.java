import java.util.*;
import java.util.stream.*;

public class ElementMap{

	public static void main(String args[]){
		Map<String, Element> mOriginal = mapElements();
		Map<String, Element> mLambda = mapElements();
		System.out.println("\nOriginal Output:\n--");
		mOriginal.keySet().stream().map(k -> k + " : " + mOriginal.get(k)).forEach(System.out::println);
		System.out.println("\nWith Lambda Output:\n--");
		mLambda.keySet().stream().map(k -> k + " : " + mLambda.get(k)).forEach(System.out::println);
	}

	public static Map<String, Element> mapElements(){
		final Map<String, Element> map = new HashMap<String, Element>();
		for (final Element element : values()) {
			final String name = element.getLocalName();
			if (name != null)
				map.put(name, element);
		} 
		return map;  
	}	
	public static Map<String, Element> mapElementsLambda(){
		return values().stream()
			.filter(e -> e.getLocalName() != null)
			.collect(Collectors.toMap(Element::getLocalName, e -> e));
	}
	private static List<Element> values(){
		return Arrays.asList(
			new Element("some name"),
			new Element(null),
			new Element("other"),
			new Element(null)

		);
	}

	private static class Element{
		private String localName;
		public Element(String localName){ this.localName = localName;}
		private String getLocalName(){return localName;}
	}

	private static void printEntry(Map.Entry e){
		System.out.println(e.getKey() + " : " + e.getValue());	
	}
}
