package Base;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "invalidEmailFormats")
    public Object[][] getInvalidEmailFormats(){
        return new Object[][]{
                {"samotekst"},
                {"tekstsa@"},
                {"@mail.com"},
                {"tekst@d"},
                {"tekst@mail.c"},
                {"tekst@mail,com"},
                {"tekst@mail.com@mail.com"},
                {"tekst@mail..com"},
                {"sa razmakom@mail . com"},
                {"nevalidnikarakteri#!@mail.com"}
        };
    }

    @DataProvider(name = "oneFieldFilled")
    public Object[][] getEmptyFields(){
        return new Object[][]{
                {"Ana", "", "", ""},
                {"", "test@mail.com", "", ""},
                {"", "", "Address 1", ""},
                {"", "", "", "Address 2"},
        };
    }

    @DataProvider(name = "twoFieldsFilled")
    public Object[][] getTwoFieldsFilled() {
        return new Object[][]{
                {"Ana", "test@mail.com", "", ""},
                {"Ana", "", "Address 1", ""},
                {"Ana", "", "", "Address 2"},
                {"", "test@mail.com", "Address 1", ""},
                {"", "test@mail.com", "", "Address 2"},
                {"", "", "Address 1", "Address 2"}
        };
    }

    @DataProvider(name = "threeFieldsFilled")
    public Object[][] getThreeFieldsFilled() {
        return new Object[][]{
                {"Ana", "test@mail.com", "Address 1", ""},
                {"Ana", "test@mail.com", "", "Address 2"},
                {"Ana", "", "Address 1", "Address 2"},
                {"", "test@mail.com", "Address 1", "Address 2"}
        };
    }

}
