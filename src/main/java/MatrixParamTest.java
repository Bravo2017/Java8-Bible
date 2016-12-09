import java.util.stream.*;
import java.util.*;

public class MatrixParamTest{
	
	public static void main(String args[]){
		PathSegment p = getPathSegment();
		System.out.println(matrixparamtest(p));
		System.out.println(matrixparamtestlambda(p));
	}	

	public static String matrixparamtest(PathSegment id){
		 StringBuffer sb = new StringBuffer();
		 sb.append("matrix=");

		 sb.append("/" + id.getPath());
		 Map<String, String> matrix = id.getMatrixParameters();
		 Set keys = matrix.keySet();
		 for (Object key : keys)
		 {
		    sb.append(";" + key.toString() + "=" +
			    matrix.get(key.toString()));

		 }
		 return sb.toString();
	}

	public static String matrixparamtestlambda(PathSegment id){
		Map<String, String> matrix = id.getMatrixParameters();
		String keys = matrix.keySet().stream()
			.map(k -> k + "=" + matrix.get(k))
			.collect(Collectors.joining(";", ";", ""));
		return "matrix=/"+id.getPath()+keys;

	}
	public static PathSegment getPathSegment(){
		return new PathSegment(){
		public	String getPath(){
				return "myPath";
			}
		public	Map<String, String> getMatrixParameters(){
				HashMap<String, String> m = new HashMap<>();
				m.put("param1", "val1");
				m.put("param2", "val2");
				m.put("param3", "val3");
				return m;
			}
		};
	}

	public static interface PathSegment{
	   String getPath();
	   Map<String, String> getMatrixParameters();

	}

}
