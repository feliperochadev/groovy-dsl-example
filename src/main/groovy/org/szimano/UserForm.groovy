package org.szimano

public class UserForm extends ExampleForm<UserJAO> {

    UserForm() {
        super(UserJAO)
    }

    @Override
    def formDefinition(UserJAO u) {

        section("personDetails")
        row(u.name, u.lastName)
        row(u.shoeSize)

        table("addressDetails", u.addresses, columns({
            AddressJAO a -> [a.street, a.streetNumber, a.appartmentNumber, a.city, a.country]
        }))
    }

    public static void main(String[] args) {
        println new UserForm().parse();
    }
}