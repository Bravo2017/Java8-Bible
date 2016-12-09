import java.util.*;
import java.util.stream.*;
public class ClassicalSum{

	static List<LineItem> lineItems = Arrays.asList(
		new LineItem(10f),	
		new LineItem(10f),	
		new LineItem(10f)
	);
	
	public static void main(String args[]){
		System.out.println(getTotalPrice());
		System.out.println(getTotalPriceLambda());
	}
	
	public static float getTotalPrice() {
		float totalPrice = 0;
		if (lineItems != null) {
			for (LineItem item : lineItems) {
				if (item.getPrice() != null)
					totalPrice += item.getPrice();
			}   
		}   
		return totalPrice;
	}  
	public static double getTotalPriceLambda() {
		return lineItems.stream().mapToDouble(LineItem::getPrice).filter(Objects::nonNull).sum();
	}
	public static class LineItem{
		Float price;
		public LineItem(Float price){ this.price = price;}
		public Float getPrice(){return price;}
	}
}
