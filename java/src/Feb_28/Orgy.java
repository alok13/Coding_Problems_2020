package Feb_28;

import java.util.HashMap;
import java.util.*;

public class Orgy {

    public static void main(String[] args) {
        OrgChart org = new OrgChart();
        org.add("10", "Sharilyn Gruber", "-1");
        org.add("7", "Denice Mattice", "10");
        org.add("3", "Lawana Futrell", "-1");
        org.add("34", "Lissette Gorney", "7");
        org.add("5", "Lan Puls", "3");
        org.print();
        System.out.println("------------------");
        org.move("5", "10");
        org.print();
        System.out.println("-------------------");
        System.out.println(org.count("10"));
    }
}


 class OrgChart {

    static Map<String, Employee> empMap = new HashMap<>();

    public void add(String id, String name, String managerId) {
        Employee emp = new Employee(id, name, managerId);
        empMap.put(id, emp);
    }

    public void print() {
        Set<String> subOrdinateSet = new HashSet<>();
        Map<String, Set<Employee>> managerMap = new HashMap<>();
        for (Employee emp : empMap.values()) {
            if (!managerMap.containsKey(emp.managerId)) {
                managerMap.put(emp.managerId, new HashSet<>());
            } else {
                managerMap.get(emp.managerId).add(emp);
            }
        }
        fetchAll(managerMap, subOrdinateSet, "-1", "");
    }

    private void fetchAll(Map<String, Set<Employee>> managerMap, Set<String> subOrdinateSet, String managerId, String s) {
        Set<Employee> empSet = managerMap.getOrDefault(managerId, new HashSet<>());
        if (empSet.size() == 0)
            return;
        for (Employee emp : empSet) {
            if (!subOrdinateSet.contains(emp.id)) {
                System.out.println(s + emp);
                subOrdinateSet.add(emp.id);
                fetchAll(managerMap, subOrdinateSet, emp.id, s + "  ");
            }
        }
    }

    public void remove(String employeeId) {
        empMap.remove(employeeId);
    }

    public void move(String employeeId, String newManagerId) {
        empMap.get(employeeId).managerId = newManagerId;
    }

    public int count(String employeeId) {
        Set<String> subOrdinateSet = new HashSet<>();
        Map<String, Set<Employee>> managerMap = new HashMap<>();
        for (Employee emp : empMap.values()) {
            if (!managerMap.containsKey(emp.managerId)) {
                managerMap.put(emp.managerId, new HashSet<>());
            } else {
                managerMap.get(emp.managerId).add(emp);
            }
        }

        return lookForSub(managerMap, subOrdinateSet, employeeId);
    }

    private int lookForSub(Map<String, Set<Employee>> managerMap, Set<String> subOrdinateSet, String employeeId) {
        int count = 0;
        Set<Employee> empSet = managerMap.getOrDefault(employeeId, new HashSet<>());
        if (empSet.size() == 0)
            return 0;
        for (Employee emp : empSet) {
            if (!subOrdinateSet.contains(emp.id)) {
                subOrdinateSet.add(emp.id);
                count += 1 + lookForSub(managerMap, subOrdinateSet, employeeId);
            }
        }
        return count;
    }

}

class Employee {
    String id;
    String name;
    String managerId;

    public Employee(String id, String name, String managerId) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
    }

    public String toString() {
        return name + "[" + id + "]";
    }
}