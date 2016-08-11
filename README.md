## How to use

First of all you need you need a model class with public getters and setters for all the fields you wany to be represented in the TableView.

    public class Person {
        private String firstName;
        private String lastName;
        private String email;
        private int age;
    
        public Person(String firstName, 
            String lastName, String email, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.age = age;
        }
    
        public String getFirstName() {
            return firstName;
        }
    
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    
        public String getLastName() {
            return lastName;
        }
    
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    
        public String getEmail() {
            return email;
        }
    
        public void setEmail(String email) {
            this.email = email;
        }
    
        public int getAge() {
            return age;
        }
    
        public void setAge(int age) {
            this.age = age;
        }
    }
Note that naming convention is important. If a field is called `id` then getter shall be called `getId` and setter shall be called `setId`. If this requirement is not satisfied the field will not be represented in the TableView.

Then to generate the TableView you just need to use `buildUpon(Class<?>)` method.

    TableView<Person> personTable = ModelTableViewBuilder.buildUpon(Person.class);
    
And now you can populate it using `ObservableList<Person>`

    ObservableList<Person> data = FXCollections.observableArrayList(people);
    personTable.setItems(data);
    
TableView is ready to be shown in the layout

    container.getChildren().add(personTable);

Here is what you get
    
[![Screenshot from 2016-08-11 12:38:44.png](https://s10.postimg.org/6ptry56d5/Screenshot_from_2016_08_11_12_38_44.png)](https://postimg.org/image/evbtwaulx/)