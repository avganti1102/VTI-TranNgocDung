package Assignment3;

import java.util.Collection;

public class Ex5 {
	public static void main(String[] args) {
// Create Department
		Department department1 = new Department();
		department1.ID = 1;
		department1.Name = "Accounting";

		Department department2 = new Department();
		department2.ID = 2;
		department2.Name = "Boss of director";

		Department department3 = new Department();
		department3.ID = 3;
		department3.Name = "Sale";
		
		Department department4 = new Department();
		department4.ID = 4;
		department4.Name = "Marketing";
		
		Department department5 = new Department();
		department5.ID = 5;
		department5.Name = "Waiting room";
		
		Department[] dep = {department1,department2,department3,department4,department5};
		
// Q6
		String temp = "";
        for (int i = 0 ; i < dep.length - 1; i++) {
            for (int j = i + 1; j < dep.length; j++) {
                if (dep[i].Name.charAt(0) > dep[j].Name.charAt(0)) {
                    temp = dep[j].Name;
                    dep[j].Name = dep[i].Name;
                    dep[i].Name = temp;
                }
            }
		for(Department a : dep){
			System.out.println(a.Name);
		}
        }
	}
}
