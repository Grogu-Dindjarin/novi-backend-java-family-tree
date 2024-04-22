import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Person {
    private static final Logger LOGGER = Logger.getLogger(Person.class.getName());

    private String name;
    private String middleName;
    private String lastName;
    private String age;
    private String sex;
    private Person mother;
    private Person father;
    private List<Person> siblings = new ArrayList<>();
    private List<Person> children = new ArrayList<>();
    private List<Pet> pets = new ArrayList<>();

    public Person(String name, String lastName, String age, String sex) {
        this(name, null, lastName, age, sex);
    }

    public Person(String name, String middleName, String lastName, String age, String sex) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public List<Person> getChildren() {
        return children;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void addChildren(Person child) {
        try {
            if (child != null) {
                this.children.add(child);
            } else {
                LOGGER.warning(String.format("Tried to add null child to %s", this.name));
            }
        } catch (NullPointerException e) {
            LOGGER.warning(String.format("NullPointerException occurred while adding child to %s: %s", this.name, e.getMessage()));
        }
    }

    public void addSibling(Person sibling) {
        try {
            if (sibling != null) {
                this.siblings.add(sibling);
            } else {
                String msg = String.format("Tried to add null sibling to %s", this.name);
                LOGGER.warning(msg);
            }
        } catch (NullPointerException e) {
            LOGGER.warning(String.format("NullPointerException occurred while adding sibling to %s: %s", this.name, e.getMessage()));
        }
    }

    public void addPet(Pet pet) {
        try {
            if (pet != null) {
                this.pets.add(pet);
            } else {
                String msg = String.format("Tried to add null pet to %s", this.name);
                LOGGER.warning(msg);
            }
        } catch (NullPointerException e) {
            LOGGER.warning(String.format("NullPointerException occurred while adding pet to %s: %s", this.name, e.getMessage()));
        }
    }

    public List<Person> getGrandchildren(List<Person> children) {
        List<Person> grandchildren = new ArrayList<>();
        try {
            if (children != null && !children.isEmpty()) {
                for (Person child : children) {
                    List<Person> childChildren = child.getChildren();
                    if (childChildren != null && !childChildren.isEmpty()) {
                        grandchildren.addAll(childChildren);
                    } else {
                        String msg = String.format("%s has no children.", child.getName());
                            LOGGER.info(msg);
                    }
                }
            } else {
                String msg = String.format("%s has no children.", this.name);
                LOGGER.info(msg);
            }
        } catch (NullPointerException e) {
            LOGGER.warning(String.format("NullPointerException occurred while retrieving grandchildren for %s: %s", this.name, e.getMessage()));
        }
        return grandchildren;
    }
}
