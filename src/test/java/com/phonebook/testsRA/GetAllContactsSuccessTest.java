package com.phonebook.testsRA;

import com.phonbook.dto.AllContactsDto;
import com.phonbook.dto.ContactDto;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllContactsSuccessTest extends TestBase {

    @Test
    public void getAllContactsSuccessTest() {
        AllContactsDto contactsDto = given()
                .header(AUTH, TOKEN)
                .when()
                .get("contacts")
                .then()
                .assertThat().statusCode(200)
.extract().body().as(AllContactsDto.class);

        for (ContactDto contact: contactsDto.getContacts()) {
            System.out.println(contact.getId() + " *** " + contact.getName() );
            System.out.println("===========================================================");

        }
    }

}//class
