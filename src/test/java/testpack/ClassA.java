package testpack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassA {
	public static void main(String[] args) {
		Datas d = new Datas();
		System.out.println(d.getId());
		System.out.println(d.getName());

		Datas d1 = new Datas();
		d1.setId(100);
		d1.setName("B");
		System.out.println(d1.getId());
		System.out.println(d1.getName());

		List<Datas> l = new ArrayList<>();
		l.add(d);
		l.add(d1);
		System.out.println(l.get(0).getId());
		System.out.println(l.get(1).getId());

		Map<Integer, Datas> m = new HashMap<Integer, Datas>();
		m.put(1, d);
		m.put(2, d1);

		String name = m.get(1).getName();

		Collection<Datas> values = m.values();
		for (Datas datas : values) {
			int id = datas.getId();
		}
	}

}
