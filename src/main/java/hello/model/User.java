package hello.model;

public class User {
    //    private static final long serialVersionUID = 1L;
    public String id, name, email;

//    public class UserAddress {
//        String street;
//        String houseNumber;
//        String city;
//        String country;
//
//        UserAddress(String street, String houseNumber, String city, String country ){
//            this.street= street;
//            this.houseNumber= houseNumber;
//            this.city= city;
//            this.country= country;
//        }
//
//        public String getStreet(){
//            return this.street;
//        }
//    }

    public String getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getEmail()
    {
        return email;
    }

    public void setId(String id)
    {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return id + " " + name + " " + email;
    }
}