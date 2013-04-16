package org.szimano;

import java.util.List;

public class UserJAO {

    private String name;

    private String lastName;

    private String shoeSize;

    private List<AddressJAO> addresses;

    // java nonsense


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(String shoeSize) {
        this.shoeSize = shoeSize;
    }

    public List<AddressJAO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressJAO> addresses) {
        this.addresses = addresses;
    }
}
