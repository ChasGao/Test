package Arrays;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class dd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> str=new ArrayList<String>();
		Object obj1=new String("ab");
		Object obj2=new String("ce");
		 addEle(str, "as");
		 addEle(str, "af");
	}

	public static ArrayList addEle (ArrayList array, Object obj){
		if(!array.contains(obj)){
			array.add(obj);
		}
		return array;
	}
	
}
